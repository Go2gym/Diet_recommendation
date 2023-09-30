package com.hwan.diet_recommendation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hwan.diet_recommendation.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    
}
