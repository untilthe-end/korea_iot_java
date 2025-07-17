package org.example.test0717.프로그래밍활용;

public class 서술형 {
    public static void main(String[] args) {
/*
1)
    기본 데이터 타입:

        의미:
        종류: byte, char,boolean, short, int, long, float, double
        저장되는 것: 값 그 자체
        예시: int a = 20;

    참조 데이터 타입:
        의미:
        종류: String, Array... 등등
        저장되는 것: 주소 값.
        예시: String[] items = { "컴퓨터", "마우스", "키보드"}

2) public class Two {
    public static void main(String[] args) {
        int num1 = 10;
        double num2 = 3.5;

        double result = num1 + num2;
        System.out.println(result);
    }
}

3) public class Three {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("숫자를 입력하세요: ");
        int inputNumber = Integer.parseInt(sc.nextLine());

        if (inputNumber < 1) {
            System.out.println("0보다 큰 수 입력!!!");
        } else if (inputNumber % 2 == 0) {
            System.out.println("입력하신 숫자는 짝수입니다.");
        } else {
            System.out.println("입력하신 숫자는 홀수입니다.");
        }
    }
}

4) public class Four {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5,};
        for (int number : numbers) {
            System.out.print(number +" ");
        }
    }
}

5) class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

public class StudentMain {
    public static void main(String[] args) {
        Student[] students = {new Student("John", 83),
                new Student("Jane", 92),
                new Student("Tom", 78),
                new Student("Emily", 88),
                new Student("Alex", 95)
        };

        for (Student student : students) {
            if (student.getScore() >= 90) {
                System.out.println(student.getName());
            }
        }
    }
}

6)  Object 클래스
7)  size()
8)
9)  4
10) 반드시 하나의 추상 메서드 포함
11) Child
12) public static
13) 아니오
14) - 상속 관계여야 함.
    - if 조건문으로 instanceof 로 dog가 animal 의 자식 객체인지 확인 후!
15) 객체 생성 시 복잡한 생성자 호출을 피할 수 있다.
16) Controller
17) public
18) 추상 클래스는 정적 메서드를 가질 수 없다.


*/


    }
}
