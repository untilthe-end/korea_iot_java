package org.example.test0717.프로그래밍응용;

import java.util.Scanner;

public class Code01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 수 입력: ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 수 입력: ");
        int num2 = sc.nextInt();

        System.out.println((num1 == 0 || num2 == 0) ? "0으로 나눌 수 없습니다." : num1 / num2);

        sc.close();

        /*try {
            if ((num1 == 0 || num2 == 0)) {
                throw new ArithmeticException("0으로 나눌수 없습니다.");
            } else {
                double result = num1 / num2;
                System.out.println(result);
            }

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }*/
    }

}
