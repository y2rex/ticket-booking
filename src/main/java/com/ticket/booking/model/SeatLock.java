package com.ticket.booking.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SeatLock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="seat_id")
	private Long seatId;
	
	@Column(name="show_id")
	private Long showId;
	
	@Column(name="locked_time_duration")
	private Integer timeOutInSecond;
	
	@Column(name="locked_time")
	private Timestamp lockTime;
	
	@Column(name="loked_by_user")
	private String lockedByUser;
}
