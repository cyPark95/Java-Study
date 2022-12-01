package me.pcy.java8.functionalInterfaceAndLambda;

/*
메서드 레퍼런스: 람다를 구현할 때 사용할 수 있는 방법
               기존에는 인라인으로 직접 구현했다.
               하지만 이미 만들어진 메소드가 있다면 간결하게 표현할 수 있다.
 */
public class Greeting {

    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String hi(String name) {
        return "hi " + name;
    }
}
