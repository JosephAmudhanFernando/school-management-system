package com.school.management.studentservice.service;

import com.school.management.studentservice.event.StudentViewedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentEventProducer {

    private static final Logger log =
            LoggerFactory.getLogger(StudentEventProducer.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public StudentEventProducer(
            KafkaTemplate<String, Object> kafkaTemplate
    ) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishStudentViewedEvent(
            StudentViewedEvent event
    ) {
        log.info(
                "Publishing event to student-events: {}",
                event
        );

        kafkaTemplate.send(
                "student-events",
                event.studentId(),
                event
        );
    }
}