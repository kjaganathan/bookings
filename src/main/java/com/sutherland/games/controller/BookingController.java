package com.sutherland.games.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sutherland.games.enums.BookingStatus;
import com.sutherland.games.model.Booking;
import com.sutherland.games.service.BookingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Controller
@RequiredArgsConstructor
public class BookingController {

	private final BookingService bookingService;

	@GetMapping("/bookings")
	public String bookings(Model model, Pageable pageable) {
		log.fine("bookings list page");
		Page<Booking> booking = bookingService.findAll(pageable);
		model.addAttribute("bookings", booking.getContent());
		model.addAttribute("totalElements", booking.getTotalElements());
		return "bookings";
	}
	
	@GetMapping("/bookings/new")
	public String bookingsNew(Model model) {
		log.fine("Loading new booking page...");
		return "newBooking";
	}
	
	@PostMapping("/bookings/new")
	public String bookingsNew(@ModelAttribute @Valid Booking booking) {
		log.info("adding new booking... {} "+booking);
		booking.setStatus(BookingStatus.Booked.name());
		bookingService.save(booking);
		return "redirect:/bookings";
	}

}
