package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.service.DemoService;

@RestController
public class DemoController {

	@Autowired
	private DemoService service;

	@PostMapping("/saveStudent")
	public void saveStudent(@RequestBody Student student) {
		service.addStudent(student);
	}

	@GetMapping("/getStudents")
	public List<Student> getStudent() {
		return service.getAllStudents();

	}

	@GetMapping("/getStudent/{id}")
	public Student getStudent (@PathVariable  long id) {
		return service.getStudent(id);

	}

	@PostMapping("/updateStudent/{id}")
	public  ResponseEntity<?> updateStudent(@PathVariable long id, @RequestBody Student student) {

		return service.updateStudent(id, student);
	}

	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable long id) {
		service.deleteStudent(id);
	}

}
