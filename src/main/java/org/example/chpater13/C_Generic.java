package org.example.chpater13;

/*
    1) 제네릭 사용 목적
        : 여러 타입을 하나의 코드로 처리하여 중복을 줄이고
            , 타입 안정성을 확보

    2) 와일드카드 ? 사용 시점
        : 타입을 알 수 없거나 관계없이 처리할 때 사용

    3) extends VS super 차이점
        : extends(상속 받는 타입만 허용 - 읽기 전용)
        : super(조상 타입만 허용 - 쓰기 가능)

    4) list.add(값)이 안되는 이유
        : 와일드카드는 타입이 불확실해서 안정성 문제로 컴파일이 값의 할당을 막음.
 */

// == 주문 관리 시스템 == //
// 상품(Product)과 할인(Discount) 정보를 관리
// : 할인 정책 사용 시, Product 또는 Product를 상속받는 하위 클래스에서(Electronics / Furniture)만 적용

import java.util.ArrayList;
import java.util.List;

// 1. 상위 클래스
class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
}

// 2. 하위 클래스(Electronics / Furniture)
class Electronics extends Product {

    // 추상메서드 오버라이딩은 아니지만
    // 자식 클래스는 부모클래스가 있어야 되니까 생성자 호출 해줘야 함.
    // super(); 빈 생성자는 자동 호출 되지만, 매개변수 있으면 직접 호출해야함.

    // 지역변수 초기화 해줘야함.
    public Electronics(String name, int price) {
        super(name, price);
    }
}

class Furniture extends Product {

    public Furniture(String name, int price) {
        super(name, price);
    }
}

class DiscountPolicy {
    // List<Product> products 라고 하면...
    public static double applyDiscount(List<? extends Product> products, double discountRate) {
        // 리스트 컬렉션 프레임워크 형식에 Product 타입을 가지거나
        //      , 해당 타입의 하위 클래스(전자, 가구)만을 허용

        double totalDiscount = 0.0;

        for (Product product : products) {
            double discount = product.getPrice() * discountRate;
            totalDiscount += discount;
            System.out.println(product.getName() + " 할인 적용: " + discount + "원");
        }
        return totalDiscount;
    }
}
public class C_Generic {
    public static void main(String[] args) {
        List<Electronics> electronics = new ArrayList<>();
        electronics.add(new Electronics("냉장고", 108));
        electronics.add(new Electronics("세탁기", 130));
        electronics.add(new Electronics("인덕션", 80));

        // cf) 공변성
        //      : 프로그램의 타입 시스템 중 하나
        //      - 제네릭 타입에서 상위 타입 관계가 유지되는 것
        //      >> Electronics가 Product의 하위 클래스!
        //      >> 리스트 사이에 상속 관계는 없다!
        double totalElectronics = DiscountPolicy.applyDiscount(electronics, 0.1);
        System.out.println("총 가전 할인액: " + totalElectronics);

        System.out.println();

        List<Furniture> furnitures = new ArrayList<>();
        furnitures.add(new Furniture("침대", 230));
        furnitures.add(new Furniture("쇼파", 170));
        furnitures.add(new Furniture("화장대", 250));

        double totalFurniture = DiscountPolicy.applyDiscount(furnitures, 0.3);
        System.out.println("총 가구 할인액: " + totalFurniture + "원");

    }
}
