package me.pcy.java8.changeInterface;

public interface NameInf {

    void printName();

    /**
     * @implSpec
     * 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    String getName();

    // Object가 제공하는 기능은 기본 메서드로 사용할 수 없다.
    // 추상화 메서드로 선언은 가능하다.
//    default String toString() {}

    static void printAnything() {
        System.out.println("Name Interface");
    }
}
