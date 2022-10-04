package ch05;

// 추상 클래스
abstract class Animal{
    abstract void speak();  // 추상 메서드(몸체{}가 없다.)

    // 일반 메서드도 갖을 수 있다.
    void Hello(){
        System.out.println("!!!");
    }
}

class Dog extends Animal{
    // 오버라이드 (Animal 의 speak() 가 무효화 된다.
    void speak() {
        System.out.println("멍멍!!");
    };
}

class Cat extends Animal{
    // 오버라이드 (Animal 의 speak() 가 무효화 된다.
    void speak() {
        System.out.println("냐옹!!");
    };
}

// 신입아 Bird 를 만들어!!, Animal 을 상속해서 만들어!!
// System.out.println("짹짹!!")
class Bird extends Animal{

    // 추상 메서드를 부모가 가지고 있으면
    // 자식은 추상 메서드를 반드시 구현해야 한다.
    @Override
    void speak() {
        System.out.println("짹짹!!");
    }
}

public class OOPEx07 {

    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.speak();     // 동적 바인딩 된다.
        a2.speak();     // 왜? 부모의 메서드가 무효화 되니깐!!

        Animal a3 = new Bird();
        a3.speak();
    }
}
