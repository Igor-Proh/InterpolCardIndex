package com.prokhnov.interpolCardIndex.controller;

import com.prokhnov.interpolCardIndex.model.User;
import com.prokhnov.interpolCardIndex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The {@code AuthenticationController} class.<br/>
 * Class that provide methods with mapping for authentication.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Controller
public class AuthenticationController {

    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register_page";
    }

    @PostMapping("/register/save")
    public String registerSave(@ModelAttribute User user){
        userService.save(user);
        return "redirect:/home";
    }

    @RequestMapping
    public String logout(){
        return "redirect:/";
    }
}
