package org.example.test0717.프로그래밍활용.Number3;

import java.util.Scanner;

public class Three {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("숫자를 입력하세요: ");
        int inputNumber = Integer.parseInt(sc.nextLine());

        if (inputNumber < 1) {
            System.out.println("0보다 큰 수 입력!!!");
        } else if (inputNumber % 2 == 0) {
            System.out.println("입력하신 숫자는 짝수입니다.");
        } else {
            System.out.println("입력하신 숫자는 홀수입니다.");
        }
    }
}
