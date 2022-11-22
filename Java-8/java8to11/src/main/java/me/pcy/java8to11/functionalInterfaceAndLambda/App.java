package me.pcy.java8to11.functionalInterfaceAndLambda;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * 메서드 레퍼런스
 */
public class App {

    public static void main(String[] args) {
        // 스태틱 메서드 참조
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("pcy"));

        // 특정 객체의 인스턴스 메서드 참조
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("pcy"));

        // 생성자 참조
        Supplier<Greeting> newGreeting= Greeting::new;
        Greeting instance = newGreeting.get();

        Function<String, Greeting> pcyGreeting = Greeting::new;
        Greeting pcyInstance = pcyGreeting.apply("pcy");

        // 임의 객체의 인스턴스 메서드 참조
        String[] names = {"pcy1", "pcy2", "pcy3"};
        Arrays.sort(names, String::compareToIgnoreCase);
    }
}
