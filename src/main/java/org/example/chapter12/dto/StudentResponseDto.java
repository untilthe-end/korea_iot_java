package org.example.chapter12.dto;

import java.time.LocalDateTime;

// 응답 할 때
public class StudentResponseDto {

    private String name;
    private int age;
    private String studentNumber;
    private LocalDateTime createdAt;

    public StudentResponseDto(String name, int age, String studentNumber, LocalDateTime createdAt) {
        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "StudentResponseDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentNumber='" + studentNumber + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }


}
