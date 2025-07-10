package org.example.chapter01;

import java.util.Scanner;

public class Z_Practice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름: ");
        String name = scanner.nextLine();

        System.out.print("국어 점수: ");
        int koreanScore = scanner.nextInt();

        System.out.print("영어 점수: ");
        int englishScore = scanner.nextInt();

        System.out.print("수학 점수: ");
        int mathScore = scanner.nextInt();

        int totalScore = koreanScore + englishScore + mathScore;
        double average = totalScore / 3.0;
        String result = (koreanScore >= 60 && englishScore >= 60 && mathScore >=60) ? "합격" : "불합격";

        System.out.println("[이름: " + name + "]");
        System.out.println("총점: "+ totalScore + "점");
        System.out.printf("평균: %.1f점\n", average);
        System.out.println("평균: "+average);
        System.out.println("판정: " + result);

//        System.out.printf("평균 %.1f");

        scanner.close();
    }
}
