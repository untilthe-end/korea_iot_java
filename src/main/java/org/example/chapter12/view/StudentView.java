package org.example.chapter12.view;

import org.example.chapter12.controller.StudentController;
import org.example.chapter12.dto.StudentRequestDto;
import org.example.chapter12.dto.StudentResponseDto;

import java.util.List;
import java.util.Scanner;
//
public class StudentView {
    private final Scanner sc;
    private final StudentController controller;

    public StudentView(Scanner sc, StudentController controller) {
        this.sc = sc;
        this.controller = controller;
    }

    public void showMenu() {
        while(true) {

            try {
                System.out.println("=== 학생 관리 시스템 ===");
                System.out.println("1. 학생 추가");
                System.out.println("2. 학생 조회 전체");
                System.out.println("3. 학생 조회 단건");
                System.out.println("4. 학생 정보수정");
                System.out.println("5. 학생 삭제");
                System.out.println("6. 학생 프로그램 종료");
                System.out.print("메뉴 선택 >> ");

                // 버퍼처리 안해도 된다는데?
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    // switch-case 화살표 문법 (Java 14 버전 이후 사용 가능)
                    // : 기존의 case: + break 문법을 대체하여 각 case만 실행하는 문법

                    case 1 -> addStudentView();
                    case 2 -> showAllStudentsView();
                    case 3 -> showStudentByStudentNumber();
                    case 4 -> updateStudentView();
                    case 5 -> deleteStudentView();
                    case 6 -> {
                        // switch-case 문의 화살표 문법에서 여러줄 코드 작성시 { } 중괗로호 범위를 감싸야 한다!
                        System.out.println("프로그램을 종료합니다.");
                        return; // 해당 메서드(showMenu) 종료
                    }
                    default -> System.out.println("🚫잘못된 입력입니다. 다시 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해야 합니다." +e.getMessage());
            } catch (Exception e) {
                System.out.println("오류 발생! " + e.getMessage());
            }
        }
    }

    private void addStudentView() {
        System.out.print("이름: ");
        String name = sc.nextLine();

        System.out.print("나이: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("학번: ");
        String studentNumber = sc.nextLine();

        StudentRequestDto dto = new StudentRequestDto(name, age, studentNumber);
        controller.addStudent(dto); // 요청값을 하나의 객체로 감싸서 전달 (DTO: 데이터 전달을 위한 객체
    }

    private void showAllStudentsView() {
        List<StudentResponseDto> list = controller.getAllStudent();

        if (list.isEmpty()) {
            // 리스트 내부의 요소가 없는 경우
            System.out.println("등록된 학생이 없습니다.");
        } else {
            for (StudentResponseDto dto : list) {
                System.out.println(dto);
            }
        }
    }

    private void showStudentByStudentNumber() {
        System.out.print("조회할 학생의 학번을 입력해주세요: ");
        String studentNumber = sc.nextLine();

        StudentResponseDto dto = controller.getStudentByNumber(studentNumber);
        // 모든 클래스 타입은 Object 클래스 타입을 상속 받음
        // >> Object(참조) 타입은 기본값으로 null을 가짐

        if (dto == null) {
            System.out.println(studentNumber + "학번의 학생을 찾을 수 없습니다: " );
        } else {
            System.out.println(dto);
        }
    }

    private void updateStudentView() {
        System.out.print("수정할 학생 학번 입력: ");
        String studentNumber = sc.nextLine();

        System.out.print("새 이름: ");
        String name = sc.nextLine();

        System.out.print("새 나이: ");
        int age = Integer.parseInt(sc.nextLine());

        StudentRequestDto dto = new StudentRequestDto(name, age, studentNumber);

        boolean result = controller.updateStudent(dto);

        System.out.println(result ? "Updated" : "Failed to update the Student....");

    }

    private void deleteStudentView() {
        System.out.print("삭제할 학생의 학번: ");
        String studentNumber = sc.nextLine();

        boolean result = controller.removeStudent(studentNumber);
        System.out.println(result ? "Deleted" : "Failed to delete the File....");

    }
}
