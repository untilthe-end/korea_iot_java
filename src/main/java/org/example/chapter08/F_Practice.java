package org.example.chapter08;

// abstract class
// : mobile application
abstract class MobileApp {
    // - 각 앱 마다 '고유한 실행' 정의(상속받은 클래스에서 구현)
    abstract void execute();

    // 일반 (구현) 메서드
    void appInfo() {
        System.out.println("This is a mobile app");
    }
}

// == SNS app == //
class SocialApp extends MobileApp {
    String name; // 인스턴스 필드 (각 개체가 가질 이름 Ex. instagram, kakaoTalk ..etc)

    SocialApp(String name) {
        this.name = name;
    }

    @Override
    void execute() {
        System.out.println(name + " is loaded...");
    }

    @Override
    void appInfo() {
        System.out.println(name + " app is most popular social application.");
    }

    // social app 고유 메서드
    void shareContent(String content) {
        System.out.println(name + " shares: " + content);
    }
}

// == Game app == //
class GameApp extends MobileApp {

    @Override
    void execute() {
        System.out.println("Game app executes");
    }
}

public class F_Practice {
    public static void main(String[] args) {
        // == 다형성 적용 == //
        MobileApp gameApp = new GameApp();
        gameApp.execute();
        gameApp.appInfo();

        GameApp ga1 = new GameApp();
        ga1.execute();
        ga1.appInfo();

        System.out.println();

        MobileApp socialApp = new SocialApp("Instagram");
        socialApp.execute();
        socialApp.appInfo();

        if (socialApp instanceof GameApp) {
            System.out.println("socialApp이 GameApp 타입의 객체");
            GameApp onlyGame = (GameApp) socialApp;
        } else if (socialApp instanceof SocialApp) {
            SocialApp downSocialApp = (SocialApp) socialApp;
            downSocialApp.shareContent("이미지 공유하기");
        }

        System.out.println();
        MobileApp[] apps = {
                // 생성과 동시에 업캐스팅 - 묵시적 형 변환
                new GameApp(),
                new SocialApp("Facebook"),
                new SocialApp("kakaoTalk")
        };

        for (MobileApp app : apps) {
            app.execute();
            app.appInfo();

            if (app instanceof SocialApp) {
                // 다운 캐스팅
                SocialApp specificSocial = (SocialApp) app;
                specificSocial.shareContent("Files");
            }
        }
    }
}
