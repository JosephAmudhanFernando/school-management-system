package com.school.management.studentservice.service;

import com.school.management.studentservice.event.StudentViewedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StudentEventListener {

    private static final Logger log =
            LoggerFactory.getLogger(StudentEventListener.class);

    @KafkaListener(
            topics = "student-events",
            groupId = "student-group"
    )
    public void consumeStudentViewedEvent(
            StudentViewedEvent event
    ) {
        log.info(
                "Consumed event: Student {} viewed at {}",
                event.studentId(),
                event.timestamp()
        );
    }
}