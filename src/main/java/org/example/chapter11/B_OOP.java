package org.example.chapter11;

// === SOLID 원칙 === //

// 4. ISP(Interface Segregation Principle, 인터페이스 분리 원칙)
    // : 하나의 큰 인터페이스보다 여러 개의 작은 인터페이스를 사용을 권장
    // - 인터페이스의 단일 책임을 강조
    // - 클래스는 자신이 사용하지 않는 메서드에 의존하지 않아야 함.

    // 1) 잘못된 설계 예시
    // - 필요하지 않은 행위를 강제로 구현하고 있음

    interface Worker {
        void work();
        void eat();
    }

    class Robot implements Worker {

        @Override
        public void work() {
            System.out.println("로봇은 일을 할 수 있습니다.");
        }

        @Override
        public void eat() {
            System.out.println("로봇은 음식을 먹지 않습니다.");
        }
    }

    // 인터페이스가 SRP(단일 책임 원칙)도 위반하고, ISP도 위반한 상태

    // 2) 올바른 설계 예시
    interface Workable { void work(); }
    interface Eatable { void eat(); }

    class Employee implements Workable, Eatable {
        // interface는 다중 구현 가능

        @Override
        public void work() {
            System.out.println("9시부터 6시까지 업무시간 입니다.");
        }

        @Override
        public void eat() {
            System.out.println("13시 부터 14시까지 점심시간 입니다.");
        }
    }

    class RobotClass implements Workable {
        @Override
        public void work() {
            System.out.println("로봇은 24시간 일합니다.");
        }
    }

// 5. DIP(Dependency Inversion Principle, 의존 역전 원칙)
    // : 고수준 모듈은 저수준 모듈에 의존해서는 안됨.
    // - 모두 추상화에 의존해야 함
    // - 세부 구현이 아닌, 추상화 된 인터페이스에 의존하도록 설계
    // >> 구체적인 클래스를 직접 쓰지말고, 인터페이스를 사용해서 느슨하게 연결!


    // 1) 잘못된 설계 예시
    // - MathBook 의 구체적인 클래스에 의존
    // >> 다른 책으로 변경하려면 코드 자체를 수정 (유지보수성 ↓)
    class MathBook  {
        void read() {
            System.out.println("수학책을 읽습니다.");
        }
    }

    class WrongStudent {
        private MathBook book;

        public WrongStudent() {
            this.book = new MathBook();
        }

        void study() {
            book.read();
        }
    }

    // 2) 올바른 예제
    interface Book {
        void read();
    }

    class ScienceBook implements Book {
        @Override
        public void read() {
            System.out.println("과학책을 읽습니다.");
        }
    }

    class EnglishBook implements Book {
        @Override
        public void read() {
            System.out.println("영어책을 읽습니다.");
        }
    }

    class CorrectStudent {
        private Book book; // 추상화(인터페이스)에 의존

        public CorrectStudent(Book book) {
            this.book = book;
        }

        void study() {
            book.read();
        }
    }

public class B_OOP {
    public static void main(String[] args) {
        Book scienceBook = new ScienceBook();
        Book englishBook = new EnglishBook();

        CorrectStudent st1 = new CorrectStudent(scienceBook);
        st1.study();

        CorrectStudent st2 = new CorrectStudent(englishBook);
        st2.study();
    }
}
