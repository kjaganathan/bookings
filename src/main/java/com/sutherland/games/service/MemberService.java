package com.sutherland.games.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sutherland.games.model.Member;

public interface MemberService {

	Member save(Member member);

	Page<Member> findAll(Pageable pageable);

	Member register(Member member);

}
