package com.hwan.diet_recommendation.dto;

import com.hwan.diet_recommendation.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String name;
    private String username;
    private String password;

    public MemberDTO(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Member toEntity(MemberDTO memberDTO) {
        Member member = Member.builder()
                            .username(username)
                            .password(password)
                            .name(name)
                            .build();
        
        return member;
    }
}
