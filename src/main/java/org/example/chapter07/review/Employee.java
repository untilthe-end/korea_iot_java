package org.example.chapter07.review;

public class Employee {
    private final String employeeId;

    private String name;
    private String position;
    private int salary;

    public Employee(String employeeId, String name, String position, int salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;

        if (salary >= 0) {
            this.salary = salary;
        } else {
            this.salary = 0;
        }
    }

    public void displayInfo() {
        System.out.println("사원 ID: " + employeeId
                + " 이름: " + name
                + " 직급: " + position
                + " 급여: " + salary
        );
    }

    public void setName(String name) {
        if (name.equals(null) || name.equals("")) {
            System.out.println("무시");
        } else {
            this.name = name;
            System.out.println("이름을 '" + name + "'으로 변경합니다.");
        }
    }

    public void setPosition(String position) {
        if (position.equals(null) || position.equals("")) {
            System.out.println("무시");
        } else {
            this.position = position;
        }
    }

    public void setSalary(int salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("급여를 " + salary +"로 변경시도합니다.");
        }
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
