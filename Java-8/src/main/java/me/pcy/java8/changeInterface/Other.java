package me.pcy.java8.changeInterface;

public interface Other {

    default void printNameUpperCase() {
        System.out.println("OTHER");
    }
}
