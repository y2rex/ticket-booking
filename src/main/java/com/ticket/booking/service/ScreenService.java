package com.ticket.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.booking.model.Screen;
import com.ticket.booking.model.Seat;
import com.ticket.booking.repository.ScreenDAOImpl;

@Service
public class ScreenService {
	@Autowired
	private ScreenDAOImpl screenDAOImpl;

	public boolean addSeats(Long screenId, List<Seat> seats) {
		if (screenId != null) {
			Screen screen = screenDAOImpl.findScreenById(screenId);
			if (screen != null) {
				for (Seat seat : seats) {
					screen.getSeatList().add(seat);
				}
				screenDAOImpl.save(screen);
			}
		}
		return false;
	}

}
