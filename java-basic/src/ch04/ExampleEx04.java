package ch04;

public class ExampleEx04 {

    public static void main(String[] args) {
        Food chicken = new Food("치킨", 2000);
        chicken.myPrint();

        Food pizza = new Food("피자", 5000);
        pizza.myPrint();
    }
}

class Food{
    String name;
    int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void myPrint(){
        System.out.println(name + " 가격은 " + price + "원 입니다.");
    }
}