package com.ticket.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.booking.model.Show;
import com.ticket.booking.repository.ShowDAOImpl;

@Service
public class ShowService {

	@Autowired
	private ShowDAOImpl showDAOImpl;

	public boolean createShow(Show show) {
		return showDAOImpl.save(show);
	}
}
