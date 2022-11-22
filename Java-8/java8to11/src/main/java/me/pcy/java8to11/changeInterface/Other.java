package me.pcy.java8to11.changeInterface;

public interface Other {

    default void printNameUpperCase() {
        System.out.println("OTHER");
    }
}
