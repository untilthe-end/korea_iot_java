package org.example.chapter10.practice01;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// 도서 관리 기능을 수행 (관리할 행동을 실질적 구현)
public class LibraryManager implements Manageable {
    // 책 저장 공간 (ArrayList - 중복 o, 순서 o / 조회 빠른 기능)
    private List<Item> items = new ArrayList<>();

    @Override
    public void add(Item item) {
        items.add(item);
        System.out.println("Item is added: " + item.getName());
    }

    @Override
    public void listAll() {
        if (items.isEmpty()) {
            System.out.println("No items are in the library");
        } else {
            System.out.println("== Library Items ==");
            for (Item item : items) {
                item.display();
            }
        }
    }

    @Override
    public void updateStock(String id, int quantity) {
        for (Item item : items) {
            // item.updateStock(quantity); 업캐스팅 되서 못씀
            if (item.getId().equals(id) && item instanceof Book) {
                // Book selectedBook = (Book)item;
                ((Book) item).updateStock(quantity);
                // selectedBook.updateStock(quantity);
                System.out.println("Stock updated for ID: " + id + ", Stock: " + ((Book) item).getStock());
                // System.out.println("Stock updated for ID: "+ id + ", Stock: "+ selectedBook.getStock());
            }
        }
    }

    @Override
    public void remove(String id) {
        // 삭제 여부 확인용 boolean 데이터
        boolean removed = false;

        // 인덱스 번호를 사용하여 요소 제거
        // : 일반 for문 초기화 변수 == 인덱스 번호

        int size = items.size();

        for (int i = 0; i < size; i++) {
            // 전체 items를 순회: 각 순번의 item의 id와 매개변수의 id가 일치한다면 해당 인덱스 요고 제거
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                removed = true;
                System.out.println("Item with ID: " + id + " removed");
                break;
            }
        }

        if (!removed) {
            // 제거된 요소가 없다면
            System.out.println("No item is found with ID: " + id);

        }
    }

    @Override
    public List<Item> search(String keyword) {
        // 전체 리스트의 요소에서 키워드 검색
        // : name(책 이름), author(저자명), publisher(출판사) 통합 검색
        List<Item> foundItems = new ArrayList<>(); // 검색된 도서 정보들이 저장될 리스트 (필터링)
        for (Item item : items) {
            if (item.getName().contains(keyword)
                    || (item instanceof Book && ((Book) item).getAuthor().contains(keyword)
                    || ((Book) item).getPublisher().contains(keyword))
            ) {
                foundItems.add(item);
            }

            if (foundItems.isEmpty()) {
                throw new NoSuchElementException("No item found for keyword: " + keyword);
            }

        }
        return foundItems;
    }

    @Override
    public List<Item> searchByCategory(String category) {
        List<Item> result = new ArrayList<>();

        for (Item item : items) {
            if (item instanceof Book && ((Book) item).getCategory().equalsIgnoreCase(category)) {
                // equalsIgnoreCase
                // : 대소문자를 구분하지 않고 데이터의 값을 비교
                // - 영어만 사용 가능
                result.add(item);
            }
        }
        if (result.isEmpty()) {
            throw new NoSuchElementException("No item found for this category: " + category);
        }
        return result;
    }

    @Override
    public List<Item> searchByPriceRange(int minPrice, int maxPrice) {
        List<Item> result = new ArrayList<>();

        for (Item item : items) {
            if (item instanceof Book) {
                int price = ((Book) item).getPrice();

                if (price >= minPrice && price <= maxPrice) {
                    result.add(item);
                }
            }
        }
        if (result.isEmpty()) {
            throw new NoSuchElementException("No item found for range: " + minPrice + "~" + maxPrice);
        }
        return result;
    }
}
