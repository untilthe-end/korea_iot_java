package org.example.chapter01;

public class F_Conversion {
    // main method: 파일 단위의 실행을 담당하는 도구
    // ctrl + space
    public static void main(String[] args) {
        /*
                === 자바의 형 변환 (Type Conversion) ===
                : 하나의 타입을 다른 타입으로 바꾸는 것

                표현 가능한 범위 기준에 따른 변환 규칙
                : 메모리 크기와 순서가 다를 수 있음
                                                    // 실수가 더 크다.
                byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)

                char(2)
                boolean(1)
         */

        // 1. 자동(묵시적) 형 변환 - javac 컴파일러
        // : 작은 자료형을 큰 자료형으로 변환 (왼쪽에서 오른쪽)

        byte smallBox = 10; // 1byte
        int bigBox = 10000; // 4byte

        bigBox = smallBox; // 재할당 = 기존의 변수에 새로운 값을 할당(삽입)

        // cf) 변수는 재할당 시 기존의 값이 새로운 값으로 '변환'

        // sout + 자동완성
        System.out.println(bigBox);

        byte a = 32;
        short b = a;
        int c = b;
        long d = c;

        float e = d; // 4byte float에 8byte long 데이터 삽입가능

//        char f = e; 묵시적 형 변환 불가! (char는 2byte)

        int intNumber1 = 1234;
        float floatNumber = intNumber1;
        System.out.println("floatNumber = " + floatNumber);

        // 강제 형 변환
        // 작은타입 변수명 = (작은타입) 큰 데이터값;

        // 2. 강제(명시적) 형 변환
        // : 큰 자료형을 작은 자료형으로 변환 (오른쪽에서 왼쪽)
        int intNumber2 = (int)floatNumber;
        System.out.println("intNumber2 = " + intNumber2);

        long aa = 32L; // long 타입은 데이터 뒤에 알파벳 L, l 필수!
        int bb = (int) aa;
        short cc = (short) bb;
        byte dd = (byte) cc;

        System.out.println("bb = " + bb);

        // == 문자(char) 자료형의 형 변환 == //

        // cf) 유니코드(Unicode)
        // : 전 세계의 모든 문자를 하나의 숫자(코드 값)로 표현하는 국제 표준
        // - 유니코드 이전은 각 국가에서 나라별 문자 인코딩 방식 사용 (영어:아스키, 한국어: EUC-KR)
        // - 웹에서는 주로 UTF-8 이라는 유니코드 형식 사용
        // - 이모지까지 코드값으로 변환 가능 (window + .)
        // Ex) 문자마다 고유한 숫자(코드)가 정해져 있음: 'A' == 65
        
        // 1) char(문자)를 숫자로 변환
        // : 문자의 유니코드 값으로 변환
        char letter = 'A';
        int unicodeLetter = letter;
        System.out.println("unicodeLetter = " + unicodeLetter);

        char c1 = 'a'; // 문자 그대로
        char c2 = 97;  // 숫자로 넣기 (97은 'a'의 유니코드 값)
        char c3 = '\u0061'; // 유니코드 값을 16진수로 표현한 문자

        // 같은 문자 'a'를 다양한 방식으로 출력
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
        
        // 숫자(int)를 문자(char)로 변환
        int numberChar = 66;
        char letter66 = (char) numberChar; // 명시적, 강제 형 변환
        System.out.println("letter66 = " + letter66); // B

        // = char는 문자이지만, 내부적으로는 유니코드(숫자)로 처리
        // = 문자와 숫자 간의 변환은 형 변환 형식을 그대로 사용
    }
}
