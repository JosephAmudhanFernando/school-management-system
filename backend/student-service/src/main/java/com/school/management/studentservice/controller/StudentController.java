package com.school.management.studentservice.controller;

import com.school.management.studentservice.entity.Student;
import com.school.management.studentservice.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:8080")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(
            StudentRepository studentRepository
    ) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(
            @PathVariable String id
    ) {
        return studentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}