package org.example.chapter14;

/*
=== 메서드 참조 === // 공통 부분을 없앤다!
    : 람다 표현식을 더 간단하게 작성하기 위한 문법
    - 메서드 호출만 하는 단순한 람다일 경우, 메서드 이름만으로 표현 가능

    cf) 람다 표현식
    : 익명 함수 작성 방법, 함수형 인터페이스를 간단하게 구현
    (매개변수) -> { 실행문 }

    === 메서드 참조의 종류 === ~~~ 매개변수를 없앤다.
    1. 정적 메서드 참조
    - 클래스의 static 메서드 참조
    - Class명.staticMethod(); >> ClassName::staticMethod;

    2. 인스턴스 메서드 참조
    - 객체(인스턴스)를 반드시 생성하여 사용하는 메서드
    - 특정 객체의 인스턴스 메서드 참조
    - instance.instanceMethod(); >> instance::instanceMethod;

    3. 생성자 메서드 참조
    - 객체 생성용 생성자 참조
    - new ClassName(); >> ClassName::new

    4. 임의 객체의 인스턴스 메서드
    - 특정 객체가 아닌 여러 객체에 공통된 인스턴스 메서드를 사용 할 때
    ex) 모든 객체가 Object 내의 인스턴스 메서드를 포함
    - ClassName::instanceMethod;
 */

import java.util.function.Function;
import java.util.function.Supplier;

class StaticMethod {
    // 정적 메서드: 인스턴스 없이 바로 사용 가능
    static int doubleValue(int x) {
        return x * 2;
    }
}

class Person {
    private String name;

    public Person() {
        this.name = "이름 미상";
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


public class G_MethodRef {
    public static void main(String[] args) {
        // 1. 정적 메서드 참조
        // 1) 람다 표현식
        Function<Integer, Integer> doubleLambda = x -> StaticMethod.doubleValue(x);
        // 2) 메서드 참조
        Function<Integer, Integer> doubleLambdaRef = StaticMethod::doubleValue;
        System.out.println(doubleLambda.apply(5));
        System.out.println(doubleLambdaRef.apply(20));
        System.out.println();

        // 2. 인스턴스 메서드 참조
        // cf) 문자열 객체의 메서드 사용
        //      Object를 상속받는 String 클래스는 선언 시 객체 생성
        //      >> String 클래스 내부 인스턴스 메서드 사용 가능
        String hello = "Hello";
        // 1) 람다 표현식
        Supplier<String> toUpperLambDa = () -> hello.toUpperCase();
        // 2) 메서드 참조
        // 이미 생성된 객체의 메서드를 참조
        Supplier<String> toUpperLambDaRef = hello::toUpperCase;

        System.out.println(toUpperLambDa.get());
        System.out.println(toUpperLambDaRef.get());
        System.out.println();

        // 3. 생성자 참조
        // 1) 람다 표현식
        Supplier<Person> personLambda1 = () -> new Person("Lee Park");
        Supplier<Person> personLambda2 = () -> new Person();
        // 2) 메서드 참조
        // 매개변수가 없는 생성자일 경우에만 활용 가능!!!!
        Supplier<Person> personLambdaRef = Person::new; // 매개변수가 없는 생성자 호출

        Person p1 = personLambda1.get();
        Person p2 = personLambdaRef.get();

        System.out.println(p1.getName());
        System.out.println(p2.getName());
        System.out.println();

        // 4. 임의 객체 인스턴스 메서드 참조
        String[] names = {"seungAh", "dokyung", "seungbeom"};

        // Function<String, String> toUpperFunc = s -> s.toUpperCase();
        Function<String, String> toUpperFunc = String::toUpperCase;
        for (String name : names) {
            // 호출 시점(apply)에 매개변수로 들어온 객체의 메서드 호출!
            String upper = toUpperFunc.apply(name);
            System.out.println(upper);
        }

    }
}
