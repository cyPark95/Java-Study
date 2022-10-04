package ch05;

// 접근 제어자 = 디폴트 접근 제어자, public 접근 제어자, private 접근 제어자
class Player{
    // 상태 = 필드
    String name;    // 이름

    // 외부 클래스에서 접근 불가!
    private int thirty;     // 목마름(0~100)

    public Player(String name, int thirty) {
        this.name = name;
        this.thirty = thirty;
    }

    // 행위 = 메서드 => 값을 변경할 수 있다.
    void 물마시기(){
        System.out.println("물마시기 행위!!");
        this.thirty = this.thirty - 50;
    }

    int 목마름상태확인(){
        return this.thirty;
    }
}

public class OOPEx01 {

    public static void main(String[] args) {
        Player p1 = new Player("홍길동", 100);
        System.out.println("이름음 : " + p1.name);
        System.out.println("갈증 지수 : " + p1.목마름상태확인());

        // 1. 첫 번째 시나리오 => 마법!
//        p1.thirty = 50;  // 마법!! => 아무런 원인 없이 갈증 지수 변경!
//        System.out.println("갈증 지수 : " + p1.thirty);

        // 2. 두 번째 시나리오 => 상태가 행위를 변경함
        // 이렇게 하면 안됨!!
        // 실수 할 수 있다...
//        p1.물마시기();
//        p1.thirty = 50;
//        System.out.println("갈증 지수 : " + p1.thirty);

        // 3. 세 번째 시나리오
        p1.물마시기();
        System.out.println("갈증 지수 : " + p1.목마름상태확인());
    }
}
