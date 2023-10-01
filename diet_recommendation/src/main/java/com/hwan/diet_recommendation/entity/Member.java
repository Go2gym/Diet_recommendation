package com.hwan.diet_recommendation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", nullable = false, unique=true)
    private String username;

    @Column(name= "password", nullable = false)
    private String password;

    @Column(name="name", nullable = false)
    private String name;

    @Builder
    public Member(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }
}
