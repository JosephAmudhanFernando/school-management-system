package com.school.management.studentservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic studentEventsTopic() {
        // This forces KafkaAdmin to connect to the broker to create or verify the topic
        return TopicBuilder.name("student-events")
                .partitions(1)
                .replicas(1)
                .build();
    }
}