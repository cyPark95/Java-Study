package me.pcy.java8.changeInterface;

public class DefaultName implements NameInf, Other {

    String name;

    public DefaultName(String name) {
        this.name = name;
    }

    // NameInf와 Other에 모두 printNameUpperCase가 기본 메서드라면 반드시 재정의 해야한다.
    @Override
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
