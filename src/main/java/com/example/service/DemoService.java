package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.Student;
import com.example.repo.DemoRepository;

@Service
public class DemoService {

	@Autowired
	private DemoRepository repo;

	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	public Student getStudent(long id) {
		try {
			return repo.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	public void addStudent(Student student) {

		repo.save(student);
	}

	public ResponseEntity<?> updateStudent(long id, Student student) {
		if (getStudent(id) != null) {

			repo.save(student);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not present");

	}

	public void deleteStudent(long id) {
		repo.deleteById(id);
	}

}
