package org.example.chapter14;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FF_Practice {
    public static void main(String[] args) {
        // [1] 학생 이름과 점수를 저장할 Map 생성
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("김지선", 90);
        studentScores.put("김동후", 80);
        studentScores.put("권지애", 93);
        studentScores.put("박현우", 85);
        studentScores.put("김승민", 100);

        Predicate<Integer> isPassed = score -> score >= 90;

        Function<Integer, String> gradeFunction = score -> {
            if (score > 100 || score < 0) return "x";
            else if (score >= 90) return "A";
            else if (score >= 80) return "B";
            else if (score >= 70) return "C";
            else return "F";
        };

        Consumer<String> line = s -> System.out.println("=".repeat(s.length()));

        Consumer<String> printHeader = title -> {
            line.accept(title); // 상단 구분선
            System.out.println(title); // 제목 출력
            line.accept(title); // 하단 구분선
        };

        Consumer<Map.Entry<String, Integer>> printStudentInfo = entry -> {
            String name = entry.getKey(); // 학생 이름
            int score = entry.getValue(); // 점수
            String grade = gradeFunction.apply(score); // 등급 계산
            boolean pass = isPassed.test(score); // 합격 여부 판단

            Map<String, Integer> map = new HashMap<>();
            map.put("apple", 3); // "Apple" => 3 (사과는 3개) => 각 요소를 Map.Entry<String, Integer> 타입으로 다룰 수 있음.
            map.put("banana", 5);

            System.out.println(name + " | 점수: " + score + " | 등급: " + grade
                    + " | " + (pass ? "합격" : "불합격")
            );

        };
        Supplier<Integer> bonusSupplier = () -> new Random().nextInt(6);
        printHeader.accept("학생 점수 처리 결과");

        studentScores.entrySet().forEach(entry -> {
            // 무작위 보너스 점수 생성 + 기존 점수에 더함
            int bonus = bonusSupplier.get();
            entry.setValue(entry.getValue() + bonus);

            printStudentInfo.accept(entry);

        });
    }
}
