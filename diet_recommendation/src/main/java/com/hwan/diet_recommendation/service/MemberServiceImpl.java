package com.hwan.diet_recommendation.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwan.diet_recommendation.dto.MemberDTO;
import com.hwan.diet_recommendation.entity.Member;
import com.hwan.diet_recommendation.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Member join(MemberDTO memberDTO) {
        Member member = memberDTO.toEntity(memberDTO);
        if (findMemberByUsername(member.getUsername()).isPresent()) {
            throw new RuntimeException();
        }

        return memberRepository.save(member);
    }
    
    

    @Override
    public Optional<Member> findMemberByUsername(String username) {

        return memberRepository.findByUsername(username);
    }

    
    @Override
    public Member login(String username, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
}
