package org.example.chapter08;

// === 인터페이스 === //
// : Fruit 과일 인터페이스 정의
// - color: 추상메서드
// - describe: 디폴트 메서드
// - printType: 정적 메서드

interface Fruit {
    String color();                         // 추상 메서드: public abstract 생략

    default void describe() {               // default 메서드: 재정의(오버라이딩) 가능
        System.out.println("과일의 색상은 " + color() + "입니다.");
    }

    static void printType() {               // static(정적) 메서드: 재정의(오버라이딩) 불가능
        System.out.println("과일(Fruit) 타입입니다.");
    }
}

class Apple implements Fruit {
    public String color() {
        return "red";
    }
}

class Orange implements Fruit {
    public String color() {
        return "orange";
    }
}

class Banana implements Fruit {
    public String color() {
        return "yellow";
    }

    @Override
    public void describe() {
        System.out.println("과일의 색상은 " + color() + " 이며, 모양은 깁니다.");
    }
}

// 인터페이스의 상속 //
// extends: 앞뒤가 같으면 확장가능
// >> class extends class
// >> interface extends interface
// implements:
// >> class 만 implements로 interface를 구현할수 있다.
interface TropicalFruit extends Fruit {
    //  [ 생략 ]
    // - color: 추상 메서드
    // - describe: 디폴트 메서드
    // - printType: 정적 메서드

    default void tropicalFeature() {
        System.out.println("열대 과일은 후숙하면 더 맛있습니다.");
    }
}

class Mango implements TropicalFruit {
    @Override
    public String color() {
        return "yellow";
    }

    @Override
    public void describe() {
        System.out.println("과일의 색상은 " + color() + "이며, 모양은 타원형이다.");
    }
}

public class G_Practice {
    public static void main(String[] args) {
        // 다형성 적용
        Fruit apple = new Apple();
        Fruit orange = new Orange();
        Fruit banana = new Banana();
        TropicalFruit mango = new Mango();

        // 업 캐스팅
        // : mango를 Fruit 타입으로 형 변환
        // > TropicalFruit가 Fruit를 상속받는 인터페이스
        Fruit[] fruits = { apple, orange, banana, mango };
        for (Fruit fruit : fruits) {
            fruit.describe();
//            fruit.topicalFeature();

            if (fruit instanceof TropicalFruit) {
                TropicalFruit tropicalFruit = (TropicalFruit) fruit;
                tropicalFruit.tropicalFeature();
            }
        }
        // A instanceof B
        // 'A' 객체가 B 클래스(종류)와 같은지 확인
        class 동물 {}
        class 고양이 extends 동물 {}
        class 강아지 extends 동물 {}

        동물 animal = new 동물();
        동물 cat = new 고양이();
        동물 dog = new 강아지();

        if (animal instanceof 고양이 ) {
            System.out.println("실행x - 부모 객체는 자식 객체에 담을 수 없음!");
        }

        if (cat instanceof 동물) {
            System.out.println("실행됨! - 나비는 동물의 일부!");
        }

        if (dog instanceof 고양이) {
            System.out.println("실행됨! 나비는 원래 고양이! 고양이만이 가진 특정 기능을 수행하기를 원함!");
        }
            고양이 야옹 = (고양이) cat; // if 조건문 외부에서도 가능! 정상 코드! (다만! 확실하게 검증하고 변환하자!)
    }
}


