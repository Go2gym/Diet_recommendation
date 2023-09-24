package com.hwan.diet_recommendation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController { //기본 홈 화면
    
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
