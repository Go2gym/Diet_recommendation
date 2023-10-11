package com.hwan.diet_recommendation.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hwan.diet_recommendation.dto.MemberDTO;
import com.hwan.diet_recommendation.entity.Member;
import com.hwan.diet_recommendation.repository.MemberRepository;

@SpringBootTest
@WebAppConfiguration
public class MemberServiceImplTest {

    @Autowired 
    MemberRepository memberRepository;
    @Autowired
    MemberServiceImpl memberServiceImpl;

    private Member member;

    @BeforeEach
    void init() {
        member = Member.builder()
                        .name("hwan")
                        .nickname("hwan")
                        .username("d")
                        .password("d")
                        .build();

        memberRepository.save(member);
    }

    @Test
    void 중복체크() {
        MemberDTO memberDTO = new MemberDTO("hwan", "hwan", "d", "d");

        Member member = memberServiceImpl.findMemberByUsername(memberDTO.getUsername()).get();
        assertThat(member.getUsername()).isEqualTo(memberDTO.getUsername());
    }

    @Test
    void 정상join() {
        MemberDTO memberDTO = new MemberDTO("lee", "lee", "a", "nicka");

        boolean check = memberServiceImpl.join(memberDTO);
        
        System.out.println(check);

        //assertThat(joinMember.getUsername()).isEqualTo("a");
        //assertThat(joinMember.getNickname()).isEqualTo("nicka");
    }

}
