package me.pcy.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream: 연속된 데이터를 처리하는 오퍼레이션들의 모음
 *         (데이터를 담는 저장소가 아니다.)
 */
public class App {

    public static void main(String[] args) {
        List<String> names =  new ArrayList<>();
        names.add("pcy1");
        names.add("pcy2");
        names.add("pcy3");
        names.add("pcy4");
        names.add("pcy5");

        // 스트림이 처리하는 데이터 소스를 변경하지 않는다.(Functional in nature)
        Stream<String> stringStream = names.stream().map(String::toUpperCase);
        names.forEach(System.out::println);

        // stream 오퍼레이션은 중개 오퍼레이션과 터미널 오퍼레이션이 있다.
        // 종료 오퍼레이션 오직 한개만 사용할 수 있다.
        // 중개 오퍼레이션은 근본적으로 lazy 하다.
        List<String> list = names.stream().map(s -> {
                    System.out.println(s);  // 터미널 오퍼레이션이 없으면 출력되지 않는다.
                    return s.toUpperCase();
                })  // 중개 오퍼레이터 -> Stream 반환 -> 터미널 오퍼레이션이 오기 전까지 실행하지 않는다.
                .collect(Collectors.toList());

        // JVM이 자동으로 병렬적으로 처리된다.
        // (병렬처리라고 모두 빠르지 않다.)
        List<String> collect = names.parallelStream()
                .map(s -> {
                    System.out.println(s + " " + Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
