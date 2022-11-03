package me.pcy;

// value를 사용할 경우 속성 이름을 생략할 수 있다.
// 여러 속성을 사용할 경우에는 생략할 수 없다.
@MyAnnotation("value")//(name = "pcy", number = 100)
public class Book {

    private static String B = "b";

    private static final String C = "c";

    @AnotherAnnotation
    private String a = "a";

    public String d = "d";

    protected String e = "d";

    public Book() {
    }

    public Book(String B) {
        this.B = B;
    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("f");
    }

    @AnotherAnnotation
    public void g() {
        System.out.println("g");
    }

    public int h() {
        return 100;
    }

    public int sum(int left, int right) {
        return left + right;
    }
}
