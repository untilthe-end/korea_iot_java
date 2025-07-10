package org.example.test0710;

public class 자바기초용어모음 {
}

/*
// == 접근제한자 == //
    : (가시성) 변수, 메서드, 클래스 앞에 붙인다.

    >> public: 모든 패키지를 넘나들며 어디에서든 접근 가능하다.
    >> protected: 다른 패키지에서도 접근 가능하나 상속관계에 있는 하위클래스 내에서 접근 가능.
    >> default: 같은 패키지 안에서 접근 가능 | 생략이 가능한 접근 제한자
    >> private: 같은 클래스 내에서 접근 가능.

// == static == //
    : 정적. 공유되는 멤버

    >> static 변수: 클래스 내에서 모든 인스턴스가 공유하는 변수. | 클래스명.스태틱변수명 으로 호출
    >> static 메서드: 재정의 할 수 없다. | 클래스명.메서드명()으로 호출

// == final == //
    : 한번 정해지면 변하지 않음.

    >> final 변수: 무조건 '초기화' 해줘야 함. 생성자 호출로 '초기화' 권장
    >> final 메서드: 재정의 할 수 없음.
    >> final 클래스 : 다른 class가 상속받을 수 없음.

// == super vs this == //

    >> this: 1) 인스턴스 자체 참조 | this.name = name;
             2) 생성자 안에 클래스 내부의 다른 생성자 호출시 | this() 최상단에 사용 할 것

    >> super: 부모 참조 | super.name || super.play()

// == Overloading vs overriding == //

    >> 오버로딩: - 같은 클래스 내에서 같은 메서드명으로 parameter 타입과 개수를 다양하게 생성하는 것.
                - 같은 기능을 하지만 매개변수가 다른 특징.

    >> 오버라이딩: - 상속받은 클래스에서 부모 메서드를 재정의 하는 것.
                 - @Overriding 애노테이션 사용!
                 - 선언부는 동일! 구현부를 원하는대로!

// == abstract == //
    : 불완전 한 것.
                     // -> instance 생성 할 수 없음.
    >> abstract 클래스: 공통된 기능을 불완전하게 묶어둔 곳 | 상속해서 써야함.
    >> abstract 메서드: 선언부만 있음(자식 클래스에서 구현해줘야함)

// == interface vs abstract class == //

    >> interface: 규칙  | 다중 구현 o | 상수 | 추상 메서드 | default 메서드 | 정적 메서드
    >> abstract class: | 다중 상속 x       | 추상 메서드 | 일반 메서드(인스턴스 메서드)

// == extends vs implements == //

    >> extends:    상속 | 앞 뒤가 같은 타입일 때 | class apple extends Fruits
                   class -> class || class -> abstract class ||
                   interface -> interface

    >> implements: 구현 | 앞 뒤가 다른 타입일 때 | class BikeApp implements EcoFriendly
                   class -> interface

// == try-catch-finally == //

    >> try: 시도해라 ~
    >> catch: 오류가 있으면 잡는 구간
    >> finally: 무엇이든 실행할 수 있는 구간

    try {
        int number = 10 / 0;
    } catch (ArithmeticException e) {
        system.out.println(e.getMessage());
    } finally {
        system.out.println("검증 완료~");
    }


























 */