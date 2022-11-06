package me.pcy.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 런타임 시에 참조할 어노테이션은 아래 설정을 반드시 해줘야 한다.
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {

}
