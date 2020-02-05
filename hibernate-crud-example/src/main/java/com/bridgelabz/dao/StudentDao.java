package com.bridgelabz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bridgelabz.model.Student;
import com.bridgelabz.util.HibernateUtil;

public class StudentDao {
	// saveSatudents
	// detAllStudents
	// getStudentsById
	// updateStudents
	// deleteStudents

	/**
	 * This is used for save the students data in data base
	 * 
	 * @param student
	 */
	public void saveStudents(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start transaction
			transaction = session.beginTransaction();

			// saving student object
			session.save(student);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		Transaction transaction = null;
		List<Student> students = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start transaction
			transaction = session.beginTransaction();

			// saving student object
			students = session.createQuery("from student").list();

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return students;

	}

	public Student getStudentsById(long id) {
		Transaction transaction = null;
		Student student = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start transaction
			transaction = session.beginTransaction();

			// saving student object
			student = session.get(Student.class, id);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return student;

	}

	public void updateStudents(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start transaction
			transaction = session.beginTransaction();

			// saving student object
			session.saveOrUpdate(student);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	public Student deleteStudents(long id) {
		Transaction transaction = null;
		Student student = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start transaction
			transaction = session.beginTransaction();

			// saving student object
			student = session.get(Student.class, id);

			// deleting student
			session.delete(student);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return student;

	}

}
