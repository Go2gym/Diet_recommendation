package com.hwan.diet_recommendation.service;

import org.springframework.stereotype.Service;

import com.hwan.diet_recommendation.dto.MemberDTO;
import com.hwan.diet_recommendation.entity.Member;
import com.hwan.diet_recommendation.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public Long join(MemberDTO memberDTO) {
        Member member = Member.builder()
                            .username(memberDTO.getUsername())
                            .password(memberDTO.getPassword())
                            .name(memberDTO.getName())
                            .build();
        return memberRepository.save(member).getId();
    }
    
}
