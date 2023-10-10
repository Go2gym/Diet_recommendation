package com.hwan.diet_recommendation.service;

import java.util.Optional;

import com.hwan.diet_recommendation.dto.MemberDTO;
import com.hwan.diet_recommendation.entity.Member;

public interface MemberService {
    public boolean join(MemberDTO memberDTO);
    public Member login(MemberDTO memberDTO);

    public Optional<Member> findMemberByUsername(String username);
    public Optional<Member> findMemberByPassword(String password);
}
