package me.pcy;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 클래스 타입을 가져오는 3가지 방법
        // 1. 타입을 가지고 가져오는 방법
        Class<Book> bookClass = Book.class;

        // 2. 인스턴스를 통해 가져오는 방법
        Book book = new Book();
        Class<? extends Book> bookClass2 = book.getClass();

        // 3. 풀패키지 경로 문자열을 통해 가져오는 방법(클래스 로딩 발생)
        // 클래스가 없으면 ClassNotFoundException 발생
        Class<?> bookClass3 = Class.forName("me.pcy.Book");

        reflection(bookClass);

        reflectionFields(bookClass, book);

        reflectionMethods(bookClass);

        reflectionAnnotations(bookClass);

        reflectionGetFiled(bookClass, bookClass3);

        reflectionMethodRunning(bookClass, bookClass3);
    }

    private static void reflectionGetFiled(Class<Book> bookClass, Class<?> bookClass3) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        // 인스턴스 생성
        Constructor<?> constructor = bookClass3.getConstructor(String.class);
        Book bookInstance = (Book) constructor.newInstance("myBook");

        Field b = bookClass.getDeclaredField("B");
        b.setAccessible(true);  // private도 가져올 수 있다.
        System.out.println(b.get(bookInstance));
        b.set(bookInstance, "ABC");
        System.out.println(b.get(bookInstance));
    }

    private static void reflectionMethodRunning(Class<Book> bookClass, Class<?> bookClass3) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        // 인스턴스 생성
        Constructor<?> constructor = bookClass3.getConstructor(String.class);
        Book bookInstance = (Book) constructor.newInstance("myBook");

        // private 메서드
        Method f = bookClass.getDeclaredMethod("f");
        f.setAccessible(true);
        f.invoke(bookInstance);

        // public 메서드
        Method sum = bookClass.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) sum.invoke(bookInstance, 1, 2);
        System.out.println(invoke);
    }

    private static void reflection(Class<Book> bookClass) {
        // 정의된 필드들을 가져오고 싶다.
        // getFields() 메소드는 public만 리턴한다.
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        // getDeclaredFields() 메소드는 모든 필드를 리턴한다.
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);

        // 정의된 메서드들을 가져오고 싶다.
        // getDeclaredMethods() 메소드는 모든 메서드를 리턴한다.
        Arrays.stream(bookClass.getDeclaredMethods()).forEach(System.out::println);

        // 정의된 생성자들을 가져오고 싶다.
        // getDeclaredConstructors() 메소드는 모든 생성자를 리턴한다.
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        // 정의된 상위클래스를 가져오고 싶다.
        // getSuperclass() 상위클래스를 리턴한다.
        System.out.println(bookClass.getSuperclass());

        // 인터페이스를 가져오고 싶다.
        // getInterfaces() 상위클래스를 리턴한다.
        Arrays.stream(bookClass.getInterfaces()).forEach(System.out::println);
    }

    private static void reflectionFields(Class<Book> bookClass, Book book) {
        // 모든 필드와 값까지 출력한다.
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);  // 접근이 불가능한 필드에도 접근할 수 있도록 설정
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        // 각 필드의 구성요소를 확인하고 싶다.
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println("Private: " + Modifier.isPrivate(modifiers));
            System.out.println("Static: " + Modifier.isStatic(modifiers));
        });
    }

    private static void reflectionMethods(Class<Book> bookClass) {
        // 각 메서드의 구성요소를 확인하고 싶다.
        Arrays.stream(bookClass.getDeclaredMethods()).forEach(m -> {
            int modifiers = m.getModifiers();
            System.out.println(m);
            System.out.println("Private: " + Modifier.isPrivate(modifiers));
            System.out.println("Static: " + Modifier.isStatic(modifiers));
        });

        // 각 메서드의 리턴타입을 확인하고 싶다.
        Arrays.stream(bookClass.getDeclaredMethods()).forEach(m -> {
            System.out.println(m.getReturnType());
        });

        // 각 메서드의 파라미터를 확인하고 싶다.
        Arrays.stream(bookClass.getDeclaredMethods()).forEach(m -> {
            Arrays.stream(m.getParameters()).forEach(System.out::println);
        });
    }

    private static void reflectionAnnotations(Class<Book> bookClass) {
        // Book 클래스의 모든 어노테이션을 확인하고 싶다.
        Arrays.stream(bookClass.getAnnotations()).forEach(System.out::println);

        // Book 클래스의 어노테이션만 확인하고 싶다.
        Arrays.stream(bookClass.getDeclaredAnnotations()).forEach(System.out::println);

        // 각 필드의 어노테이션을 확인하고 싶다.
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            Arrays.stream(f.getDeclaredAnnotations()).forEach(System.out::println);
        });

        // 특정 어노테이션이 붙어있는 필드를 찾고, 해당 어노테이션의 값을 확인할 수 있다.
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            Arrays.stream(f.getDeclaredAnnotations()).forEach(a -> {
                if(a instanceof MyAnnotation) {
                    MyAnnotation myAnnotation = (MyAnnotation) a;
                    System.out.println(myAnnotation.value());
                    System.out.println(myAnnotation.number());
                }
            });
        });
    }
}
