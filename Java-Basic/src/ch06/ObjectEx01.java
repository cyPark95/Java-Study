package ch06;

class Dog extends Object{
    String name = "토토";
}

// Object 는 모든 클래스의 부모이다.
// extends Object 가 생량되어 있다.
class Cat{
    String name = "야옹이";
}

public class ObjectEx01 {

    public static void main(String[] args) {
        Object o1 = new Dog();
        Object o2 = new Cat();

        // 다운 캐스팅
        Dog d1 = (Dog)o1;
        Cat c1 = (Cat)o2;

        // 문법상에는 오류가 없지만 실행하면 오류난다!!
        // o1은 Cat 으로 다운 캐스팅 할 수 없다.
        // o1은 [Object][Dog] 만 메모리 할당되어 있다.
        Cat c2 = (Cat)o1;

        System.out.println(d1.name);
        System.out.println(c1.name);
    }
}
