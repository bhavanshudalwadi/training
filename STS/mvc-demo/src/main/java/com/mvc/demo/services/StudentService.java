package com.mvc.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.demo.dao.StudentDao;
import com.mvc.demo.models.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	public int createStudent(Student student) {
		return this.studentDao.saveStudent(student);
	}
	
}
