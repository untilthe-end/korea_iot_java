package org.example.chapter06;

// == 자바의 변수 숨김과 인스턴스 변수의 독립성 == //

class M {
    String name = "Mammal";
    int age = 10;
    M() {

    }

    M(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class C extends M {
    String name = "Cat";

    // C와 M의 name 필드는 서로 독립적인 상태
    // >> 상속 관계에서 인스턴스 변수까지 공유되지는 않는다.

    // cf) 자식 클래스에서 동일한 이름의 변수 선언 == 변수 숨김(hiding) 발생
    // String name = "Mammal"; - 부모 변수 숨김처리

    // cf) 두 가지 name 필드의 접근 방식
    // 1. 부모 Mammal: super.name
    // 2. 자식 Cat: this.name || name
    C() {
        // super();
    }

    C(String name, int age) {
       super(name, age);
//       this.name = name; // << 요고를 하면 자식 클래스에도 "초코"가 들어감.
        // >> 생성자 내에서 호출된 super(name)을 통해 부모 클래스인
        //      Mammal(String name) 생성자를 호출
        //      , 부모의 name만 "나비"로 설정
    }

    void displayCate() {
        System.out.println("이름: " + name); // this.name
        System.out.println("나이: " + age); // super.age
    }
}

// cf) 자바에서는 인스턴스 변수(필드)가 override(재정의) 되지 않음
//      >> 숨김 처리 발생
public class E_Practice {
    public static void main(String[] args) {
        C c = new C("초코", 20);
        c.displayCate();
        //이름: Cat
        //나이: 20
    }
}
