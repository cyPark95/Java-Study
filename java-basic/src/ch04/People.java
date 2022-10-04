package ch04;

public class People {

    String name;
    int age;

    // 디폴트 생성자가 있을까요?
    // 있다!! => .java -> .class 컴파일 할 때, 자바가 자동으로 코드를 만들어준다.
//    public People() {
//        System.out.println("디폴트 생성자!!");
//    }

    // 디폴트 생성자가 있을까요?
    // 없다. => 내가 직접 생성자를 정의하였기 때문에 디폴트 생성자가 없다.
    public People(String name, int age) {
        System.out.println("People 메서드 스택 name = " + name);
        System.out.println("People 메서드 스택 age = " + age);
        this.name = name;
        this.age = age;
    }
}
