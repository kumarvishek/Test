package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Student;

public interface DemoRepository extends JpaRepository<Student, Long> {

}
