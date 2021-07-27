package com.ticket.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.booking.model.Screen;
import com.ticket.booking.model.Theater;
import com.ticket.booking.repository.TheaterDAOImpl;

@Service
public class TheaterService {

	@Autowired
	private TheaterDAOImpl theaterDAOImpl;

	public boolean addTheater(Theater theater) {
		return theaterDAOImpl.save(theater);
	}

	public boolean addScreen(Long theaterId, Screen screen) {
		if (theaterId != null) {
			Theater theater = theaterDAOImpl.findTheaterById(theaterId);
			if (theater != null) {
				theater.getScreenList().add(screen);
				return theaterDAOImpl.save(theater);
			}
		}
		return false;
	}

}
