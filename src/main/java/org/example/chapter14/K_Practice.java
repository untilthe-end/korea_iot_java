package org.example.chapter14;

// == 직원 관리 시스템 == //

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 직원 데이터 정의
@AllArgsConstructor // @Setter 역할 대체
@Getter
@ToString
class Employee {
    private String department;
    private String name;
    private int salary;
}

public class K_Practice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("IT", "이승아", 300),
                new Employee("HR", "조승범", 500),
                new Employee("IT", "김준일", 400),
                new Employee("OP", "전예찬", 350),
                new Employee("HR", "윤대휘", 380)
        );

        // 1. 급여가 400 이상인 직원 '필터링'
        // : filter() - 조건을 검사해서 true 인 요소만을 다시 반환
        List<Employee> filteredEmployee = employees.stream()
                .filter(employee -> employee.getSalary() >= 400)
                .collect(Collectors.toList());

        filteredEmployee.forEach(System.out::println);
        System.out.println();

        // 2. IT 부서 직원의 이름만 추출
        List<String> employeeList = employees.stream()
                // 1) 부서(department)가 'IT' 인 직원을 필터링 - filter
                .filter(employee -> employee.getDepartment().equals("IT"))
                // 2) 부서가 'IT' 인 직원 목록을 전체 순회하여 이름만 추출 - map
                //        .map(employee -> employee.getName())
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(employeeList);
        System.out.println();

        // 3. 특정 부서(HR) 직원 중 이름에 '조'가 포함된 직원 필터링
        // 1) 부서가 'HR' 인 직원을 필터링 >> equals
        // 2) 위의 목록 중 이름에 '조'가 포함된 직원을 필터링 >> contains
        List<Employee> employeeWithCho = employees.stream()
                .filter(employee -> employee.getDepartment().equals("HR"))
                .filter(employee -> employee.getName().contains("조"))
                .collect(Collectors.toList());

        System.out.println(employeeWithCho); // [Employee(department=HR, name=조승범, salary=500)]
        employeeWithCho.forEach(System.out::println); // Employee(department=HR, name=조승범, salary=500)
        System.out.println();

        // 4. 부서별 직원 그룹화
        // Collectors 클래스 - groupingBy
        Map<String, List<Employee>> employeeByDept = employees.stream()
                // .collect(Collectors.groupingBy(e -> e.getDepartment()));
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(employeeByDept);

        for (Map.Entry<String, List<Employee>> entry : employeeByDept.entrySet()) {
            String department = entry.getKey();
            List<Employee> employeesInDept = entry.getValue();

            System.out.println(department + ": ");
            for (Employee employee : employeesInDept) {
                System.out.println(employee.getName() + " ");
            }

            System.out.println();
        }

        employeeByDept.forEach((department, employeeInDept) -> {
            String name = employeeInDept.stream()
                    .map(Employee::getName)
                    .collect(Collectors.joining(" | "));

            System.out.println(department + ": " + name);
        });

        // 5. 부서별 평균 급여 계산
        // Collectors 클래스 - groupingBy
        //                  - averaging타입: 해당 타입의 평균 계산 (averagingInt(각 직원의 급여 전달))
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)
                ));
        System.out.println(avgSalaryByDept);
    }
}
