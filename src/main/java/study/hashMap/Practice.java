package study.hashMap;

import java.util.*;

public class Practice {
    public static void main(String[] args) {
        Map<String, Integer> studentAges = new HashMap<>();

        // HashMap //
        //  : 키의 유일성, 값의 중복성 보장 (순서 보장x)
        //  : 키를 기반으로 빠른 검색 가능
        studentAges.put("성진우", 23);
        studentAges.put("이나영", 42);
        studentAges.put("이시내", 12);
        studentAges.put("윤여준", 9);


        System.out.println(studentAges);

        System.out.println(studentAges.get("이나영"));

        System.out.println(studentAges.remove("이나영"));
        System.out.println(studentAges);

        System.out.println(studentAges.containsValue(9));
        System.out.println(studentAges.containsKey("성진우"));

        System.out.println(studentAges.size());

        System.out.println(studentAges.keySet());
        System.out.println(studentAges.values());

        Collection<Integer> listAges = studentAges.values();

//     List<Integer> changeList = new ArrayList<>(studentAges);

        System.out.println(studentAges.entrySet());
    }
}
