package me.pcy.java8.optional;

import java.util.Optional;
import java.util.OptionalInt;

public class App {

    public static void main(String[] args) {
        OnlineClass springBoot = new OnlineClass(1, "spring boot", true);
        Optional<Progress> progress = springBoot.getProgress();

        progress.ifPresent(p -> System.out.println(p.getStudyDuration()));

        // 프리미티브 타입에는 프리미티브 타입용 Optional을 사용해야 한다.
        // Optional을 사용하면 오토박싱이 발생한다.
        OptionalInt optionalInt = OptionalInt.of(10);
        System.out.println("optionalInt = " + optionalInt.getAsInt());
    }
}
