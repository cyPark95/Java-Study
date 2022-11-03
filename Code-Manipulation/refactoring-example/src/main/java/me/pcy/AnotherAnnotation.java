package me.pcy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 기본적으로 어노테이션은 주석과 비슷하다.
 * 바이트코드 로딩 시, 해당 정보는 메모리에 남지 않는다.
 */
@Retention(value = RUNTIME)
@Inherited
public @interface AnotherAnnotation {

    String value() default "value";

    String name() default "pcy";

    int number() default 100;
}
