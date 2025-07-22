package org.example.chapter14;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

class StaticMethod2 {
    static int doubleValue(int x) {
        return x * 2;
    }
}

class Car {
    private String name;

    public Car() {
        this.name = "Random Car";
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class GG_MethodRef {
    public static void main(String[] args) {
        // 1. 정적 메서드 참조
        //      정수 넣고, 정수 반환
        //Function<Integer, Integer> doubleLambda = x -> StaticMethod2.doubleValue(x);
        Function<Integer, Integer> doubleLambda2 = StaticMethod2::doubleValue;
        System.out.println(doubleLambda2.apply(3));

        // 2. 인스턴스 메서드 참조
        // Supplier 사용 | 매개변수 x | 반환값 o
        // Object를 상속받는 String 클래스는 선언 시 객체 생성
        //      >> String 클래스 내부 인스턴스 메서드 사용 가능
        String greet = "Welcome to my Birthday Party!";
        //Supplier<String> toUpperCase = () -> greet.toUpperCase();
        Supplier<String> toUpperCase = greet::toUpperCase;
        System.out.println(toUpperCase.get());

        // 3. 생성자 참조
        Supplier<Car> carLambda0 = () -> new Car("Tesla");
        //Supplier<Car> carLambda = () -> new Car();
        Supplier<Car> carLambda1 = Car::new;

        System.out.println(carLambda1.get().getName());

        // 4. 임의 객체 인스턴스 메서드 참조
        String[] fruits = {"Apple", "Banana", "Orange"};
        //Function<String, String> fruitsList = s -> s.toUpperCase();
        Function<String, String> fruitUpper = String::toUpperCase;
        for (String fruit : fruits) {
            String upper = fruitUpper.apply(fruit);
            System.out.println("upper = " + upper);
        }
    }
}
