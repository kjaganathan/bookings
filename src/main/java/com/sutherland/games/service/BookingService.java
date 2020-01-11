package com.sutherland.games.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sutherland.games.model.Booking;

public interface BookingService {

	Page<Booking> findAll(Pageable pageable);

	Booking save(Booking booking);

	List<Booking> findByMemberId(String searchText);

	void confirmBooking(Long bookingId);

	void deleteBooking(Long bookingId);

}
