package com.school.management.studentservice.controller;

import com.school.management.studentservice.entity.Student;
import com.school.management.studentservice.repository.StudentRepository;
import com.school.management.studentservice.service.StudentEventProducer;
import com.school.management.studentservice.event.StudentViewedEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:8080")
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentEventProducer eventProducer;

    public StudentController(
            StudentRepository studentRepository,
            StudentEventProducer eventProducer
    ) {
        this.studentRepository = studentRepository;
        this.eventProducer = eventProducer;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(
            @PathVariable String id
    ) {
        return studentRepository.findById(id).map(student -> {

            // Broadcast the event
            eventProducer.publishStudentViewedEvent(
                    new StudentViewedEvent(
                            student.getId(),
                            "system_user",
                            Instant.now()
                    )
            );

            return ResponseEntity.ok(student);

        }).orElse(ResponseEntity.notFound().build());
    }
}
