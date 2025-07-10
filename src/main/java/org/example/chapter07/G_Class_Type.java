package org.example.chapter07;

// === 자바의 데이터 타입 === //
// 1) 기본 자료형: 변수에 데이터 그 자체를 저장
//      - 자료 형 변환
//      - '자동 형 변환(묵시적)' & '강제 형 변환(명시적)
// 2) 참조 자료형: 변수에 데이터가 저장된 주소값을 저장
//      - 클래스 타입 형 변환
//      - 자동 타입 변환 & 강제 타입 변환
//      >> 자료 형 변환 보다 가능한 범위 좁음
//      >> 상속 관계에 있는 클래스 사이에서만 변환 가능!
//
class G_Parent {
    void displayInfo() {
        System.out.println("부모 클래스 입니다.");
    }
}

class G_Child extends G_Parent {
    @Override
    void displayInfo() {
        System.out.println("자식 클래스입니다. (재정의)");
    }

    void childMethod() {
        System.out.println("자식 클래스만 가지는 메서드");
    }
}

public class G_Class_Type {
    byte a = 1;
    short b = a;
    char c = (char) b; // 타입의 체계가 달라도(숫자 - 문자의 관계라도) 변환 가능

    public static void main(String[] args) {
        // 1. 자동 타입 변환( 업캐스팅, Upcasting)
        // : 자식 객체를 부모 클래스 타입으로 변환
        // > 직접 명시 x, 자동으로 타입 변환 발생

        // 1) 자식 객체를 생성하면서 즉시 부모 타입으로 변환하여 저장
        // 부모 클래스타입 객체변수명 = new 자식클래스();

        G_Parent childObject = new G_Child();
        childObject.displayInfo();
        //childObject.childMethod();

        // cf) 자동 형 변환(업캐스팅)의 경우 해당 객체는 보존되면서, 부모 객체처럼 사용
        //      >> 두 클래스 간의 공통된 특성이 아니면, 자식만의 기능은 사용할 수 x

        // 2) 이미 생성된 객체를 부모 타입으로 변환
        G_Child childObject2 = new G_Child();
        childObject2.displayInfo();
        childObject2.childMethod();

        // 부모클래스 객체변수명  = 자식 객체변수;
        G_Parent parentObject = childObject2; // 업캐스팅
        parentObject.displayInfo();
        //parentObject.childMethod();

                                                                 //   부모 클래스에 업캐스팅 되면 자식만의 메서드 사용 불가.

        // 2. 강제 타입 변환(다운캐스팅, DownCasting)
        // : '부모 클래스 타입으로 변환된 객체를' 다시! 자식 클래스 타입으로 변환하는 것
        // - 자식 클래스에만 정의된 메서드에 다시 접근 가능하도록

        // 자식타입 객체 변수명 = (자식타입) 부모객체;
        G_Child g_child = (G_Child) parentObject;
        g_child.displayInfo();
        g_child.childMethod();

        // cf) 클래스 타입 변환 시 주의점!
        // : 반드시 상속 관계와 객체 실제 타입을 확인!
        // >> 잘못된 캐스팅은 Exception 예외 발생

        G_Parent g1 = new G_Parent();
        G_Child c1 = (G_Child) g1;   // 원래 부모객체도 자식 타입으로 다운캐스팅 가능!?

    }
}
