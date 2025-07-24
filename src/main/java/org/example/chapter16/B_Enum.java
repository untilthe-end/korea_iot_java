package org.example.chapter16;

/*
=== ENUM (열거형) 자료형 ===
    : 서로 관련된 '상수'들의 집합을 표현하는 데 사용
    - 서로 유기적인 관계성을 가짐, 자바의 클래스로 취급
    - 의미 있는 값들과 로직을 함께 담을 수 있는 구조로 활용 (가독성, 유지보수성 향상)

    ENUM 선언 방식
    - enum 키워드 사용
      enum enum명 { }
      >> 명명 규칙 형식이 클래스와 동일
      >> 중괄호 내에서 열거할 데이터를 ,로 구분하여 나열
 */

import lombok.ToString;


enum Fruits {
    // final 키워드가 생략된 상수
    // : UPPER_SNAKE_CASE 사용
    APPLE, BANANA, ORANGE
}

@ToString
class FruitClass {
    String name;
    
    FruitClass(String name){
        this.name = name;
    }
}

enum CoffeeSize {
    SMALL(100), MEDIUM(200), LARGE(300);
    // 각 필드는 CoffeeSize(Enum)과 대등
    // >> 생성자 호출

    private final int ml;

    CoffeeSize(int ml) {
        this.ml = ml;
    }

    public int getMl() { return ml; }
}
public class B_Enum {
    public static void main(String[] args) {
        // 상수 키워드는 클래스의 static final 필드처럼 쓰임
        // : Enum명.데이터;
        // >> 각 상수는 정의된 Enum 타입으로 간주
        Fruits apple = Fruits.APPLE;
        System.out.println(apple);

        FruitClass fruit = new FruitClass("이승아");
        System.out.println("fruit = " + fruit);

        // == ENUM의 주요 메서드 ==
        // 1) values(): 열거형의 모든 값을 배열로 반환
        System.out.println(Fruits.values()); // - 주소값으로 나옴 [Lorg.example.chapter16.Fruits;@2d98a335

        for (Fruits fruitValue : Fruits.values()) {
            System.out.println("fruitValue = " + fruitValue);
        }
        System.out.println();

        // 2) name(): Enum의 상수를 문자열로 반환
        String appleName = Fruits.APPLE.name();
        System.out.println(apple);

        // 3) valueOf(String name): 문자열을 Enum 상수로 반환
        // : 잘못된 문자열 전달 시 IllegalArgumentException 발생
        Fruits orange1 = Fruits.valueOf("ORANGE");
        //Fruits orange2 = Fruits.valueOf("Orange"); // .IllegalArgumentException (No enum constant)

        // 4) ordinal(): Enum 상수의 순서를 반환 (0부터 시작)
        System.out.println(orange1.ordinal()); // 2

        // === CoffeeSize === //
        CoffeeSize size = CoffeeSize.MEDIUM;
        System.out.println(size + "'s' ml: "+ size.getMl() + "ml"); // MEDIUM's' ml: 200ml

        CoffeeSize anotherSize = CoffeeSize.LARGE;
        System.out.println(anotherSize + "'s' ml: "+ anotherSize.getMl() + "ml"); // LARGE's' ml: 300ml

    }
}
