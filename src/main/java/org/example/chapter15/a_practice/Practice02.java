package org.example.chapter15.a_practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Practice02 {
    public static void main(String[] args) {
        List<String> fileNames = Arrays.asList(
                "a.pdf", "b.png", "c.mp4"
                , "g.ppt", "h.js", "i.jpg"
                , "d.ppt", "e.png", "f.jpg"
        );

        // 프로그램이 돌아가는것만 생각하기보다는 "효율적인 코드"로
        // 1. 특정 확장자 필터링
        // : 이미지 파일만 추출(.png, .jpg)
        // cf) startsWith, endsWith(""): 특정 문자열로 시작, 끝나는 데이터에 대해 true 반환
        List<String> filteredFiles = fileNames.stream()
                .filter(name -> name.endsWith(".png") || name.endsWith(".jpg"))
                .sorted()
                .collect(Collectors.toList());
        System.out.println(filteredFiles);

        // 2. 파일 이름을 알파벳 순으로 정렬
        List<String> sortedFiles = fileNames.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedFiles);
    }
}
