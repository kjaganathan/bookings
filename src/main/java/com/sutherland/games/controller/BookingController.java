package com.sutherland.games.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String bookings(Model model, @RequestParam(value = "searchText", required = false) String searchText, Pageable pageable) {
		log.fine("bookings list page");
		List<Booking> bookings = bookingService.findByMemberId(searchText);
		model.addAttribute("bookings", bookings);
		return "bookings";
	}

	@GetMapping("/confirmBooking/{bookingId}")
	public String confirmBooking(@PathVariable("bookingId") Long bookingId) {
		log.fine("changeStatus page");
		bookingService.confirmBooking(bookingId);
		return "redirect:/bookings";
	}

	@GetMapping("/deleteBooking/{bookingId}")
	public String deleteBooking(@PathVariable("bookingId") Long bookingId) {
		log.fine("deleteBooking page");
		bookingService.deleteBooking(bookingId);
		return "redirect:/bookings";
	}

	@GetMapping("/bookings/new")
	public String bookingsNew(Model model) {
		log.fine("Loading new booking page...");
		return "newBooking";
	}

	@PostMapping("/bookings/new")
	public String bookingsNew(@ModelAttribute @Valid Booking booking) {
		log.info("adding new booking... {} " + booking);
		bookingService.save(booking);
		return "redirect:/bookings";
	}

}
