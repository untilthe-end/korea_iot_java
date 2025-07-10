package org.example.chapter07.orderApp;

//   주문 시스템의 실행 진입점
// - 제품 생성, 주문 생성, 주문 결과를 출력
public class MainApp {
    public static void main(String[] args) {
        // 제품 생성
        Product laptop = new Electronics("LG Gram", 14000);
        Product apple = new Food("Apple", 4000);

        // 주문 생성
        Order order1 = new Order(laptop, 1);
        Order order2 = new Order(apple, 10);

        System.out.println(order1);
        System.out.println(order2);
    }
}
