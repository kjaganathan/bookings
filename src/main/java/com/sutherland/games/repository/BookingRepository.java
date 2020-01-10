package com.sutherland.games.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sutherland.games.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
