package org.example.chapter07;

import org.example.chapter07.review.Employee;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("000012", "홍길동", "과장", 4000);
        employee1.displayInfo();
        employee1.setName("조승범");
        employee1.setSalary(-38000);
        employee1.displayInfo();

        Employee employee2 = new Employee("000013", null, null, -3322);
        employee2.displayInfo();
    }
}
