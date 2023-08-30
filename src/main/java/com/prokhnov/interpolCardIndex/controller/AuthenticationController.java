package com.prokhnov.interpolCardIndex.controller;

import com.prokhnov.interpolCardIndex.common.VerifyRecaptcha;
import com.prokhnov.interpolCardIndex.exceptions.UserWithCurrentEmailAlreadyExistException;
import com.prokhnov.interpolCardIndex.exceptions.UserWithCurrentNameAlreadyExistException;
import com.prokhnov.interpolCardIndex.model.User;
import com.prokhnov.interpolCardIndex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

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
    @Value("${captcha.siteKey}")
    private String captchaSiteKey;
    private final VerifyRecaptcha verifyRecaptcha;

    @Autowired
    public AuthenticationController(UserService userService, VerifyRecaptcha verifyRecaptcha) {
        this.userService = userService;
        this.verifyRecaptcha = verifyRecaptcha;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("captchaSiteKey", captchaSiteKey);
        return "register_page";
    }

    @PostMapping("/register/save")
    public String registerSave(@ModelAttribute User user, Model model, HttpServletRequest request) {

        String gRecaptchaResponse = request
                .getParameter("g-recaptcha-response");
        boolean verify = verifyRecaptcha.verify(gRecaptchaResponse);

        if (verify) {
            try {
                userService.save(user);
                return "redirect:/home?success";
            } catch (UserWithCurrentNameAlreadyExistException | UserWithCurrentEmailAlreadyExistException e) {
                model.addAttribute("existMessage", e.getMessage());
                model.addAttribute("user", user);
                model.addAttribute("captchaSiteKey", captchaSiteKey);
                return "register_page";
            }
        }
        model.addAttribute("verifyFail", "Confirm that you are not robot");
        model.addAttribute("captchaSiteKey", captchaSiteKey);
        return "register_page";

    }

    @RequestMapping
    public String logout() {
        return "redirect:/";
    }
}
