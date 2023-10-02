package com.hwan.diet_recommendation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.hwan.diet_recommendation.dto.MemberDTO;
import com.hwan.diet_recommendation.service.MemberService;
import com.hwan.diet_recommendation.service.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
    //member와 관련있는 것들(로그인, 회원가입, 추후 마이페이지)
    private final MemberServiceImpl memberServiceImpl;
    //private final MemberService memberService;
    
    @PostMapping("/login")
    public void postLogin(String username, String password) {
        memberServiceImpl.login(username, password);
    }

    @PostMapping("/register")
    public String postRegister(MemberDTO memberDTO) {
        if(memberServiceImpl.join(memberDTO)) {
            return "/home";
        }
        else {
            return "/member/register";
        }
    }

    
}
