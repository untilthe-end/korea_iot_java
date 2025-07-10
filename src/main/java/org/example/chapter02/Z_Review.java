package org.example.chapter02;

public class Z_Review {
    public static void main(String[] args) {
        //      *****
        //      ****
        //      ***
        //      **
        //      *

        //      *****
        //       ****
        //        ***
        //         **
        //          *

        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j >= i; j--) { //
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("--------------------------------");
        int rows = 5; // 출력할 줄 수
        for (int i = 1 ; i <= rows ; i++){
            for (int j = 5; j >= rows -i ; j--) {
                // 공백 반복
                // j: 4~0까지의수
                System.out.print(" ");
            }

            for (int k = rows; k >= i; k--) {
                // 별의 반복
                // k: 1~5까지의 수
                System.out.print("*");
            }


            System.out.println();
        }
    }
}