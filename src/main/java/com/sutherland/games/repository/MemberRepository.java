package com.sutherland.games.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sutherland.games.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

}
