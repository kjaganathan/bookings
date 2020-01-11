package com.sutherland.games.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sutherland.games.model.Member;
import com.sutherland.games.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/members")
	public String bookings(Model model, Pageable pageable) {
		log.fine("bookings list page");
		Page<Member> members = memberService.findAll(pageable);
		model.addAttribute("members", members);
		return "members";
	}

	@PostMapping("/members")
	public String addBookings(@ModelAttribute @Valid Member member) {
		log.fine("member add new");
		memberService.save(member);
		return "redirect:/members";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute @Valid Member member) {
		log.fine("register add new");
		member = memberService.register(member);
		return "redirect:/home?message=You have successfully registered. login with phone or email and given password while registering yourself";
	}

}
