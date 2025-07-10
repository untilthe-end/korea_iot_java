package org.example.chapter02;

import java.util.Scanner;

public class E_Practice {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("점수 입력: (0 ~ 100) ");
//        int score = scanner.nextInt();
//
//        if (score < 0 || score > 100) {
//            System.out.println("유효하지 않은 점수 입니다.");
//        } else if (score >= 90) {
//            System.out.println("A");
//        } else if (score >= 80) {
//            System.out.println("B");
//        } else if (score >= 70) {
//            System.out.println("C");
//        } else if (score >= 60) {
//            System.out.println("D");
//        } else {
//            System.out.println("F");
//        }

        // 각 줄의 별 개수는 각 줄의 수 보다 "이하"의 값

//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= i; j++) {
//                // 1행은 별을 1번 반복
//                // 2행은 별을 2번 반복
//                // ...
//                // 5행은 별을 5번 반복
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        /*
             *
            **
           ***
          ****
         *****

          행은 1~5까지 반복: i < rows; (조건)

         +) 공백은 4~0까지 -1씩 감소: rows -i (조건)
         +) 별은   1~5까지 +1씩 증가: 행을 초과하지 않도록 반복
      */

        int rows = 5; // 출력할 줄 수
        for (int i = 1 ; i <= rows ; i++){
            for (int j = 1; j <= rows -i ; j++) {
                // 공백 반복
                // j: 4~0까지의수
                System.out.print(" ");
            }

            for (int k = 1; k <= i; k++) {
                // 별의 반복
                // k: 1~5까지의 수
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

