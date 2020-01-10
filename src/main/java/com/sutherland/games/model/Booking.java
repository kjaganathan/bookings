package com.sutherland.games.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String reason;

	private String status;

	@Column(length = 10)
	private String bookingId;

	@NotNull(message = "from date is required")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date bokingFrom;

	@NotNull(message = "to date is required")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date bookingTo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Valid
	@NotNull(message = "member information is required")
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(columnDefinition = "member_id")
	private Member member;

	@PrePersist
	public void prePersist() {
		this.setBookingId(RandomStringUtils.randomAlphabetic(10).toUpperCase());
		this.setCreatedOn(new Date());
	}

}
