package com.ticket.booking.repository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticket.booking.model.Screen;

@Repository
public class ScreenDAOImpl implements ScreenDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Screen screen) {
		boolean success = false;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(screen);
			tx.commit();
			success = true;
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return success;
	}

	@Override
	public Screen findScreenById(Long screenId) {
		boolean isClose = false;
		Session session = null;
		try {
			if (session == null) {
				session = sessionFactory.openSession();
				isClose = true;
			}
			@SuppressWarnings("unchecked")
			TypedQuery<Screen> query = session.createQuery("from Screen where id = :SCREEN_ID");
			query.setParameter("SCREEN_ID", screenId);
			List<Screen> screens = query.getResultList();
			if (screens != null && screens.size() > 0) {
				return screens.get(screens.size() - 1);
			}
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (isClose && session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}
}
