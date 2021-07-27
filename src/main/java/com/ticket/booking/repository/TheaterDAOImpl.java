package com.ticket.booking.repository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticket.booking.model.Theater;

@Repository
public class TheaterDAOImpl implements TheaterDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Theater theater) {
		boolean success = false;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(theater);
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
	public Theater findTheaterById(Long theaterId) {
		boolean isClose = false;
		Session session = null;
		try {
			if (session == null) {
				session = sessionFactory.openSession();
				isClose = true;
			}
			@SuppressWarnings("unchecked")
			TypedQuery<Theater> query = session
					.createQuery("from Theater where id = :THEATER_ID");
			query.setParameter("THEATER_ID", theaterId);
			List<Theater> theaters = query.getResultList();
			if (theaters != null && theaters.size() > 0) {
				return theaters.get(theaters.size() - 1);
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
