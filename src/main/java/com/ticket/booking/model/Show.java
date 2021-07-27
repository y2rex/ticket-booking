package com.ticket.booking.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movie_show")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long movieId;
	private Long screenId;
	private Timestamp startDate;
	private Long showDuration;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "movie_id", referencedColumnName = "id")
//	private Movie movieId;
//
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "screen_id", referencedColumnName = "id")
//	private Screen screenId;
//
//	@Column(name = "start_date")
//	private Timestamp startDate;
//
//	@Column(name = "movie_duration")
//	private Long showDuration;
}
