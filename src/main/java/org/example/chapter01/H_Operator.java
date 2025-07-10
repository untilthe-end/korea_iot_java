package org.example.chapter01;

public class H_Operator {
    public static void main(String[] args) {
        // === 연산자 (Operation) === //
        // : 프로그램에서 데이터를 조작하거나 계산

        System.out.println("=== 산술 연산자 ===");
        // 사칙 연산 (덧셈, 뺄셈, 곱셈, 나눗셈)
        int a = 10;
        int b = 20;
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b); // 나눗셈 : 몫 저장
        System.out.println(a%b); // 나눗셈 : 나머지 저장

        System.out.println("=== 증감 연산자 ===");
        // : 변수의 값을 1증가(++) or 1감소(--)
        int number = 10;

        // 1) 전위 증감 연산자
        // : 값이 먼저 변경되고 나서 계산에 적용
        // : ++변수명 , --변수명
        System.out.println(++number);
        System.out.println(--number);

        // 2) 후위 증감 연산자
        // : 값이 계산된 이후 변경
        // : 변수명++ , 변수명--
        System.out.println(number); // 10
        System.out.println(number++); // 10 -> 11
        System.out.println(number--); // 11 -> 10
        System.out.println(number); // 10

        number++;
        number++;
        ++number;
        --number;
        number--;
        number++;
        System.out.println(number);

        System.out.println("=== 대입(할당) 연산자 ===");
        // : 변수에 값을 할당할 때 사용하는 연산자
        // 기본 연산자(=), 사칙연산과 결합된 연산(+=, -=, *=, /=, %=)
        number = 10; // 대입 연산자

        // 해당 값의 연산 후 다시 변수에 할당
        System.out.println(number += 3); //13
        System.out.println(number -= 3); // 7
        System.out.println(number *= 3); // 30
        System.out.println(number /= 3); // 3
        System.out.println(number %= 3); // 1

        System.out.println("=== 비교 연산자 ===");
        // : 좌항과 우항을 비교한 결과를 논리(boolean) 값으로 반환
        // <, >, <=, >=, ==(일치), !=(불일치)
        System.out.println(5 > 3);  // true
        System.out.println(5 < 3);  // false
        System.out.println(5 >= 3);
        System.out.println(5 <= 3);
        System.out.println(5 == 3); // false
        System.out.println(5 != 3); // true

        System.out.println("=== 논리 연산자 ===");
        // : 논리값(boolean)을 연산
        // & (앰퍼샌드), | (버티컬 바,vertical bar)

        // 1) 논리곱 (and, &&)
        // : 모든 값이 true면 true의 결과
        // - 하나의 값이라도 false면 false 의 결과
        System.out.println(true && true && true); // true
        System.out.println(true && true && true && false && true); // false

        // 2) 논리합 (or, ||)
        // : 하나의 값이라도 true면 true의 결과
        System.out.println(true || true); // true
        System.out.println(true || true || false || false); // true
        System.out.println(false || false || false ) ; // false

        // 3) 부정 논리 (!)
        // : 논리값을 전환
        // - 논리값 앞에 ! 키워드 사용하여 작성
        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println(!bool1);
        System.out.println(!bool2);

        System.out.println(3 > 2 && 1 == 1);
        System.out.println(1 != 1);
        System.out.println(3 >= 3 || 10 < 11 && !bool2);

        System.out.println("=== 조건 (삼항) 연산자 ===");
        // 조건식(논리의 값이 반환) ? 조건식이 참인 경우 반환 : 조건식이 거짓인 경우 반환

        int age = 15;
        String drink = age > 19 ? "Beer" : "Orange Juice";
        System.out.println(drink + "를 마십니다.");

        int x = 20, y = 6; // 변수의 데이터 타입이 같은 경우 , 콤마로 구분하여 나열 가능
        System.out.println(x % y == 0 ? "2의 배수입니다." : "2의 배수가 아닙니다.");

        System.out.println("=== 기타 연산자 ===");
        // 문자열 연결 연산자 +
        String result = "이" + " 승아" ;
        System.out.println(result);

        // cf) 연산자의 우선순위
        // : (기본) 좌측 >> 우측
        //       But, 대입 연산자의 경우 우항에서 좌항으로 대입!
        //      () 괄호 연산자의 경우 우선순위를 가짐!
    }
}
