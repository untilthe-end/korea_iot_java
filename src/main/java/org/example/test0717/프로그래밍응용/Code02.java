package org.example.test0717.프로그래밍응용;

import java.util.Scanner;

public class Code02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int min = Integer.MAX_VALUE;

        System.out.print("정수 개수를 입력하세요: ");
        int number = Integer.parseInt(sc.nextLine());
        int[] numbers = new int[number];

        for (int i = 0; i < number; i++) {
            System.out.print(i + 1 + "번째 정수를 입력해주세요: ");
            numbers[i] = Integer.parseInt(sc.nextLine());
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println(min);
        sc.close();
    }
}
