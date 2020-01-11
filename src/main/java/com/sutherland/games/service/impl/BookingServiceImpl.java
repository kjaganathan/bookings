package com.sutherland.games.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sutherland.games.enums.BookingStatus;
import com.sutherland.games.exception.NotAvailableException;
import com.sutherland.games.model.Booking;
import com.sutherland.games.repository.BookingRepository;
import com.sutherland.games.service.BookingService;
import com.sutherland.games.util.AppConstats;

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
		booking.setStatus(BookingStatus.Pending.name());
		if(checkAvailabilty(booking)){
			bookingRepository.save(booking);
		} else {
			throw new NotAvailableException("Not Available for from "+booking.getBookingFrom()+" to "+booking.getBookingTo());
		}
		return bookingRepository.save(booking);
	}

	private boolean checkAvailabilty(Booking booking) {
		List<Booking> bookings1 = bookingRepository.findBokingFromGreaterThanOrEqual(booking.getBookingFrom(), BookingStatus.Booked.name());
		List<Booking> bookings2 = bookingRepository.findBokingToLessThanOrEqual(booking.getBookingTo(), BookingStatus.Booked.name());
		return CollectionUtils.isEmpty(bookings1) && CollectionUtils.isEmpty(bookings2);
	}

	@Override
	public List<Booking> findByMemberId(String searchText) {
		return bookingRepository.findByMemberId(AppConstats.getSessionUser().getId());
	}

	@Override
	public void confirmBooking(Long bookingId) {
		bookingRepository.updateBooking(BookingStatus.Booked.name(), bookingId);
	}

	@Override
	public void deleteBooking(Long bookingId) {
		bookingRepository.deleteBooking(bookingId, AppConstats.getSessionUser().getId());
	}
}
