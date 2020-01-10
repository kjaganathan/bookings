package com.sutherland.games.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sutherland.games.model.Member;
import com.sutherland.games.repository.MemberRepository;
import com.sutherland.games.service.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	@Override
	public Member save(Member member) {
		return memberRepository.save(member);
	}

	@Override
	public Page<Member> findAll(Pageable pageable) {
		return memberRepository.findAll(pageable);
	}
	

}
