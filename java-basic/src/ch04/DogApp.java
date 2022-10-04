package ch04;

public class DogApp {

    public static void main(String[] args) {
        Dog d1 = new Dog();  // heap 공간에 할당

        System.out.println(d1.name);
        System.out.println(d1.age);
        System.out.println(d1.color);
        System.out.println(d1.type);

        // 1년 후...
        // 강아지가 노란색으로 염색도 하고, 이름도 레르코로 변경했다!
        d1.age = d1.age + 1;
        d1.name = "레르코";
        d1.color = "노란색";
//        d1.type = "푸들";

        System.out.println(d1.name);
        System.out.println(d1.age);
        System.out.println(d1.color);
        System.out.println(d1.type);
    }
}
