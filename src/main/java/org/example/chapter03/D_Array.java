package org.example.chapter03;

import java.util.Arrays;

// Array: 같은 데이터 타입의 값들이 순차적으로 저장되는 자료 구조
    // cf) Arrays 클래스
    //      : 배열을 조작하는 데 유용한 기능들을 제공해주는 '자바 내부 클래스'
    //      : java.util 내에 존재
    //      >> 정렬, 검색, 변환 등
public class D_Array {
    public static void main(String[] args) {
        // == Arrays 클래스 사용 법 == //
        // : 자바의 Array(배열) 자료형에만 동작!
        //      >> 일반 배열만 사용!
        // cf) 동적 배열(ArrayList, List)는 사용 불가! - Collections class 사용

        int[] numbers = {3, 5, 1, 4, 2};

        // 1. 배열 정렬 (오름차순): Arrays.sort(정렬할 배열);
        Arrays.sort(numbers);
        System.out.println(numbers[0]); // 1

        // cf) .(마침표) 연산자: 해당 클래스 내부의 기능을 사용

        // 2. 배열 변환(배열 내용을 문자열로 출력): Arrays.toString(변환할 배열);
        System.out.println(numbers); // [I@28a418fc
        System.out.println(Arrays.toString(numbers)); //[1, 2, 3, 4, 5]

        // 3. 배열 검색: Arrays.binarySearch(배열, 검색 내용);
        // - 배열 내에 존재 o: 존재하는 요소의 인덱스 번호를 반환
        // - 배열 내에 존재 x: 해당 검색값의 음수를 반환 (음수 반환)
        System.out.println(Arrays.binarySearch(numbers, 2)); // 1
        System.out.println(Arrays.binarySearch(numbers, 6)); // -6

        // cf) binarySearch()는 반드시 정렬된 배열 내에서 검색!
        // : 해당 기능이 '이진 탐색 알고리즘'을 사용하기 때문 (1,2,3,4||,5,6,7,8) 반으로 쪼개서

        // 4. 배열 비교 : Arrays.equals(a배열, b배열);
        // >> 논리값으로 반환
        int[] numbers2 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.equals(numbers, numbers2)); // false

        // 5. 배열 채움 (모든 요소를 특정 값으로 초기화)
        // : Arrays.fill(배열, 삽입할 값);
        int[] examples = new int[3];
        System.out.println(Arrays.toString(examples));
        Arrays.fill(examples, 10);
        System.out.println(Arrays.toString(examples));

    }
}
