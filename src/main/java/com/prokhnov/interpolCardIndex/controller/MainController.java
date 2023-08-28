package com.prokhnov.interpolCardIndex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * The {@code MainController} class.<br/>
 * Class that provide methods with mapping for home_page.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Controller
public class MainController {

    @GetMapping({"/", "/home"})
    public String homePage() {
        return "home_page";
    }

}