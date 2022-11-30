package me.pcy.java8to11.annotation;

import java.util.Arrays;

@Chicken("양념")
@Chicken("간장")
public class AnnotationEx {

    public static void main(String[] args) {
        // 어노테이션으로 조회
        Chicken[] chickens = AnnotationEx.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(System.out::println);

        // 어노테이션 컨테이너로 조회
        ChickenContainer chickenContainer = AnnotationEx.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(System.out::println);
    }

    // ElementType.TYPE_PARAMETER 제네릭 타입에만 사용
    // ElementType.TYPE_USE 타입을 선언한 모든곳에 사용
    static class FellsLikeChicken<@Chicken("제네릭") T> {

        public static <C> void print(@Chicken("타입") C c) {
            System.out.println(c);
        }
    }

}
