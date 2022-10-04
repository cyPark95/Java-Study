package ch05;

interface MoveAble{
    // public abstract 가 생략되어 있다.
    void 위();
    void 아래();
    void 왼쪽();
    void 오른쪽();
    void 냄새맡기();
}

interface DocileMoveAble{
    void 위();
    void 아래();
    void 왼쪽();
    void 오른쪽();
    void 숨기();
}

abstract class 사나운동물 implements MoveAble{
    abstract void 공격();  // 미완성된 메서드

    @Override
    public void 위() {
        System.out.println("위쪽으로 이동");
    }

    @Override
    public void 아래() {
        System.out.println("아래쪽으로 이동");
    }

    @Override
    public void 왼쪽() {
        System.out.println("왼쪽으로 이동");
    }

    @Override
    public void 오른쪽() {
        System.out.println("오른쪽으로 이동");
    }

    // 추상 클래스에서 구현하는 이유
    // 모두 다 코로 냄새 맡으니까!!
    @Override
    public void 냄새맡기() {
        System.out.println("코로 냄새 맡기!!");
    }
}

abstract class 온순한동물 implements DocileMoveAble{
    abstract void 채집();  // 미완성된 메서드

    @Override
    public void 위() {
        System.out.println("위쪽으로 이동");
    }

    @Override
    public void 아래() {
        System.out.println("아래쪽으로 이동");
    }

    @Override
    public void 왼쪽() {
        System.out.println("왼쪽으로 이동");
    }

    @Override
    public void 오른쪽() {
        System.out.println("오른쪽으로 이동");
    }

    @Override
    public void 숨기() {
        System.out.println("땅바닥으로 숨기!!");
    }
}

// 구현이 자식 클래스로 위임된다.(위, 아래, 왼쪽, 오른쪽)
class 원숭이 extends 온순한동물{

    @Override   // 어노테이션 => JVM이 실행시에 분석해서 확인한다.
                // JVM 이 볼 수 있는 힌트!!
    void 채집() {
        System.out.println("바나나 채집!!");
    }
}

class 소 extends 온순한동물 {

    @Override
    void 채집() {
        System.out.println("풀 채집!!");
    }
}

class 호랑이 extends 사나운동물{

    @Override
    void 공격() {
        System.out.println("이빨로 공격!!");
    }
}

class 코뿔소 extends 사나운동물{

    @Override
    void 공격() {
        System.out.println("몸통 박치기로 공격!!");
    }
}

// 신입아 말 만들어볼래?
// 말은 온순한 동물을 상속받아서 만들어!!
class 말 extends 온순한동물{

    @Override
    void 채집() {
        System.out.println("풀을 먹다.");
    }
}

// 신입아 하이에나 만들어볼래?
// 하이에나는 사나운 동물을 상속받아서 만들어!!
class 하이에나 extends 사나운동물{

    @Override
    void 공격() {
        System.out.println("이빨로 공격!!");
    }
}

public class OOPEx09 {

    static void 조이스틱(온순한동물 u){
        u.채집();
        u.숨기();
        u.위();
        u.아래();
        u.오른쪽();
        u.왼쪽();
        System.out.println("=======");
    }

    static void 조이스틱(사나운동물 u){
        u.공격();
        u.위();
        u.아래();
        u.오른쪽();
        u.왼쪽();
        u.냄새맡기();
        System.out.println("=======");
    }

    public static void main(String[] args) {
        소 u1 = new 소();
        조이스틱(u1);
        원숭이 u2 = new 원숭이();
        조이스틱(u2);

        호랑이 u3 = new 호랑이();
        조이스틱(u3);
        코뿔소 u4 = new 코뿔소();
        조이스틱(u4);

        말 u5 = new 말();
        조이스틱(u5);

        하이에나 u6 = new 하이에나();
        조이스틱(u6);
    }
}
