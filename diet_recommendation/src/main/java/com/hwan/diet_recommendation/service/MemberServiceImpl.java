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
    public Member login(MemberDTO memberDTO) {
        Optional<Member> findMember = findMemberByUsername(memberDTO.getUsername());

        //찾은 username이 없으면 null 반환
        if(findMember.isEmpty()) {
            return null;
        }

        Member member = findMember.get();

        //찾은 member의 비밀번호와 입력받은 비밀번호가 다르면 null반환
        if(!member.getPassword().equals(memberDTO.getPassword())) {
            return null;
        }

        return member;
    }

    @Override
    public Optional<Member> findMemberByUsername(String username) {
        return memberRepository.findMemberByUsername(username);
    }

    @Override
    public Optional<Member> findMemberByPassword(String password) {
        return memberRepository.findMemberByPassword(password);
    }
}
