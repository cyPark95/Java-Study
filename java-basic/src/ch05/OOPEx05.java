package ch05;

class 전사{   // 검
    private String name;

    public 전사() {
        this.name = "전사";
    }

    public String getName() {
        return name;
    }

    void 기본공격(궁수 e){
        System.out.println("검으로 " + e.getName() + "공격");
    }
    void 기본공격(마법사 e){
        System.out.println("검으로 " + e.getName() + "공격");
    }
}

class 궁수{   // 활
    private String name;

    public 궁수() {
        this.name = "궁수";
    }

    public String getName() {
        return name;
    }

    // 오버로딩
    // 유닛이 100개라면? 다른 이름의 함수 100개가 필요하다!
    void 기본공격(마법사 e){
        System.out.println("활로 " + e.getName() + " 공격");
    }
}

class 마법사{  // 지팡이
    private String name;

    public 마법사() {
        this.name = "마법사";
    }

    public String getName() {
        return name;
    }

    void 기본공격(전사 e){
        System.out.println("지팡이로 " + e.getName() + " 공격");
    }
}

public class OOPEx05 {

    public static void main(String[] args) {
        전사 u1 = new 전사();
        궁수 u2 = new 궁수();
        마법사 u3 = new 마법사();

        u1.기본공격(u2);
        u2.기본공격(u3);
        u3.기본공격(u1);

        // 기억해야 할 메서드는 기본공격() 이다!!
        // 하지만.. 유닛이 100개라면? 기본공격 메서드가 100개가 되어야 한다.
        // 오버로딩은 어느 정도 경우의 수의 제한이 있을때 사용한다면 좋다!
        u1.기본공격(u3);
    }
}
