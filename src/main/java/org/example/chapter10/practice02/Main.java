package org.example.chapter10.practice02;

import org.example.chapter10.practice02.entity.Electronics;
import org.example.chapter10.practice02.entity.Furniture;
import org.example.chapter10.practice02.entity.Item;
import org.example.chapter10.practice02.repository.InMemoryItemRepository;
import org.example.chapter10.practice02.service.InventoryService;
import org.example.chapter10.practice02.service.InventoryServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
   == Inventory Management System ==
   : 다양한 상품을 관리하는 재고 관리 시스템

   1) 프로젝트 구조
   - Main 파일: 프로그램 실행의 진입점

   - entity 패키지(데이터 모델 정의)
    : 데이터(상품)을 표현하는 클래스 정의 - 객체의 속성과 동작을 정의

   - service 패키지(비즈니스 로직 처리)
    : 상품 추가, 조회, 수정, 삭제와 같은 비즈니스 로직을 처리 (직접적인 데이터 조작)

   - repository 패키지 (데이터 저장소 역할)
    : 데이터를 저장하고 검색하는 기능을 제공하는 클래스

    2) 요구사항
    - 기능
        : 상품(Item) 추가, 수정, 삭제, 카테고리 상품 검색, 가격 or 이름 등으로 정렬

    - 사용 컬렉션 프레임워크
        Set: 상품 관리(중복 상품 관리)
        Map: 카테고리별 상품 분류(Key: 카테고리명, Value: 상품 목록)

    - 추상 클래스 (Item: 모든 상품의 공통 필드 포함)
    - 인터페이스 (Discountable: 할인 로직 제공)
 */
public class Main {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryServiceImpl(new InMemoryItemRepository());
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("");
            System.out.println("=== Inventory Management System === ");
            System.out.println("1. 제품 추가");
            System.out.println("2. 제품 전체 조회");
            System.out.println("3. 제품 수정 (가격)");
            System.out.println("4. 제품 삭제");
            System.out.println("5. 제품 검색 (카테고리)");
            System.out.println("0. 프로그램 종료");
            System.out.print("메뉴 선택 >>");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addItem(inventoryService, sc);
                        break;
                    case 2:
                        viewAllItems(inventoryService, sc);
                        break;
                    case 3:
                        updateItemPrice(inventoryService, sc);
                        break;
                    case 4:
                        deleteItem(inventoryService, sc);
                        break;
                    case 5:
                        viewItemsByCategory(inventoryService, sc);
                        break;
                    case 0:
                        System.out.println("=== 종료합니다 ===");
                        sc.close();
                        return;
                    default:
                        System.out.println("유효하지 않은 선택입니다. 다시 시도해주세요 :)");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addItem(InventoryService service, Scanner sc) {
        System.out.print("Enter Item Id: ");
        String id = sc.nextLine();
        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Item Price: ");
        int price = sc.nextInt();
        System.out.print("Enter Item Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine(); // 버퍼 소비
        System.out.print("Enter Item (Electronics / Furniture): ");
        String category = sc.nextLine();

        if (category.equalsIgnoreCase("Electronics")) {
            System.out.print("Enter Brand: ");
            String brand = sc.nextLine();
            System.out.print("Enter Warranty (months): ");
            int warranty = sc.nextInt();
            sc.nextLine();
            Item electronics = new Electronics(id, name, price, quantity, brand, warranty); // 업캐스팅
            service.addItem(electronics);
        } else if (category.equalsIgnoreCase("Furniture")) {
            System.out.print("Enter material: ");
            String material = sc.nextLine();
            System.out.print("Enter size: ");
            String size = sc.nextLine();
            Item furniture = new Furniture(id, name, price, quantity, material, size);
            service.addItem(furniture);

        } else {
            System.out.println("Invalid category, Item not added");
        }
    }

    private static void updateItemPrice(InventoryService service, Scanner sc) {
        System.out.print("가격을 수정할 아이템 ID를 입력해주세요. ");
        String id = sc.nextLine();
        System.out.print("새 가격을 입력해주세요. ");
        int newPrice = sc.nextInt();
        sc.nextLine();
        boolean result = service.updateItemPrice(id, newPrice);
        System.out.println("제품 가격이 성공적으로 수정되었습니다.");
    }

    private static void deleteItem(InventoryService service, Scanner sc) {
        System.out.print("삭제할 아이템의 ID를 입력해주세요.");
        String id = sc.nextLine();
        service.deleteItem(id);
        System.out.println("제품이 성공적으로 삭제되었습니다.");
    }

    private static void viewAllItems(InventoryService service, Scanner sc) {
        // 컬렉션타입데이터A.addAll(컬렉션타입데이터B)
        // : A의 구조에 B의 모든 데이터를 각각 요소로 삽입

        // a = [1,2,3]
        // b = [4,5,6]

        // a.add(b): [1,2,3,[4,5,6]]
        // a.addAll(b): [1,2,3,4,5,6]

        List<Item> allItems = new ArrayList<>(service.getItemsByCategory("Electronics"));

        allItems.addAll(service.getItemsByCategory("Furniture"));

        if (allItems.isEmpty()) {
            System.out.println("제품이 없습니다.");
        } else {
            System.out.println("=== 모든 제품 목록 ===");
            for (Item item : allItems) {
                System.out.println(item             );
            }
        }
    }

    private static void viewItemsByCategory(InventoryService service, Scanner sc) {
        System.out.print("조회할 카테고리 입력: ");
        String category = sc.nextLine();

        List<Item> items = service.getItemsByCategory(category);

        if (items.isEmpty()) {
            System.out.println("해당 카테고리의 제품이 없습니다.");
        } else {
            System.out.println(category + " 카테고리의 제품 목록");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }
}
