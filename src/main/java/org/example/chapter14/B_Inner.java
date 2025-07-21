package org.example.chapter14;

// == 학교 시스템 == //

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class School {
    private String schoolName;

    // (비정적) 내부 클래스 - 학생
    @AllArgsConstructor
    class Student {
        private int studentId;
        private String studentName;

        public void displayInfo() {
            System.out.println("학교명: " + schoolName + ", 학생 이름: " + studentName);
        }
    }

    // 정적 내부 클래스 - 교장 선생님 (싱글톤 패턴) - 인스턴스 없이 클래스만으로 호출
    static class Principal {
        private static Principal instance;

        private Principal() {
        }

        public static Principal getInstance() {
            // 교장선생님 값이 없으면 만들어서 저장~
            if (instance == null) {
                instance = new Principal();
            }
            // 반대로~ 있다면 만들지 않고 있는거 반환~
            return instance;
        }

        public void displayInfo() {
            System.out.println("훈화 말씀: 공부 열심히~ 밥 잘먹고~ 일찍자고~ 일찍일어나기!");
        }
    }
}

public class B_Inner {
    public static void main(String[] args) {
        School school = new School("부산외고"); // 값이 들어갔고...

        // @롬복 어노테이션 생성자
        // : 필드값 순서대로 매개변수 값을 설정 - 타입 유의!!
        School.Student student1 = school.new Student(43, "아이스티");
        student1.displayInfo();

        // Principal 클래스
        // getInstance() 내부의 new 연산자가 사용되어 new 키워드 생략 (일반 static 메서드 호출)
        School.Principal principal = School.Principal.getInstance();

        principal.displayInfo();
    }
}
