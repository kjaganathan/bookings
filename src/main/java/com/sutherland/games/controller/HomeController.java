package com.sutherland.games.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Controller
@RequiredArgsConstructor
public class HomeController {

	@GetMapping("/")
	public String home(Model model) throws IOException {
		log.fine("Home page");
		model.addAttribute("name", System.currentTimeMillis());
		return "home";
	}

}
