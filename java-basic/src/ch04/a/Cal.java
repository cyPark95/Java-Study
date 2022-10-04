package ch04.a;

public class Cal {

    // 디폴트 접근 제어자   => 동일한 패키지에서만 접근 가능
    int num = 10;

    void add(){
        System.out.println("더하기 메서드");
    }

    // Public 접근 제어자  => 다른 패키지에서도 접근 가능
    public void minus(){
        System.out.println("빼기 메서드");
    }

    // Private 접근 제어자 => 동일한 클래스에서만 접근 가능
    private void multi(){
        System.out.println("곱하기 메서드");
    }

    public void divide(){
        System.out.println("나누기 메서드");
        multi();
    }
}
