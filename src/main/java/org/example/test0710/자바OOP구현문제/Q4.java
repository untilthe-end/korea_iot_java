package org.example.test0710.자바OOP구현문제;

interface Playable {
    void play();
}

class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("피아노를 연주합니다.");
    }

    public void pianoPlay() {
        System.out.println("피아노는 양손으로 건반을 누릅니다.");
    }
}

class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("기타를 연주합니다.");
    }

    public void guitarPlay() {
        System.out.println("기타는 줄을 튕겨서 연주합니다.");
    }
}

public class Q4 {
    public static void main(String[] args) {

// 1.
//        Piano piano1 = new Piano();
//        piano1.play();
//
//        Guitar guitar = new Guitar();
//        guitar.play();

// 2.
        Playable[] instruments = {new Piano(), new Guitar()};
        for (Playable instrument : instruments) {
            instrument.play();

            if (instrument instanceof Piano) {
                Piano onlyPiano = (Piano) instrument;
                onlyPiano.pianoPlay();
            }
        }
    }
}

/*
다형성?  - 상속 / 오버라이딩 / up/downCasting
 */