package org.example.정보처리기사_실기_2025_2;

public class Java03 {
    public static class Parent {
        public int x(int i) {
            return i + 2;
        }

        // static 메서드는 오버라이딩 x
        // 자식 class 에있는 static 은 별개의 메서드이다.
        public static String id() {
            return "P";
        }
    }

    public static class Child extends Parent {
        @Override
        public int x(int i) {
            return i + 3;
        }

        public String x(String s) {
            return s + "R";
        }

        public static String id() {
            return "C";
        }
    }

    public static void main(String[] args) {
        Parent p1 = new Child();

        System.out.println(p1.x(2) + p1.id());
    }
}