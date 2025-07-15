package org.example.chpater13;
// === 싱글톤 패턴 === //
    // : 소프트웨어 설계 패턴 중 하나
    // - 클래스의 인스턴스가 하나만 생성되도록 보장
    // - 해당 클래스의 인스턴스에 전역적으로 접근이 가능하도록 하는 패턴

    // 1) 싱글톤 패턴 특징
    // - 클래스의 인스턴스가 단 하나만 존재
    // - 인스턴스에 대해 전역 접근을 제공
    // - 주로 설정 정보 관리 객체, 공유 자원 관리 객체, 로그 객체 등에서 사용

    // 2) 사용 목적
    // - 객체의 유일성을 보장
    // - 자원의 절약

    // 3) 장단점
    // - 장점
    //      : 중복 인스턴스 방지 (메모리 절약)
    //      : 글로벌 상태 유지
    //      : 일관된 상태 유지
    // - 단점
    //      : 결합도 증가 - 여러 클래스가 같은 인스턴스 공유 시, 하나가 변경될 때 다른곳에 영향을 미칠 수 있음.
    //      : 테스트에 어려움 - 전역 상태를 사용하는 특성

// 4) 구현 방법
class Singleton {
    // 필드값: static - 인스턴스화 없이 호출 가능 & 자원이 하나의 값을 가짐
    private static Singleton instance;

    // 생성자: private
    // >> 외부에서 직접적인 인스턴스화 불가!
    // >> 반드시 해당 클래스 내에서만 인스턴스화!

    private Singleton() {
    }

    // 싱글톤 패턴의 전역 접근성을 제공하는 메서드 정의 (인스턴스화 담당)
    public static Singleton getInstance() {
        // 주로 getInstance 메서드명 사용
        // : 반환 타입은 클래스 타입
        if (instance == null) {
            // 필드에 초기화 이전 >> 아직 인스턴스화 x
            instance = new Singleton();
        }
        return instance;
        // 1) if 조건문이 true: 인스턴스화 된 객체를 반환
        // 2) if 조건문이 false: 기존의 필드에 저장된 객체 반환
    }
}

// == 교장 선생님 클래스 == //
// : 학교에 교장 선생님은 한 명만 존재!

class SchoolPrincipal {
    // 유일한 객체를 저장할 변수
    // : 클래스 그 자체의 객체 값을 저장
    private static SchoolPrincipal instance;

    // 1.생성자를 private 설정 (외부에서 객체 생성 불가!)
    // cf) 생성자: 반환 타입x, 접근제한자 가능, 이름은 클래스명과 동일
    private SchoolPrincipal() {
        System.out.println("교장 선생님 객체 생성!");
    }

    // 2. getInstance() 메서드를 통해 객체 생성
    // : 해당 클래스로 생성된 객체가 없는 경우에만 새롭게 생성하여 반환
    public static SchoolPrincipal getInstance() {
        if (instance == null) {
            // 객체가 없다면 생성
            instance = new SchoolPrincipal();
        }
        return instance; // 기존 객체(if가 false) or 생성 객체(if가 true) 반환
    }

    public void announce() {
        System.out.println("공부열심히 하고 운동열심히하고 일찍 자고 일어나세요.");
    }
}

class Example {

}
public class D_Singleton {
    public static void main(String[] args) {
         // instance == null (true)
        // : 새로운 객체 생성
        SchoolPrincipal principal1 = SchoolPrincipal.getInstance();

        SchoolPrincipal principal2 = SchoolPrincipal.getInstance();
        SchoolPrincipal principal3 = SchoolPrincipal.getInstance();
        SchoolPrincipal principal4 = SchoolPrincipal.getInstance();

        System.out.println(principal1);
        System.out.println(principal2);
        System.out.println(principal3);
        System.out.println(principal4);

        Example example1 = new Example();
        Example example2 = new Example();
        Example example3 = new Example();

        System.out.println("example1 = " + example1);
        System.out.println("example2 = " + example2);
        System.out.println("example3 = " + example3);

        System.out.println(principal1 == principal2);
    }
}