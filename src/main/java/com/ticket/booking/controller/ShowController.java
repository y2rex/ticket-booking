package com.ticket.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.booking.model.Show;
import com.ticket.booking.service.ShowService;

@RestController
@RequestMapping("/show")
public class ShowController {

	@Autowired
	private ShowService showService;
	
	@PostMapping("/add")
	public String addShow(@RequestBody Show show) {
		boolean isSave=false;
		if(show!=null) {
			isSave=showService.createShow(show);
		}
		return isSave?"Show created!!!":"Failed!!!";
	}
}
