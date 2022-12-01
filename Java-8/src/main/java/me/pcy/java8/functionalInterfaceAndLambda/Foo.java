package me.pcy.java8.functionalInterfaceAndLambda;

import java.util.function.*;

/**
 *함수형 인터페이스와 람다
 */
public class Foo {

    public static void main(String[] args) {
        // 익명 내부 클래스 anonymous inner class
//        FunctionalInf functionalInf = new FunctionalInf() {
//            @Override
//            public void doIt() {
//                System.out.println("Hello");
//            }
//        };

        // 람다 표현식
        // 함수형 인터페이스를 람다 형태의 표현으로 코드를 줄일 수 있다.
        // 자바에서는 함수가 특수한 형태의 Object이기 때문에, 함수를 class Object로 사용할 수 있다.
        FunctionalInf functionalInf = () -> System.out.println("Hello");
        functionalInf.doIt();

        int baseNumber = 10;

        PureFunctionInf pureFunctionInf = number -> number + baseNumber;

//        Plus10 plus10 = new Plus10();
//        System.out.println(plus10.apply(100));

        Function<Integer, Integer> plus10 = (i) -> i + 10;
        System.out.println(plus10.apply(100));

        Function<Integer, Integer> multiply2 = (i) -> i * 10;
        System.out.println(multiply2.apply(10));

        // 고차함수의 형태
        // A.compose(B) -> B의 결과로 A 실행
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(2));

        // A.andThe(B) -> A의 실행 결과로 B 실행
        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);
        System.out.println(plus10AndMultiply2.apply(10));

        // 아무값도 리턴하지 않음
        Consumer<String> printString = (s) -> System.out.println("s = " + s);
        printString.accept("pcy");

        // T 타입의 값을 제공
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        // T 타입을 받아서 boolean을 리턴
        Predicate<String> startsWithPcy = (s) -> s.startsWith("pcy");
        System.out.println(startsWithPcy.test("pcyName"));

        // 입력 타입과 반환 타입이 같은 경우 + 입력값이 하나인 경우
        UnaryOperator<Integer> plus5 = (i) -> i + 5;
        System.out.println(plus5.apply(5));

        // 변수 캡처
        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
        // 이펙티브 final 변수
        // 암묵적인 final인 변수
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 20;  // 쉐도윙
                System.out.println(baseNumber);  // 20
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<>() {
            @Override
            public void accept(Integer integer) {
                int baseNumber = 30;  // 쉐도윙
                System.out.println(baseNumber);  // 30
            }
        };

        // 람다
        // run 메서드와 람다는 같은 스코프이다.
        // 따라서 쉐도윙이 일어나지 않는다.
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        // 변경되게 되면 이펙티브 final이 아니다.
        // 따라서 컴파일시에 에러가 발생
//        baseNumber++;

        printInt.accept(10);
    }
}


