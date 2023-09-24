package com.hwan.diet_recommendation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hwan.diet_recommendation.dto.MemberDTO;
import com.hwan.diet_recommendation.service.MemberService;

@Controller
public class MemberController {
    //member와 관련있는 것들(로그인, 회원가입, 추후 마이페이지)
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    @GetMapping("/login")
    public String getLogin() {
        return "/member/login";
    }

    @PostMapping("/login")
    public void postLogin() {
        
    }

    @GetMapping("/register")
    public String getResiter() {
        return "/member/register";
    }

    @PostMapping("/reigister")
    public void postRegister(MemberDTO MemberDTO) {

    }
}
