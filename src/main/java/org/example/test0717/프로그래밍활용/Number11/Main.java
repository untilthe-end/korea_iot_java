package org.example.test0717.프로그래밍활용.Number11;


class Parent {
    void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    void display() {
        System.out.println("Child");
    }
}


public class Main {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.display();
    }

}
