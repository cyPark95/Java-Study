package me.pcy.java8to11.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Api {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        // Optional 값 있는지 확인하기
        boolean present = optional.isPresent();
        System.out.println("present = " + present);

        // Optional 값 가져오기
        // 비어있는 Optional의 경우 NoSuchElementException 발생
        if (optional.isPresent()) {
            OnlineClass onlineClass = optional.get();
            System.out.println("onlineClass = " + onlineClass.getTitle());
        }

        // Optional에 값이 있는 경우 메서드 실행
        optional.ifPresent(oc -> System.out.println("title = " + oc.getTitle()));

        // Optional에 값이 있으면 가져오고, 없는경우 인스턴스 리턴
        // Optional에 값이 있고 없고를 떠나 일단 createNewJpaClass()를 실행
        optional.orElse(createNewJpaClass());

        // Optional에 값이 있으면 가져오고, 없는경우 메서드 실행
        optional.orElseGet(Api::createNewJpaClass);

        // Optional에 값이 있으면 가져오고, 없으면 에러 발생
        // 기본적으로 NoSuchElementException 발생
        optional.orElseThrow(IllegalStateException::new);

        // Optional중에 들어있는 값 필터링
        optional.filter(OnlineClass::isClosed);

        // Optional에 들어있는 값 변환
        Optional<String> s = optional.map(oc -> oc.getTitle());

        // Optional에 들어있는 Optional인 경우에 사용
        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);
        // 아래 로직과 동일
//        Optional<Optional<Progress>> progress1 = optional.map(OnlineClass::getProgress);
//        Optional<Progress> progress2 = progress1.orElse(Optional.empty());
    }

    private static OnlineClass createNewJpaClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}
