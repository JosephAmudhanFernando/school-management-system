package com.school.management.studentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String grade;
    private String feeStatus;

    public Student() {}

    public Student(
            String id,
            String firstName,
            String lastName,
            String grade,
            String feeStatus
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.feeStatus = feeStatus;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getFeeStatus() { return feeStatus; }
    public void setFeeStatus(String feeStatus) {
        this.feeStatus = feeStatus;
    }
}