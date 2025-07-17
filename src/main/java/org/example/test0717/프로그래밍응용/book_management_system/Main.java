package org.example.test0717.프로그래밍응용.book_management_system;

import org.example.test0717.프로그래밍응용.book_management_system.exception.BookNotFoundException;
import org.example.test0717.프로그래밍응용.book_management_system.service.BookServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){


        BookServiceImpl bookService = new BookServiceImpl();
        Scanner sc = new Scanner(System.in);

        System.out.println("==== 도서 관리 시스템 ====");

        while (true) {

            System.out.println("1. 도서 등록");
            System.out.println("2. 도서 전체 조회");
            System.out.println("3. 도서 제목으로 검색");
            System.out.println("4. 도서 ID로 조회");
            System.out.println("5. 도서 저자 수정");
            System.out.println("6. 도서 삭제");
            System.out.println("0. 프로그램 종료");

            String choice = sc.nextLine();

            try {
                switch (choice) {

                    case "1":
                        System.out.print("책 번호 입력: ");
                        String id = sc.nextLine();
                        System.out.print("책 제목 입력: ");
                        String title = sc.nextLine();
                        System.out.print("책 저자 입력: ");
                        String author = sc.nextLine();

                        bookService.addBooks(id, title, author);
                        break;
                    case "2":
                        bookService.getAllBooks();
                        break;
                    case "3":
                        System.out.print("책 제목 입력: ");
                        String bookTitle = sc.nextLine();
                        bookService.searchByBookTitle(bookTitle);
                        break;

                    case "4":
                        System.out.print("책 ID 입력: ");
                        String bookId = sc.nextLine();
                        bookService.searchByBookId(bookId);
                        break;

                    case "5":
                        System.out.print("수정할 책 번호 입력: ");
                        String bookNumber = sc.nextLine();
                        System.out.print("새 저자 이름 입력: ");
                        String newAuthor = sc.nextLine();
                        bookService.updateBookAuthor(bookNumber, newAuthor);
                        break;

                    case "6":
                        System.out.print("삭제할 책 번호 입력: ");
                        String num = sc.nextLine();
                        bookService.deleteBook(num);
                        break;
                    case "0":
                        sc.close();
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
