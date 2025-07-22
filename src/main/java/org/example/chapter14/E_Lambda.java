package org.example.chapter14;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
    == 람다식 ==
    : 함수형 인터페이스(추상 메서드가 하나)를 간결하게 구현하는 코드식
    >> '딱 한가지 일'을 처리하는 메서드

    1. Predicate<T>(판단하다) - 맞니 안맞니 true or false
    : 입력값을 받아 조건을 검사하는 데 시용
    : 메서드
        - boolean test(T t): 주어진 입력 값이 조건을 만족하면 true / 그렇지 않으면 false 반환
        - and(Predicate other), or(Predicate other), negate(): Predicate 조합에 사용

        cf) negate: 부정하다 (현재의 결과를 역전)

    @FunctionalInterface
    interface Predicate<T> {
        boolean test(T t);

    }

    2. Function<T, R>(변환하다)
    : 입력값을 받아 특정 연산을 수행한 후 결과(R)를 반환
    : 메서드
            - R apply(T t): 입력값을 받아 변환한 값을 반환
            - andThen(Function after): 현재 결과를 다른 Function 입력으로 연결
            - compose(Function before): 다른 Function의 결과를 현재 입력으로 연결

    @FunctionalInterface
    interface Function<T, R> {
            R apply(T t);
    }

    3. Consumer<T>(소비하다)
    : 입력 값을 받아 소비(출력 or 상태 변경)하는 데 사용
            - void accept(T t) : 입력값을 소비해서 없앰 | void
            - andThen(Consumer after): 연속적인 소비 작업을 위해 사용

    @FunctionalInterface
    interface Consumer<T> {
        void accept(T t);
    }

    4. Supplier<T> (공급하다)
    : 값을 공급(생성)하는데 사용, 입력 값이 필요없음.
    : 외부에서 값을 가져오거나, 데이터를 생성하여 반환하는 역할
    : 메서드
        - T get(): 반환

    @FunctionalInterface
    interface Supplier<T> {
        T get();
    }

 */
public class E_Lambda {
    public static void main(String[] args) {
        // == Predicate == //
        System.out.println("== Predicate == ");
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;

        System.out.println(isEven.test(10)); // true
        System.out.println(isEven.test(9));  // false

        System.out.println(isPositive.test(-2)); // false
        System.out.println(isPositive.test(3)); // true

        // 논리값에 대한 연산을 and, or, negate로 가능
        // : 논리 연산자처럼 조건을 연결
        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive); // and 연산자
        System.out.println(isEvenAndPositive.test(4)); // true
        System.out.println(isEvenAndPositive.test(-4)); // false

        System.out.println("== Function ==");
        // 매개변수(문자열 1개) - 반환값(문자열의 길이값 1개)
        Function<String, Integer> stringLength = s -> s.length();
        Function<Integer, Integer> square = n -> n * n;
        Function<String, String> upperString = s -> s.toUpperCase();

        System.out.println(stringLength.apply("이도경 바보"));
        System.out.println(upperString.apply("nice to meet you"));

        Function<String, Integer> lengthAndSquare = stringLength.andThen(square);
        // : 문자열의 길이(숫자) 값을 인자로 받아 제곱
        System.out.println(lengthAndSquare.apply("Merry ChristMas!"));

        System.out.println();
        System.out.println("=== Consumer ==");
        Consumer<String> printMessage = msg -> System.out.println(msg);
        Consumer<String> printLength = msg -> System.out.println(msg.length());

        printMessage.accept("안녕하세요 :");
        printLength.accept("1234567"); // 7

        Consumer<String> combinedConsumer = printMessage.andThen(printLength);

        System.out.println();

        System.out.println("=== Supplier ===");
        // Math.random(): 0.0과 1.0 사이의 무작위 실수를 반환
        Supplier<Double> randomValue = () -> Math.random();

        System.out.println(randomValue.get());
    }
}
/*
    Predicate -> .test
    Function -> .apply
    Consumer -> .accept
    Supplier -> .get
 */