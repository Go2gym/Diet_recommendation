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
    public boolean join(MemberDTO memberDTO) {
        Member member = memberDTO.toEntity(memberDTO);
        //true:객체에 값이 있으므로 아이디 중복 O
        if (findMemberByUsername(member.getUsername()).isPresent()) {
            return false;
        }

        memberRepository.save(member);
        return true;
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
