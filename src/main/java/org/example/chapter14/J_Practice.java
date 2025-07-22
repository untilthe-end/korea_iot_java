package org.example.chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
    1. 컬렉션 프레임워크
    2. 스트림 API
    3. 람다 표현식 & 메서드 참조

    == 학생 관리 시스템 ==
    : 학생 목록 필터링 & 정렬

 */
@AllArgsConstructor
@Getter
@ToString
class StudentClass {
    private String name;
    private int age;
    private double grade; // 학점
}
public class J_Practice {
    public static void main(String[] args) {
        List<StudentClass> studentClasses = Arrays.asList(
                new StudentClass("오신혁", 30, 4.3),
                new StudentClass("김세훈", 28, 4.1),
                new StudentClass("권민현", 25, 4.0),
                new StudentClass("김지선", 21, 3.9),
                new StudentClass("김태양", 25, 3.5)
        );
        // filter() 는 배열 개수가 달라질 수 있다.
        // map() 안달라짐
        // 공통점 = 새로운 배열이 반환된다.

        // 1) 학점이 4.0 이상인 학생 필터링
        List<StudentClass> filteredStudent = studentClasses.stream()
                .filter(student-> student.getGrade() >= 4.0)
                .collect(Collectors.toList());
        // Collectors.toList()
        // : static 메서드
        // - 스트림을 List 타입으로 변환
        System.out.println("학점이 4.0 이상인 학생");
        filteredStudent.forEach(System.out::println);
        System.out.println();

        // 2) 학생 이름 목록만 추출
        List<String> studentNames = studentClasses.stream()
                //.map(student -> student.getName())
                // : 순회되는 학생의 인스턴스 메서드 참조 (클래스타입::메서드명)
                .map(StudentClass::getName)
                .collect(Collectors.toList());

        System.out.println("학생 이름 목록");
        System.out.println(studentNames); // [오신혁, 김세훈, 권민현, 김지선, 김태양]
        System.out.println();

        // 3) 학생들을 점수순으로 정렬
        // : 스트림 API 중간 연산의 sorted()
        // >> Comparator 클래스의 .comparing 타입 정적 메서드를 활용
        //   StudentClass 타입을 가져와서~~
        List<StudentClass> sortedStudents = studentClasses.stream()
                // sorted(): 클래스 객체 형식으로 비교할 수 없음
                //      >> String, Integer 등은 기본 정렬이 정의되어 있어 사용 가능
                //.sorted(Comparator.comparingDouble(s -> s.getGrade()))
                .sorted(Comparator.comparingDouble(StudentClass::getGrade)) // 오름차순 정렬
                //.sorted(Comparator.comparingDouble(StudentClass::getGrade).reversed()) // 내림차순 정렬
                .collect(Collectors.toList()); // .ClassCastException
        System.out.println();

        System.out.println("점수 순으로 정렬된 학생");
        sortedStudents.forEach(System.out::println);
        System.out.println();

        // 4) 학생들중 이름에 '민'이 포함된 학생 필터링
        List<StudentClass> studentsWithMin = studentClasses.stream()
                .filter(studentClass -> studentClass.getName().contains("민"))
                .collect(Collectors.toList());

        System.out.println("이름에 '민'이 들어간 학생");
        studentsWithMin.forEach(System.out::println);
    }
}
