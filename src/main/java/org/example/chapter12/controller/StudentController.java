package org.example.chapter12.controller;

import org.example.chapter12.dto.StudentRequestDto;
import org.example.chapter12.dto.StudentResponseDto;
import org.example.chapter12.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentController {

    private final List<Student> studentsList;
    private int nextId;

    public StudentController(List<Student> studentsList) {
        this.studentsList = studentsList;
        this.nextId = studentsList.size() + 1;
    }


    //1) 학생 추가 기능
    public void addStudent(StudentRequestDto dto) {
        // 학생 추가 시 입력한 studentNumber의 학생이 존재하는 경우
        // : 기능 x + 메시지 출력

        StudentResponseDto studentResponseDto = getStudentById(dto.getStudentNumber());

        if (studentResponseDto != null) {
            // 입력받은 studentNumber 학생이 존재 - 학생 추가 불가
            System.out.println("해당 학번의 학생이 이미 존재합니다.");
            return;
        }

        Student student = new Student(nextId++, dto.getName(), dto.getAge(), dto.getStudentNumber());
        studentsList.add(student);
        System.out.println(dto.getName() + "학생이 추가되었습니다. 학번: " + dto.getStudentNumber());
    }
    //2) 학생 전체 조회 기능
    public List<StudentResponseDto> getAllStudent() {
        List<StudentResponseDto> response = new ArrayList<>();

        for (Student student : studentsList) {
            response.add(new StudentResponseDto(student.getName(),
                                    student.getAge(),
                                    student.getStudentNumber(),
                                    student.getCreatedAt()));
        }
        return response;
    }
    //3) 특정 학생 조회 기능 - 단건 조회
    public StudentResponseDto getStudentById(String studentNumber) {
        for (Student student : studentsList) {
            if (student.getStudentNumber().equals(studentNumber)) {
                return new StudentResponseDto(
                        student.getName(),
                        student.getAge(),
                        student.getStudentNumber(),
                        student.getCreatedAt());
            } // 조회한 학생이 존재하는 경우 (데이터 반환)
        }
        return null;// 조회한 학생이 없을경우 (null 반환)
    }

    //4) 학생 수정 기능
    public boolean updateStudent(StudentRequestDto dto) {
        StudentResponseDto studentResponseDto = getStudentById(dto.getStudentNumber());

        if (studentResponseDto == null) {
            // 수정할 학생 정보가 존재하지 않으면
            return false;
        }

        for (Student student : studentsList) {
            if (student.getStudentNumber().equals(dto.getStudentNumber())) {
                student.setName(dto.getName());
                student.setAge(dto.getAge());
                return true;
            }
        }
        return false;
    }
    //5) 학생 삭제 기능
    public boolean removeStudent(String studentNumber) {
        for (Student student : studentsList) {
            if (student.getStudentNumber().equals(studentNumber)) {
                studentsList.remove(student);
                return true;
            }
        }
        return false;
    }
    //6) 프로그램 종료

}
