package com.ticket.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.booking.model.Movie;
import com.ticket.booking.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@PostMapping("/add")
	private String addMovie(@RequestBody Movie movie) {
		boolean isSave=false;
		if(movie!=null) {
			isSave=movieService.addMovie(movie);
		}
		return isSave?"saved successfully!!!" : "Failed!!!";
	}
}
