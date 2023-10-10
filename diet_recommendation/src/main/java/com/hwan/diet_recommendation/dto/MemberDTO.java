package com.hwan.diet_recommendation.dto;

import com.hwan.diet_recommendation.entity.Member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    
    @NotBlank(message = "이름은 필수 기재사항입니다.")
    private String name;
    
    @NotBlank(message = "별명은 필수 기재사항입니다.")
    private String username;

    @NotBlank(message = "비밀번호는 필수 기재사항입니다.")
    private String password;

    public MemberDTO(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    //회원가입
    public MemberDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //로그인
    public Member toEntity(MemberDTO memberDTO) {
        Member member = Member.builder()
                            .username(username)
                            .password(password)
                            .name(name)
                            .build();
        
        return member;
    }
}
