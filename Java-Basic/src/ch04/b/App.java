package ch04.b;

import ch04.a.Cal;

// main 이 있는 자바 파일을 실행파일
public class App {

    // JVM 이 main 메스드를 찾으려면 public 이 필요(공개)
    // JVM 이 main 메서드를 찾으려면 static 이 필요(메모리에 올린다는 뜻)
    // main 메서드만 return 타입을 허용하지 않는다.
    // main             => 메서드의 이름
    // String[] args    => 매개변수
    public static void main(String[] args) {
        Cal c = new Cal();
//        c.add();
        c.minus();
//        System.out.println(c.num);
    }
}
