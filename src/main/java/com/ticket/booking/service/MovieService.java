package com.ticket.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.booking.model.Movie;
import com.ticket.booking.repository.MovieDAO;

@Service
public class MovieService {

	@Autowired
	private MovieDAO movieDAO;

	public boolean addMovie(Movie movie) {
		return movieDAO.save(movie);
	}

}
