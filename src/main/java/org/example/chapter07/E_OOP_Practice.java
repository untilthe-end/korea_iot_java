package org.example.chapter07;

// == 도서 관리 시스템 == //
// : 책의 정보 저장, 책의 상태(대여 가능 여부) 확인, 책의 정보 출력

// 1) Book 클래스
// : 속성) title(String, 불변성), author(String, 불변성), isAvailable(boolean)
// : 메서드) borrowBook(), returnBook(), displayInfo()
// : 생성자) 매개변수 - title, author

class Book {
    private final String title;
    private final String author;
    private boolean isAvailable;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        isAvailable = true;
    }
    //    Book () {}

    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("책 대여가 성공적으로 완료되었습니다.");
        } else {
            System.out.println("현재 대여 중입니다. (대여불가)");
        }
    }

    void returnBook() {
        if (!isAvailable) {
            // isAvailable이 false인 상태 - 대여중인 상태
            isAvailable = true;
            System.out.println("책 반납이 성공적으로 완료되었습니다.");
        } else {
            System.out.println("이미 반납된 상태입니다. (반납 불가)");
        }
    }

    void displayInfo() {
        System.out.println("제목: " + title + " | 저자: " + author + " | 대여가능 여부: " + (isAvailable ? "대여 가능" : "대여 중"));
    }

    // 캡슐화를 위한 getter 메서드 추가
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // boolean 데이터는 getter 사용시 get 키워드 작성을 '권장하지 않음'
    public boolean isAvailable() {
        return isAvailable;
    }
}

// 2) Ebook 클래스 - Book 클래스를 상속
// 추가 속성) filesize(double)
// 추가 메서드) displayInfo() - 재정의, fileSize()
// 생성자) Ebook(title, author, fileSize)

class Ebook extends Book {

    private double fileSize;

    public Ebook(String title, String author, double fileSize) {
        super(title, author);
        this.fileSize = fileSize;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("파일 크기: " + fileSize + "MB");
    }

    double getFileSize() {
        return fileSize;
    }
}
public class E_OOP_Practice {
    public static void main(String[] args) {
        Book book1 = new Book("나혼자 레벨업", "성진우");
        book1.displayInfo();
        book1.borrowBook();
        book1.borrowBook();
        book1.returnBook();
        book1.displayInfo();

        System.out.println();

        Ebook ebook1 = new Ebook("Baby의 차트 정복", "Lee", 2134);
        ebook1.displayInfo();
        ebook1.borrowBook();
        ebook1.borrowBook();
        ebook1.returnBook();
    }
}
