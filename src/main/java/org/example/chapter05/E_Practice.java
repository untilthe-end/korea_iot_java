package org.example.chapter05;

class BaseballPlayer {
                                                    // === 인스턴스 변수 ===
                                                    // 선수 이름(name - 문자열)
                                                    // 타율(battingAverage - 실수)
                                                    // 홈런 수(homeRuns - 정수)
    String name;
    double battingAverage;
    int homeRuns;

                                                    // === 정적(클래스)변수 ===
                                                    // : 생성된 선수의 총 인원(playerCount - 정수)
                                                    // >> 모든 인스턴스에서 공유

    static int playerCount;

                                                    // == 생성자 ==
                                                    // + 필드값 초기화 & 정적 변수 후위 증가

    public static int getPlayerCount() {
        return playerCount;
    }

    public BaseballPlayer(String name, double battingAverage, int homeRuns) {
        this.name = name;
        this.battingAverage = battingAverage;
        this.homeRuns = homeRuns;

        playerCount++;
    }

                                                    // 1) 인스턴스 메서드
                                                    // : double newBattingAverage, int newHomeRuns 값을 전달 받아 각각이 타율과 홈런 수를 업데이트
    void updateInfo(double newBattingAverage, int newHomeRuns) {
        battingAverage = newBattingAverage;
        homeRuns = newHomeRuns;
    }

                                                    // 2) 정적 메서드
                                                    // : 특정 홈런 수 이상인 선수를 평가
                                                    // : 홈런 수가 20개 이상이면 "홈런상 후보! 축하드립니다!"
                                                    // : 미만일 경우 "홈런상 후보에 등록될 수 없습니다." 반환
    static String evaluate(int homeRuns) {
        String result;
        if (homeRuns >= 20) {
            return "홈런상 후보! 축하드립니다!";
        } else {
            return "홈런상 후보에 등록될 수 없습니다.";
        }
    }

    public String getName() {
        return name;
    }
}

public class E_Practice {
    public static void main(String[] args) {
        BaseballPlayer player1 = new BaseballPlayer("홍길동", 0.323, 16);
        BaseballPlayer player2 = new BaseballPlayer("김구구", 0.214, 25);
        BaseballPlayer player3 = new BaseballPlayer("윤여준", 0.412, 11);
        BaseballPlayer player4 = new BaseballPlayer("최다정", 0.292, 60);
        System.out.println("총 선수: " + BaseballPlayer.playerCount + "명");

        player1.updateInfo(4.0, 24);
        System.out.println(player1.battingAverage);
        System.out.println(player2.homeRuns);
        System.out.println(BaseballPlayer.evaluate(player1.homeRuns));
        System.out.println(BaseballPlayer.evaluate(player2.homeRuns));
        System.out.println(BaseballPlayer.evaluate(player3.homeRuns));
        System.out.println(BaseballPlayer.evaluate(player4.homeRuns));
    }
}
