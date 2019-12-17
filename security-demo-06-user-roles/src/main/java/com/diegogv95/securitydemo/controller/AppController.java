package com.diegogv95.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/employees")
    public String showEmployees() {
        return "employees";
    }

    @GetMapping("/leaders")
    public String showLeaders() {
        return "leaders";
    }

    @GetMapping("/systems")
    public String showSystems() {
        return "systems";
    }

    @GetMapping("/error-page")
    public String showErrorPage() {
        return "error";

    }
}
