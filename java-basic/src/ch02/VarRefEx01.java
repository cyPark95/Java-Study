package ch02;

// new 가 돼어서 힘에 할당이 될 때, 사이즈를 알 수 있다. (프로그램이 실행 돼었을 때 Runtime)
class MyData{
    int id = 1;         // 4 Byte
    int price = 1000;   // 4 Byte
}

public class VarRefEx01 {
    public static void main(String[] args) {

        /*
        타입 변수;      int num;        변수를 선언한다.
        타입 변수 = 값;  int num = 10;   변수를 초기화(메모리에 할당) 한다.
         */

        // 일반 변수
        // boolean, char, byte, short, int, long, float, long
        int num = 10;               // 일반 변수(컴파일 시점에 크기가 정해져 있는 것!)
        // 컴파일 시점에 데이터의 크기를 알수 있기 때문에
        // 일반 변수는 값을 가지고 있다.

        // 레퍼런스(참조) 변수
        // Beans(커스텀 자료형)
        MyData d = new MyData();    // 레퍼런스 변수(컴파일 시점에 크기가 정해져 있지 않은 것!)
        // 컴파일 시점에 데이터의 크기를 알지 못하기 때문에
        // 레퍼런스 변수는 값의 주소(포인터)를 가지고 있다.
        // 레퍼런스 변수 -> 주소 -> 값

        System.out.println("num = " + num);

        System.out.println("id = " + d.id);
        System.out.println("price = " + d.price);
    }
}
