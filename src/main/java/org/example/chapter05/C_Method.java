package org.example.chapter05;

// === 인자와 매개변수의 관계 ===
// 1. 인자(argument)
// 2. 매개변수(parameter)

// 사칙연산 클래스
// : 두 개의 값을 매개변수로 받아 사칙 연산 수행
class MyMath {
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        // 메서드 내부에서 return 키워드를 만나면 메서드 종료!
        // >> 조건에 따라 반환값을 다르게 설정 가능
        // >> 반환타입은 일치하거나 자동 형 변환 가능할 것!

        if (b == 0) {
            System.out.print("정수 0으로 나눌 수 없습니다. ");
            return b;
        } else {
            return a / b;
        }
    }

    double doubleDivide(int a, double b) {
        return a / b;
    }

    void noReturn() {
        System.out.println("해당 메서드는 반환값이 없습니다.");
        // return;
        // : 자바 컴파일러가 반환타입의 void를 읽는 경우
        //      , 해당 메서드의 마지막에 return;을 자동 추가
    }

    // 조건부 반환 형식
    int max(int a, int b) {
        // 정수 a와 b를 비교하여 둘 중 더큰 값을 반환
//        if (a > b) return a;
//        else return b;

//        int result;
//        if (a > b) {
//            return a;
//        } else {
//            result = b;
//            return result;
//        }

        int result;
        if (a > b) return a;
        else result = b;

        return result;
    }

    int min(int a, int b) {
        // 삼항 연산자를 사용하여 조건부 반환

        return (a < b) ? a : b;
        //return a > b ? b: a;
    }
}

public class C_Method {
    public static void main(String[] args) {
        // 클래스타입 객체명 = new class생성자호출();
        // - 클래스 생성자는 반드시 한 개 이상 존재!
        // - 사용자 정의 생성자가 없는 경우 빈 생성자(인자x, 반환x)가 생략
        MyMath myMath = new MyMath();

        System.out.println(myMath.add(20, 10));
        System.out.println(myMath.subtract(20, 10));
        System.out.println(myMath.multiply(20, 10));
        System.out.println(myMath.divide(20, 10));

        System.out.println(myMath.divide(10, 0));
        // ArithmeticException: / by zero
        // >> 자바에서는 수를 0으로 나누면 예외 발생
        System.out.println(myMath.doubleDivide(10, 0.0)); // Infinity 무제한

        // cf) 인자값과 매개변수의 관계
        // : 자바는 값에 의한 호출 방식을 사용
        // - 메서드 호출 시 인자값이 '매개변수에 복사'되어 전달

        // cf) 인자는 실질적인 데이터
        //      매개변수는 해당 데이터를 메서드 블록 내에서 저장할 임시 변수 - 메서드 실행시에만 유효

        myMath.noReturn();
    }
}
