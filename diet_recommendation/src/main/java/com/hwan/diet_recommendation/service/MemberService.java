package com.hwan.diet_recommendation.service;

import java.util.Optional;

import com.hwan.diet_recommendation.dto.MemberDTO;
import com.hwan.diet_recommendation.entity.Member;

public interface MemberService {
    public boolean join(MemberDTO memberDTO);

    public Optional<Member> findMemberByUsername(String username);

    public Member login(String username, String password);
}
