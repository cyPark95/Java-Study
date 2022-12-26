package PrototypePattern.DeepShallow;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Cat cat1 = new Cat();
        cat1.setName("navi");
        cat1.setAge(new Age(2020, 3));
        System.out.println("Cat1(Name/Age): " + cat1.getName() + "/" + cat1.getAge());

        Cat cat2 = cat1.copy();
        cat2.setName("yo");
        cat2.getAge().setYear(2022);
        cat2.getAge().setValue(1);
        System.out.println("Cat2(Name/Age): " + cat2.getName() + "/" + cat2.getAge());
    }
}
