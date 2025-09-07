package study.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapMain1 {
    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<>();

        // 학생 성적 데이터 추가
        studentMap.put("studentA", 90);
        studentMap.put("studentB", 80);
        studentMap.put("studentC", 80);
        studentMap.put("studentD", 100);

        System.out.println("studentMap = " + studentMap);
        
        // 특정 학생의 값 조회
        // .get(key 이름) -> 키의 값 반환
        Integer studentC = studentMap.get("studentC");
        System.out.println("studentC = " + studentC);

        System.out.println();
        System.out.println("keySet 활용");

        Set<String> keyset = studentMap.keySet();
        for (String key : keyset) {
            Integer value = studentMap.get(key);
            System.out.println(key + " " + value);
        }
        System.out.println();

        // Set 중복 x, 순서x

        System.out.println("entrySet 활용");
        Set<Map.Entry<String, Integer>> entries = studentMap.entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key + " " + value);

        }

    }
}
