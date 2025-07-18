package org.example.chapter09_practice2;

import org.example.chapter09_practice2.model.User;
import org.example.chapter09_practice2.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("1. 사용자 등록");
            System.out.println("2. 사용자 전체 조회");
            System.out.println("3. 사용자 id로 조회");
            System.out.println("4. 사용자 이름으로 조회");
            System.out.println("5. 사용자 Email 수정");
            System.out.println("6. 사용자 삭제");
            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        System.out.print("id 입력: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("이름 입력: ");
                        String name = sc.nextLine();
                        System.out.print("email 입력: ");
                        String email = sc.nextLine();
                        userService.addUser(new User(id, name, email));

                        break;

                    case 2:
                        System.out.println(userService.getAllUsers());
                        break;
                    case 3:
                        System.out.print("찾을 유저 id 입력: ");
                        int userId = Integer.parseInt(sc.nextLine());
                        userService.findUserById(userId);
                        break;
                    case 4:
                        System.out.print("찾을 유저 이름 입력: ");
                        String userName = sc.nextLine();
                        userService.findUsersByName(userName);
                        break;
                    case 5:
                        System.out.print("수정할 사용자 id 입력: ");
                        int userIdd = Integer.parseInt(sc.nextLine());
                        System.out.print("새로운 email 입력: ");
                        String newEmail = sc.nextLine();
                        userService.updateUserEmail(userIdd, newEmail);
                        break;
                    case 6:
                        System.out.print("삭제할 사용자 id 입력: ");
                        int deleteId = Integer.parseInt(sc.nextLine());
                        userService.deleteUser(deleteId);
                        break;
                    case 7:
                        System.out.println("시스템 종료");
                        return;

                    default:
                        System.out.println("값을 잘못 입력하셨습니다.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
