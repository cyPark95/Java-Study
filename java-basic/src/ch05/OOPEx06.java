package ch05;

class 프로토스{

    private String name;

    public 프로토스() {
        this.name = "프로토스 유닛";
    }

    public void 기본공격(프로토스 e){
//        System.out.println("프로토스 메서드");
    }

    public String 이름확인(){
        return "?";
    }
}

class 질럿 extends 프로토스{
    private String name;

    public 질럿() {
        this.name = "질럿";
    }

    public String getName() {
        return name;
    }

    // 오버라이드 = 부모의 메서드를 무효화 한다.
    public void 기본공격(프로토스 e){
//        System.out.println("질럿 메서드");
        System.out.println(this.getName() + "이 " + e.이름확인() + "을 공격합니다.");
    }

    public String 이름확인(){
        return "질럿";
    }
}

class 드라군 extends 프로토스{
    private String name;

    public 드라군() {
        this.name = "드라군";
    }

    public String getName() {
        return name;
    }

    public void 기본공격(프로토스 e){
        System.out.println(this.getName() + "이 " + e.이름확인() + "을 공격하였습니다.");
    }

    public String 이름확인(){
        return "드라군";
    }
}

class 다크템플러 extends 프로토스{
    private String name;

    public 다크템플러() {
        this.name = "다크템플러";
    }

    public String getName() {
        return name;
    }

    public void 기본공격(프로토스 e){
        System.out.println(this.getName() + "이 " + e.이름확인() + "을 공격하였습니다.");
    }

    public String 이름확인(){
        return "다크템플러";
    }
}

// 신입  -> 리버라는 유닛을 하나 만들어봐(오버라이드 해서 만들어!!)
// 팀장  -> 프로토스 상속(공격 메서드, 이름을 확인하는 메서드 필요해!)
//      -> name 이라는 변수 하나 만들어! - 리버
// 신입  -> 누구를 공격하라는 거죠? -> 프로토스 유닛
// 팀장  -> 테스트 해봐 -> 질럿으로 리버 한번 공격해봐
// 신입  -> 팀장님 ? 가 뜨는데요?
// 팀장  -> 아 그거 너 메서드 이름 뭐라고 적었어? -> 이름체크
// 팀장  -> 오버라이딩이 안됐네! 이름확인이라고 만들어!!
class 리버 extends 프로토스{
    private String name;

    public 리버() {
        this.name = "리버";
    }

    public String getName() {
        return name;
    }

    public void 기본공격(프로토스 e){
        System.out.println(this.getName() + "이 " + e.이름확인() + "을 공격합니다.");
    }

    public String 이름확인(){
        return "리버";
    }
}

public class OOPEx06 {

    public static void main(String[] args) {
        프로토스 u1 = new 질럿();           // 질럿과 프로토스가 메모리에 할당된다.
        프로토스 u2 = new 드라군();         // 드라군과 프로토스가 메모리에 할당된다.
        프로토스 u3 = new 다크템플러();      // 다크템플러와 프로토스가 메모리에 할당된다.
        프로토스 u4 = new 리버();

        u1.기본공격(u2);
        u2.기본공격(u1);
        u2.기본공격(u3);
        u1.기본공격(u4);
        u4.기본공격(u1);
    }
}
