package com.sutherland.games.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sutherland.games.model.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Controller
@RequiredArgsConstructor
public class HomeController {

	@GetMapping("/")
	public String defaultPage() {
		log.fine("default page page");
		return "home";
	}

	@GetMapping("/welcome")
	public String welcomePage(HttpSession session) {
		log.fine("welcome page page");
		Object member = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (member instanceof Member) {
			session.setAttribute("member", (Member) member);
		}
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home(Model model, @RequestParam(value = "message", required = false) String message) {
		log.fine("Home page");
		model.addAttribute("message", message);
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		log.fine("login page...");
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		log.fine("register page...");
		return "reg";
	}

}
