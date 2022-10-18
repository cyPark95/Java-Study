package ch03;

public class CastEx01 {

    public static void main(String[] args) {

        // 캐스팅(다운 캐스팅, 업 캐스팅)

        int n1 = 100;           // 4Byte
        double d1 = n1;         // 8Byte (8Byte <= 4Byte)
        System.out.println(d1); // 업 캐스팅(묵시적)

        double d2 = 100.8;
        // 명시적 형 변환 (int) => 다운 캐스팅
        int n2 = (int) d2;       // double 을 int 로 변환할 수 없다.
        System.out.println(n2);  // 단점 : 데이터가 유실될 수 있다.

        int money = 130;
        System.out.println(money / 100);
        System.out.println(money / 100.0);  // int / double => double
    }
}
