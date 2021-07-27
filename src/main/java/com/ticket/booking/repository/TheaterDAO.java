package com.ticket.booking.repository;

import com.ticket.booking.model.Theater;

public interface TheaterDAO{
	public boolean save(Theater theater);
	public Theater findTheaterById(Long theaterId);
}
