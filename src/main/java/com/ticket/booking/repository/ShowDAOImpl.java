package com.ticket.booking.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticket.booking.model.Show;

@Repository
public class ShowDAOImpl implements ShowDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Show show) {
		boolean success = false;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(show);
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

}
