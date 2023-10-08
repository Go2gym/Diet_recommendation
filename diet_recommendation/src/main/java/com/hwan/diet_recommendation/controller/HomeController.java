package com.hwan.diet_recommendation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
public class HomeController { //기본 홈 화면
    @GetMapping("")
    public String home(@SessionAttribute(name = "username", required = false) String username) {
        if(username != null) {
            return "/member/memberHome";
        }
        
        return "home";
    }

    @GetMapping("login")
    public String getLogin() {
        return "/member/login";
    }

    @GetMapping("register")
    public String getResiter() {
        return "/member/register";
    }
}