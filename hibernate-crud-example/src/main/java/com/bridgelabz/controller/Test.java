package com.bridgelabz.controller;

import java.util.List;

import com.bridgelabz.dao.StudentDao;
import com.bridgelabz.model.Student;

public class Test {

	public static void main(String[] args) {
		Student student = new Student("vikash", "Kumar", "vikashkumargupta5a7@gmail.com");
		StudentDao dao = new StudentDao();
		dao.saveStudents(student);
		System.out.println(dao.getStudentsById(1));

	}

}
