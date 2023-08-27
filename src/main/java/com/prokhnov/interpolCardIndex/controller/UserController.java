package com.prokhnov.interpolCardIndex.controller;

import com.prokhnov.interpolCardIndex.model.User;
import com.prokhnov.interpolCardIndex.repository.RoleRepository;
import com.prokhnov.interpolCardIndex.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String userListPage(Model model) {
        List<User> allUsers = userService.findAllUsers();
        model.addAttribute("userList", allUsers);
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
    public String saveUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/user/listOfUsers";
    }


    @GetMapping("/userUpdate/{id}")
    public String updateUser(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("allRoles", roleRepository.findAll());
        return "user/user_add_update_page";
    }

    @PostMapping("/userUpdate/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        User existingUser = userService.getUserById(id);

        if (existingUser != null) {
            BeanUtils.copyProperties(user, existingUser, "id");
            userService.save(existingUser);
        }

        return "redirect:/user/listOfUsers";
    }

}
