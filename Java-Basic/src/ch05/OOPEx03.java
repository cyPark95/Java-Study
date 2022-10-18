package ch05;

// 요리사
class 요리사{
    private String name;

    public 요리사() {
        this.name = "요리사";
    }

    public String getName() {
        return name;
    }
}

// 홍길동 or 요리사
class 홍길동 extends 요리사 {
    private String name;

    public 홍길동() {
        this.name = "홍길동";
    }

    public String getName() {
        return name;
    }
}

public class OOPEx03 {

    public static void main(String[] args) {
        홍길동 h1 = new 홍길동();  // 메모리에 홍길동과 요리사가 동시에 할당 된다.
        System.out.println(h1.getName());

        요리사 y1 = new 홍길동();
        System.out.println(y1.getName());

//        홍길동 h2 = new 요리사();  // 메모리에 요리사만 할당되었기 때문에 불가능!!
    }
}
