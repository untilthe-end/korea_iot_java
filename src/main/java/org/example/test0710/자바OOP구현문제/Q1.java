package org.example.test0710.자바OOP구현문제;

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    void makeSound() {
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("야옹");
    }
}


public class Q1 {
    public static void main(String[] args) {
        Animal[] animals = {new Dog("puppy"), new Cat("cat")};
        for (Animal animal : animals) {
            System.out.print(animal.name + " ");
            animal.makeSound();
        }
    }
}
