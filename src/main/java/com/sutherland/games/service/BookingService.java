package com.sutherland.games.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sutherland.games.model.Booking;

public interface BookingService {

	Page<Booking> findAll(Pageable pageable);

	Booking save(Booking booking);

}
