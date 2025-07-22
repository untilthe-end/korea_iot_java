package org.example.chapter14;

/*
    Stream API
    - 컬렉션 or 배열에 저장된 데이터를 간결하게 처리
    - 데이터 필터링, 매핑, 변환, 집계...etc
    - for 대신에 다른거 씀

    1. 소스
        - 스트림의 시작점 (생성 단계)
        - 컬렉션, 배열 or 파일을 소스로 사용
        ex) list.stream(), Arrays.stream()

    2. 중간 연산 (데이터 가공)
        - 스트림으로 결과가 반환되어 메서드 체이닝 가능
        - 지연 처리: 최종 연산이 실행되기 전에는 동작하지 않음

        - filter(): 조건에 맞는 요소만 남김
        - map(): 요소를 반환
        - sorted(): 정렬
        - distinct(): 중복 제거
        - limit() / skip(): max 개수 제한 / 건너뛰기

    3. 최종 연산 (결과 반환)
        - 스트림 소모후 결과 반환 or 출력
        - 스트림 재사용 불가!

        ex)
        - collect(): List, Map 등으로 모으기
        - forEach(): 각 요소 처리
        - count(): 개수 세기

    Stream API 특징
    1) 불변성: 원본 데이터를 변경하지 않음, 새로운 값 반환
    2) 지연 처리: 중간 연산은 실제로 실행되지 않음, 최종 연산 시 처리됨
    3) 일회성: 스트림은 한 번만 사용 가능 (재사용 시 예외 발생)
    4) 선언형: 간결한 문법 사용 가능(람다식)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HH_Stream {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();

        fruits.add("사과");
        fruits.add("키위");
        fruits.add("파인애플");
        fruits.add("오렌지");
        fruits.add("키위");
        fruits.add("망고");

        System.out.println(fruits);

        // 1. 데이터 소스 (Stream 생성)
        Stream<String> streamFruits = fruits.stream();

        // cf) 문자열.startsWith("문자열"): 해당 문자열로 시작 여부를 반환 (boolean)
        // cf) 문자열.contains("문자열"): 해당 문자열 포함 여부를 반환 (boolean)
        System.out.println("== 1. \"키\"으로 시작하는 과일의 이름에 \"맛있어\"을 붙여서 출력 ==");
        streamFruits
                .filter(fruit -> fruit.startsWith("키"))
                .map(fruit -> fruit + "는 맛있어!")
                .forEach(System.out::println); // 최종 연산
        System.out.println();

        System.out.println("== 2. 문자열 길이가 3글자인 과일만 출력 ==");
        fruits.stream()
                .filter(fruit -> fruit.length() == 2)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("== 3. 중복 제거 후 오름차순 정렬하여 출력 ==");
        fruits.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("== 4. 과일 중 1번째 이후 과일 3개만 출력 ==");
        fruits.stream()
                .skip(1)
                .limit(3)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("== 5. 이름 길이의 합 구하기 ==");
        int totalLength = fruits.stream()
                //.map(fruit -> fruit.length())
                .map(String::length)
                .reduce(0, Integer::sum);
        System.out.println(totalLength);
        System.out.println();

        System.out.println("== 6. 총 과일 개수 출력 ==");
        long count = fruits.stream().count();
        System.out.println("총 과일 수: "+ count);
        System.out.println();

        System.out.println("== 7. 모든 이름을 하나의 문자열로 합치기 (comma 구분) ==");
        String result = fruits.stream() // stream() 반환 타입은 팔색조다?
                .distinct()
                .collect(Collectors.joining(" | "));
        System.out.println(result);
        System.out.println();

        System.out.println("== 8. 이름을 길이로 그룹화 ==");
        Map<Integer, List<String>> grouped = fruits.stream()
                .collect(Collectors.groupingBy(String::length));

        grouped.forEach((length, group) -> {
            System.out.println(length + "글자: " + group);
        });
        System.out.println();

        System.out.println("== 9. 이름 길이 기준 내림차순 정렬 ==");
        fruits.stream()
                .sorted((a, b) -> b.length() - a.length())
                .distinct()
                //.collect(Collectors.joining(" | "));
                .forEach(System.out::println);
        // 최종 연산은 forEach / collect / reduce / count 중에 하나만 ! 가능
        System.out.println();

    }
}
