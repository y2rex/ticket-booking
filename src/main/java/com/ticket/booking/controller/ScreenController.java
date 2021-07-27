package com.ticket.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.booking.model.Seat;
import com.ticket.booking.service.ScreenService;

@RestController
@RequestMapping("/screen")
public class ScreenController {

	@Autowired
	private ScreenService screenService;

	@PostMapping("/add-seats/{screenId}")
	public String addSeat(@RequestBody List<Seat> seats, @PathVariable Long screenId) {
		boolean isSave = false;
		if (seats != null && seats.size() > 0) {
			isSave = screenService.addSeats(screenId, seats);
		}
		return isSave ? "seats added!!!" : "failed!!!";
	}
}
