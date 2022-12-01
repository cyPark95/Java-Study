package me.pcy.java8.functionalInterfaceAndLambda;

/**
 * 추상 메서드가 하나만 있으면 함수형 인터페이스다.
 * 추상 메서드를 제외한 메서드들은 있어도 상관없다.
 */
@FunctionalInterface
public interface FunctionalInf {

    // 인터페이스에선 abstract 생략 가능
    // java 8에선 public 키워드 생각 가능
    void doIt();

    // 인터페이스에서 static 메서드 정의 가능
    static void printName() {
        System.out.println("pcy");
    }

    // 인터페이스에서 default 메서드 정의 가능
    default void printAge() {
        System.out.println("28");
    }
}
