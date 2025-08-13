package com.mergingtonhigh.schoolmanagement.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for serving static content.
 */
@Controller
public class StaticController {

    /**
     * Serve the main index page.
     */
    @GetMapping("/")
    public String index() {
        return "forward:/static/index.html";
    }
}