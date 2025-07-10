package org.example.test0710.자바OOP구현문제;

abstract class Shape {

    abstract double getArea();
}

class Circle extends Shape {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return radius * radius;
    }
}

class Rectangle extends Shape {
    int horizontal;
    int vertical;

    public Rectangle(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    @Override
    double getArea() {
        return horizontal * vertical;
    }
}

public class Q3 {
    public static void main(String[] args) {

        Circle circle = new Circle(3);
        System.out.println("넓이: " + circle.getArea());

        Rectangle rectangle = new Rectangle(3, 5);
        System.out.println("넓이: " + rectangle.getArea());
    }
}
