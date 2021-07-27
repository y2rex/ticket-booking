package com.ticket.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.booking.model.Screen;
import com.ticket.booking.model.Theater;
import com.ticket.booking.service.TheaterService;

@RestController
@RequestMapping("/theater")
public class TheaterController {

	@Autowired
	private TheaterService theaterService;

	@PostMapping("/add-theater")
	public String createTheater(@RequestBody Theater theater) {
		boolean isSave = false;
		if (theater != null)
			isSave = theaterService.addTheater(theater);
		return isSave ? "Theater added!!!" : "Failed!!!";
	}
	
	@PostMapping("/add-screen/{theaterId}")
	public String createScreen(@RequestBody Screen screen,@PathVariable Long theaterId) {
		boolean isSave = false;
		if (screen != null)
			isSave = theaterService.addScreen(theaterId,screen);
		return isSave ? "Theater added!!!" : "Failed!!!";
	} 

}
