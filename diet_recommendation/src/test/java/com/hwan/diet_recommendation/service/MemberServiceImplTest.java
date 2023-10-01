package com.hwan.diet_recommendation.service;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hwan.diet_recommendation.dto.MemberDTO;
import com.hwan.diet_recommendation.entity.Member;
import com.hwan.diet_recommendation.repository.MemberRepository;

@SpringBootTest
public class MemberServiceImplTest {

    @Autowired 
    MemberRepository memberRepository;
    @Autowired
    MemberServiceImpl memberServiceImpl;

    private Member member;

    @BeforeEach
    void init() {
        memberRepository.deleteAll();
        member = Member.builder()
                        .name("hwan")
                        .username("hwan")
                        .password("d")
                        .build();

        memberRepository.save(member);
    }

    @Test
    void 중복체크() {
        MemberDTO memberDTO = new MemberDTO("hwan", "hwan", "d");

        Member member = memberServiceImpl.findMemberByUsername(memberDTO.getUsername()).orElse(new Member());
        assertThat(member.getUsername()).isEqualTo(memberDTO.getUsername());
    }

    @Test
    void 정상join() {
        MemberDTO memberDTO = new MemberDTO("lee", "a", "a");

        Member joinMember = memberServiceImpl.join(memberDTO);

        assertThat(joinMember.getUsername()).isEqualTo("a");
    }

}
