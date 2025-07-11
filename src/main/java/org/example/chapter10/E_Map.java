package org.example.chapter10;

// == Map 인터페이스 == //
    // : 키(key)와 값(value)의 쌍으로 요소를 저장하는 데이터 구조
    // - 키는 고유한 데이터를 가짐 (중복 키 허용 x)
    // - 동일한 키에 서로 다른 값 전달 시 기존 값이 새로운 값으로 덮어씌워짐
    // ex) name: "이승아", name: "이도경" (불가! - name: "이도경" 만 존재)

    // cf) 서로 다른 키에 동일한 값은 가능
    // ex) name: "개구리", nickname: "개구리"

    // +) 키의 유일성, 값의 중복성 보장
    //      >> 순서 보장 x (예외 o)
    // - 키를 기반으로 빠른 검색 가능

// == Map 인터페이스 종류 (구현체) == //
    // 1. HashMap
    //      : 가장 많이 사용, 키와 값에 null 허용
    //      - 빠른 검색, 삽입 성능 제공
    //      - 순서 유지 x

    // 2. LinkedHashMap
    //      : HashMap + 삽입 순서 유지 o
    //      - 삽입 순서가 중요하고 빠른 검색이 필요할 때 사용

    // 3. TreeMap
    //      : 키에 따라 자동 정렬 기능 보장
    //      - 키에 null 허용 x

import java.util.*;

public class E_Map {
    public static void main(String[] args) {
        // == Map 인터페이스 메서드 == //
        // Map<키 타입, 값 타입> 인스턴스명 = new Map종류<>();

        Map<String, Integer> studentAges = new HashMap<>();

        // 1. put(키, 값): 키와 값을 Map 추가
        studentAges.put("Lee", 20);
        studentAges.put("Park", 25);
        studentAges.put("Kim", 30);

        System.out.println(studentAges);
        // {Lee=20, Kim=30, Park=25}
        // 중괄호 내에 키=값의 쌍이 콤마로 구분되어 나열
        // >> 삽입 순서 보장 x

        System.out.println(studentAges.get("Park")); // 지정된 키값 반환: 25

        // 지정된 키의 값을 삭제 후 반환
        studentAges.remove("Kim");
        System.out.println(studentAges); // {Lee=20, Park=25}

        System.out.println(studentAges.containsKey("이승아")); // false
        System.out.println(studentAges.containsValue(33)); // false

        System.out.println(studentAges.containsKey("Lee")); // true
        System.out.println(studentAges.containsValue(30)); // false

        System.out.println(studentAges.size()); // 2

        // keySet(): Map의 키들을 Set으로 반환
        System.out.println(studentAges.keySet()); // [Lee, Park]

        // values(): Map의 값들을 컬렉션 타입으로 반환
        Collection<Integer> listAges = studentAges.values();
        System.out.println(listAges); // [20, 25]

        // cf) Collection 타입은 하위 인터페이스로 변환 가능
        List<Integer> changeList = new ArrayList<>(listAges);
        System.out.println(changeList); // [20, 25]

        // entrySet(): Map의 키와 값을 Set으로 변환
        System.out.println(studentAges.entrySet()); // [Lee=20, Park=25]

    }
}
