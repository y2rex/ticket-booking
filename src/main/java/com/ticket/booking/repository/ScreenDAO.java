package com.ticket.booking.repository;

import com.ticket.booking.model.Screen;

public interface ScreenDAO {
	public boolean save(Screen screen);

	public Screen findScreenById(Long screenId);
}
