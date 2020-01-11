package com.sutherland.games.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

	@Query("select b from Booking b where b.member.id = :memberId order by b.id desc")
	List<Booking> findByMemberId(@Param("memberId") Long memberId);

	@Modifying
	@Transactional
	@Query("update Booking b set b.status= :status where b.id = :bookingId")
	Integer updateBooking(@Param("status") String status, @Param("bookingId") Long bookingId);
	
	@Modifying
	@Transactional
	@Query("delete from Booking b where b.id = :bookingId and b.member.id = :memberId")
	Integer deleteBooking(@Param("bookingId") Long bookingId, @Param("memberId") Long memberId);
		
}
