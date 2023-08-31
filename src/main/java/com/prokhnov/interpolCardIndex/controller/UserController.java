package com.prokhnov.interpolCardIndex.controller;

import com.prokhnov.interpolCardIndex.exceptions.UserWithCurrentEmailAlreadyExistException;
import com.prokhnov.interpolCardIndex.exceptions.UserWithCurrentNameAlreadyExistException;
import com.prokhnov.interpolCardIndex.model.User;
import com.prokhnov.interpolCardIndex.repository.RoleRepository;
import com.prokhnov.interpolCardIndex.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The {@code UserController} class.<br/>
 * Class that provide methods with mapping for User.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final RoleRepository roleRepository;

    @Autowired
    public UserController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/listOfUsers")
    public String userListPage(Model model, HttpServletRequest request) {
        List<User> allUsers = userService.findAllUsers();
        model.addAttribute("userList", allUsers);
        model.addAttribute("userName", request.getRemoteUser());
        return "user/user_list_page";
    }

    @GetMapping("/userDelete/{userId}")
    public String deleteUser(@PathVariable Long userId, Model model) {
        userService.deleteUserById(userId);
        List<User> allUsers = userService.findAllUsers();
        model.addAttribute("userList", allUsers);
        return "redirect:/user/listOfUsers";
    }

    @GetMapping("/userAdd")
    public String showAddUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("allRoles", roleRepository.findAll());
        return "user/user_add_update_page";
    }

    @PostMapping("/userSave")
    public String saveUser(@ModelAttribute User user, Model model) {
        try {
            userService.save(user);
        } catch (UserWithCurrentNameAlreadyExistException | UserWithCurrentEmailAlreadyExistException e) {
            model.addAttribute("existMessage", e.getMessage());
            model.addAttribute("user", user);
            model.addAttribute("allRoles", roleRepository.findAll());
            return "user/user_add_update_page";
        }
        return "redirect:/user/listOfUsers";
    }

    @GetMapping("/userUpdate/{id}")
    public String updateUser(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("readOnly", true);
        return "user/user_add_update_page";
    }

    @PostMapping("/userUpdate/{id}")
    public String updateUser(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/user/listOfUsers";
    }

}
