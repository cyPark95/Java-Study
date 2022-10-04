package ch05;

class Engine{
    private int power;

    public Engine() {
        this.power = 2000;
    }

    public int getPower() {
        return power;
    }
}

class Car{  // 자동차는 엔진이 아니기 때문에, 상송할 수 없다.
    // 콤 포지션!!(결합!)
    private Engine e;

    public Car(Engine e) {
        this.e = e;
    }

    public Engine getE() {
        return e;
    }
}

class Hambuger{
    private String name;
    private String 재료1;
    private String 재료2;

    public Hambuger() {
        this.name = "기본 햄버거";
        this.재료1 = "양상추";
        this.재료2 = "패티";
    }

    public String getName() {
        return name;
    }

    public String get재료1() {
        return 재료1;
    }

    public String get재료2() {
        return 재료2;
    }
}

// 상속은 상태와 행위를 물려받을 수 있지만
// 꼭 타입이 일치될 수 있어야 한다.
class CheeseHambeger extends Hambuger{  // 치즈 햄버거 = 햄버거이다.
    // 중복되지 않는 필드만 물려받는다.
    private String name;

    public CheeseHambeger() {
        this.name = "치즈 햄버거";
    }

    public String getName() {
        return name;
    }
}

class ChickenHamberger{
    private String name;
    private Hambuger h;

    public ChickenHamberger(Hambuger h) {
        this.name = "치킨 햄버거";
        this.h = h;
    }

    public String getName() {
        return name;
    }

    public Hambuger getH() {
        return h;
    }
}

public class OOPEx02 {

    public static void main(String[] args) {
        Engine e1 = new Engine();
        Car c1 = new Car(e1);
        System.out.println("자동차의 엔진 마력은 : " + c1.getE().getPower());

        CheeseHambeger ch1 = new CheeseHambeger();
        System.out.println("햄버거의 이름은 : " + ch1.getName());
        System.out.println("재료 : " + ch1.get재료1());
        System.out.println("재료 : " + ch1.get재료2());

        Hambuger h1 = new Hambuger();
        ChickenHamberger ckh1 = new ChickenHamberger(h1);
        System.out.println("햄버거의 이름은 : " + ckh1.getName());
        System.out.println("재료 : " + ckh1.getH().get재료1());
        System.out.println("재료 : " + ckh1.getH().get재료2());
    }
}
