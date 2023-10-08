package com.hwan.diet_recommendation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import com.hwan.diet_recommendation.dto.MemberDTO;
import com.hwan.diet_recommendation.entity.Member;
import com.hwan.diet_recommendation.service.MemberServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
    //member와 관련있는 것들(로그인, 회원가입, 추후 마이페이지)
    private final MemberServiceImpl memberServiceImpl;
    //private final MemberService memberService;
    
    @PostMapping("/login")
    public String postLogin(MemberDTO memberDTO, HttpServletRequest request, BindingResult bindingResult) {
        Member member = memberServiceImpl.login(memberDTO);
        
        if(member == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "/member/login";
        }
        
        //세션을 생성하기 전 기존 세션 파기
        request.getSession().invalidate();
        HttpSession session = request.getSession(true);
        
        //세션에 username넣어줌
        session.setAttribute("username", member.getUsername());
        session.setMaxInactiveInterval(1800);
        return "/member/memberHome";
    }

    @PostMapping("/register")
    public String postRegister(MemberDTO memberDTO, BindingResult bindingResult) {
        if(memberServiceImpl.join(memberDTO)) {
            return "/home";
        }
        else {
            bindingResult.addError(null);
            return "/member/register";
        }
    }

    @PostMapping("/signout")
    public String sighOut(HttpSession session) {
        session.invalidate();
        return "/home";
    }
}
