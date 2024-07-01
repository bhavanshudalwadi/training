package com.spring.security.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.spring.security.models.Student;

@Service
public class StudentServices {
	private List<Student> list = new ArrayList<Student>();
	
	public StudentServices() {
		list.add(new Student("Bhavanshu Dalwadi", "210210116505", "bhavanshu@gmail.com", "1234567890"));
		list.add(new Student("Henil Chimpani", "200210116001", "henil@gmail.com", "098765321"));
		list.add(new Student("Jainil Dalwadi", "210210116504", "jainil@gmail.com", "1234567890"));
		list.add(new Student("Deep Padsala", "200210116005", "deep@gmail.com", "1234567890"));
	}
	
	public List<Student> getStudents() {
		return this.list;
	}
}
