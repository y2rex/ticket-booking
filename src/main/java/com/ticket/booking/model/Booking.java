package com.ticket.booking.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ticket.booking.utility.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "show_id", referencedColumnName = "id")
	private Show show;

	@Column(name = "booked_seat_ids")
	private String bookedSeatIds;

	@Column(name = "user_id")
	private Integer userId;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "booking_status")
	private BookingStatus bookingStatus;
}
