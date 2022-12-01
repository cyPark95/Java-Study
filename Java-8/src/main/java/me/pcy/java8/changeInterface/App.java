package me.pcy.java8.changeInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class App {

    public static void main(String[] args) {
        NameInf name = new DefaultName("pcy");
        name.printName();
        name.printNameUpperCase();

        NameInf.printAnything();

        List<String> names = new ArrayList<>();
        names.add("name1");
        names.add("name2");
        names.add("name3");
        names.add("name4");
        names.add("name5");

        // Iterable 기본 메서드
        names.forEach(System.out::println);

        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> stringSpliterator = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("==========");
        while (stringSpliterator.tryAdvance(System.out::println));

        // Collection 기본 메서드
        long count = names.stream().map(n -> n.contains("1")).count();
        System.out.println("count = " + count);

        names.removeIf(s -> s.contains("3"));
        names.forEach(System.out::println);

        // Comparator 기본 메서드
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed().thenComparing(compareToIgnoreCase));
    }
}
