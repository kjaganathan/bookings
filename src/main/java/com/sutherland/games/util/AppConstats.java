package com.sutherland.games.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.sutherland.games.model.Member;

public class AppConstats {
	
	private AppConstats() {
	}

	public static Member getSessionUser(){
		Object member = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (member instanceof Member) {
        	return (Member) member;
        }
		return null;
	}
}
