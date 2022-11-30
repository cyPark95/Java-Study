package me.pcy.java8to11.annotation;

import java.lang.annotation.*;

// 어느 시점까지 어노테이션의 메모리를 가져갈 지 설정
@Retention(RetentionPolicy.RUNTIME)
// 어노테이션을 선언할 수 있는 타입을 설정
@Target(ElementType.TYPE_USE)
// 여러개의 어노테이션을 감싸고 있을 컨테이너 타입을 설정
@Repeatable(ChickenContainer.class)
public @interface Chicken {

    String value();
}
