package org.example.chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
=== 배열 vs 리스트 ===
    +) 공통점: 순서o(인덱스 기반, 0부터 시작), 인덱스 번호로 접근 가능

    1. Array(배열)
        : 정적 자료구조
        : 크기 고정 - 생성 시 지정한 크기 변경 불가
        : 연속된 메모리 공간에 저장
        : 데이터가 동일한 타입이어야 함 (명시적)

        +) 원소 추가, 삭제 - 직접 구현

    2. List(리스트)
        : 동적 자료구조
        : 크기 가변
        : 메모리 공간이 불연속적
        : 다양한 구현체 존재
            - ArrayList, LinkedList

    +) List<> 컬렉션 프레임워크는 불변 리스트, 가변 리스트 할당 가능
 */
public class D_Array_List {
    public static void main(String[] args) {
        /* List 생성 방법
         1) new ArrayList<>();
              - 가변 o (길이 변경, 수정 가능)
              - 가장 일반적인 생성자 사용 리스트 생성 방식
         2) Arrays.asList();
              - 가변 x (길이 고정, 수정 가능)
              - 가짜 ArrayList: Arrays 클래스 내부에서 구현된 별개의 ArrayList (컬렉션 프레임워크 x) ..인 척하는 녀석
              - 배열을 리스트로 변환
         3) List.of();
              - 불변 o (길이 고정, 수정 불가)
              - 읽기 전용 리스트 생성
              - null 값을 포함할 수 x
         4) Stream.of().collect(Collectors.toList());
              - 가변 o (1번과 동일 형태)
         5) List.copyOf();
              - 불변 o (길이 고정, 수정 불가)
              - 기존 리스트의 불변 복사본 생성
         */

        List<String> list = new ArrayList<>();
        List<String> asList = Arrays.asList("A", "B", "C");
        List<String> listOf = List.of("A", "B", "C");
        List<String> collect = Stream.of("A", "B", "C").collect(Collectors.toList());
        List<String> copy = List.copyOf(list);
    }
}
