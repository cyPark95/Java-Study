package PrototypePattern;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Circle circle1 = new Circle(1, 1, 3);
        Circle circle2 = circle1.copy();

        System.out.println("Circle1: " + circle1.getX() + ", " + circle1.getY() + ", " + circle1.getR());
        System.out.println("Circle2: " + circle2.getX() + ", " + circle2.getY() + ", " + circle2.getR());
    }
}
