package com.hwan.diet_recommendation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.hwan.diet_recommendation.dto.MemberDTO;
import com.hwan.diet_recommendation.service.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
    //member와 관련있는 것들(로그인, 회원가입, 추후 마이페이지)
    private final MemberServiceImpl memberServiceImpl;
    
    @PostMapping("/login")
    public void postLogin() {
        
    }

    @PostMapping("/register")
    public String postRegister(MemberDTO memberDTO) {
        System.out.println(memberDTO.getUsername());
        Long memberId = memberServiceImpl.join(memberDTO);
        return "home";
    }
}
