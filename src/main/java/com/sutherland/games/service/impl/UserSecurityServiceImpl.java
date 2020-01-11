package com.sutherland.games.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sutherland.games.repository.MemberRepository;
import com.sutherland.games.service.UserSecurityService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Service
@RequiredArgsConstructor
public class UserSecurityServiceImpl implements UserSecurityService {

	private final MemberRepository memberRepository;
	private final AuthenticationManager authenticationManager;

	@Override
	public void autoLogin(String username, String password) {
		UserDetails userDetails = memberRepository.findByPhoneOrEmail(username);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
		authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			log.info(String.format("Auto login %s successfully!", username));
		}
	}

}
