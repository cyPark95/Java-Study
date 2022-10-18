package ch04.a;

public class App {

    public static void main(String[] args) {
        Cal c = new Cal();
        c.add();
        c.minus();
//        c.multi();  // 찾을 수 없다. 같은 클래스가 아니기 때문에!!
        System.out.println(c.num);
    }
}
