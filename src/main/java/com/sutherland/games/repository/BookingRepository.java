package com.sutherland.games.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sutherland.games.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	@Query("select b from Booking b where (:bookingFrom >= b.bookingFrom and :bookingFrom <= b.bookingTo) and b.status = :status")
	List<Booking> findBokingFromGreaterThanOrEqual(@Param("bookingFrom") Date bookingFrom, @Param("status") String status);
	
	@Query("select b from Booking b where (:bookingTo <= b.bookingTo and :bookingTo >= b.bookingTo) and b.status = :status")
	List<Booking> findBokingToLessThanOrEqual(@Param("bookingTo") Date bookingTo, @Param("status") String status);
		
}
