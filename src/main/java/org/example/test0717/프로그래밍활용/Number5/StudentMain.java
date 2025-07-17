package org.example.test0717.프로그래밍활용.Number5;

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

public class StudentMain {
    public static void main(String[] args) {
        Student[] students = {new Student("John", 83),
                new Student("Jane", 92),
                new Student("Tom", 78),
                new Student("Emily", 88),
                new Student("Alex", 95)
        };

        for (Student student : students) {
            if (student.getScore() >= 90) {
                System.out.println(student.getName());
            }
        }
    }
}
