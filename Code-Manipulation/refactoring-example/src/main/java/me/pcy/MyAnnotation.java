package me.pcy;

import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 기본적으로 어노테이션은 주석과 비슷하다.
 * 바이트코드 로딩 시, 해당 정보는 메모리에 남지 않는다.
 */
@Retention(value = RUNTIME)  // 어노테이션을 런타임시에 조회하려면 @Retention을 사용
@Target({ElementType.TYPE, ElementType.FIELD})  // 어노테이션 사용을 @Target을 통해 제한
@Inherited  // 상속이 가능한 어노테이션 설정
public @interface MyAnnotation {

    String value();

    String name() default "pcy";

    int number() default 100;
}
