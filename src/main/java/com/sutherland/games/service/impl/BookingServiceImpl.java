package com.sutherland.games.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sutherland.games.model.Booking;
import com.sutherland.games.repository.BookingRepository;
import com.sutherland.games.service.BookingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

	private final BookingRepository bookingRepository;

	@Override
	public Page<Booking> findAll(Pageable pageable) {
		return bookingRepository.findAll(pageable);
	}

	@Override
	public Booking save(Booking booking) {
		return bookingRepository.save(booking);
	}
}
