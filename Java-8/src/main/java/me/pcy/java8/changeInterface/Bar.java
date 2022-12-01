package me.pcy.java8.changeInterface;

public interface Bar extends NameInf {

    // 인터페이스를 상속받는 인터페이스에서 추상화 메서드로 변경할 수 있다.
    void printNameUpperCase();
}
