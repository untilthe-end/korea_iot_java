package org.example.chapter08;

//1. 추상 클래스 `TransportApp`을 정의하세요.
//   - 추상 메서드: `move()` → "이동 수단에 따라 이동 방식이 다릅니다." 를 출력하도록 구현 필요
//   - 일반 메서드: `info()` → "이동 관련 애플리케이션입니다." 를 출력

abstract class TransportApp {
    abstract void move();

    void info() {
        System.out.println("이동 관련 애플리케이션 입니다.");
    }
}

//2. `TaxiApp` 클래스는 `TransportApp`을 상속하고, `move()`를 오버라이딩하여 "택시로 이동합니다." 출력

class TaxiApp extends TransportApp {
    @Override
    void move() {
        System.out.println("택시로 이동합니다.");
    }
}

//3. `BikeApp` 클래스는 `TransportApp`을 상속하고, `move()`를 오버라이딩하여 "자전거로 이동합니다." 출력
// 5. `BikeApp`은 `EcoFriendly`도 구현하여 친환경 메시지를 출력할 수 있도록 구현
class BikeApp extends TransportApp implements EcoFriendly {
    @Override
    void move() {
        System.out.println("자전거로 이동합니다.");
    }

    @Override
    public void ecoMessage() {
        System.out.println("이동 수단은 친환경적입니다.");
    }

    @Override
    public String toString() {
        return "EcoFriendly 구현한 객체는 BikeApp 입니다.";
    }
}

//4. `EcoFriendly` 인터페이스를 정의하세요.
//   - 디폴트 메서드: `ecoMessage()` → "이동 수단은 친환경적입니다." 출력
interface EcoFriendly {
    default void ecoMessage() {
        System.out.println("이동 수단은 친환경적입니다.");
    }
}

public class Z_Review {
    public static void main(String[] args) {
        TransportApp[] transportApps = {new TaxiApp(), new BikeApp()};

        for (TransportApp transportApp : transportApps) {
            transportApp.move();
            transportApp.info();

            System.out.println();
            if (transportApp instanceof EcoFriendly) {
                EcoFriendly transportApp1 = (EcoFriendly) transportApp;
                transportApp1.ecoMessage();
                System.out.println(transportApp1); // BikeApp class에 toString() 오버라이딩 함!

            }
        }
    }
}
