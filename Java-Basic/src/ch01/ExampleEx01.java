package ch01;

/*
붕어빵 커스텀 자료형 (heap)을 만드시오
    - 클래스 명 : 붕어빵
    -     필드 : 가격  - 1000
                맛   - 달콤함
                색깔  - 노란색
 */

class 붕어빵{
    int price = 1000;
    String taste = "달콤함";
    String color = "노란색";
}

public class ExampleEx01 {
    public static void main(String[] args) {
        붕어빵 붕어빵 = new 붕어빵();

        System.out.println("price = " + 붕어빵.price);
        System.out.println("taste = " + 붕어빵.taste);
        System.out.println("color = " + 붕어빵.color);
    }
}
