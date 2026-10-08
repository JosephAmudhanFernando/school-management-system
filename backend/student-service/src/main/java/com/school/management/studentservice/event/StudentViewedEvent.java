package com.school.management.studentservice.event;

import java.time.Instant;

public record StudentViewedEvent(
        String studentId,
        String viewedBy,
        Instant timestamp
) {}