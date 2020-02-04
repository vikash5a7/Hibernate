package com.bridgelabz.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bridgelabz.model.Student;
import com.bridgelabz.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		Student student = new Student("vikash", "kumar", "vikash@gmail.com");
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start the transaction
			transaction = session.beginTransaction();

			// save student object
			session.save(student);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
}
