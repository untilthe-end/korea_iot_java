package org.example.chapter14;

// == 성적 계산 프로그램 == //

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class Student {
    private String name;
    private int score;
}

// 인터페이스 - 성적 계산기
interface Grading {
    String calculateGrade(Student student);

}

public class C_Anonymous {
    public static void main(String[] args) {
        Student student1 = new Student("조승범", 90);
        Student student2 = new Student("티티티", 66);
        Student student3 = new Student("백다방", 82);
        Student student4 = new Student("컴포즈", 34);
        Student student5 = new Student("스타벅", 71);

        Student[] students = {student1, student2, student3, student4, student5};

        // Grading 인터페이스를 구현한 '익명 클래스'를 즉석에서 만들어서 그 객체를 생성하는 거예요.

        // 원래는 다른 클래스에서 implements 해서 인스턴스화 해서 써야해요.

        // 한번만 쓸 거라면 '익명 클래스'

        Grading grading = new Grading() {
            @Override
            public String calculateGrade(Student student) {
                int score = student.getScore();

                if (score > 100 || score < 0) {
                    System.out.println("잘못된 점수입니다.");
                    return null;
                } else if (score >= 90) {
                    return "A";
                } else if (score >= 80) {
                    return "B";
                } else if (score >= 70) {
                    return "C";
                } else if (score >= 60) {
                    return "D";
                } else {
                    return "F";
                }
            }
        };
        for (Student student : students) {
            String grade = grading.calculateGrade(student);

            if (grade != null) {
                System.out.println(student.getName() + "의 성적: " + grade);
            }
        }
    }
}
