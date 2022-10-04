package ch02;

/**
 * Stack    지역변수 => 메서드가 실행될 때, 메모리에 할당된다.
 *                     메서드가 종료될 때, 메모리에서 삭제된다.
 *
 * Heap     전역변수 => new 할 때, 메모리에 할당된다.
 *                     더이상 참조하지 않을 때, 메모리에서 삭제된다.
 *
 * Static   전역변수 => main 메서드가 실행되기 전에 메모리에 할당된다.
 *                     main 메서드가 종료될 때(Java 프로그램이 종료될 때), 메모리에서 삭제된다.
 */
public class StackEx02 {

    static int sum = 20;  // 전역변수 (static)  main 메서드가 시작되기 전에 sum이 할당된다.
    int value = 50;       // 전역변수 (heap)    더 이상 참조하지 않을 때 자동으로 사라진다.

    static void a(){
        // a 메서드가 실행될 때, stack 공간에 n1이 할당되고, a 메서드가 종료되면 메모리에서 사라진다.
        int n1 = 1;  // a 메서드의 스택 영역에 저장(지역변수) (stack)
                     // 외부에서 접근 불가
        System.out.println(n1);

//        static int n2 = 2;      // 24번 라인이 실행되려고 할 때, static 공간에 할당해야 하는데 불가능하다.
                                  // static 공간 할당은 main 메서드 실행 전에만 할당 할 수 있다.
    }
    public static void main(String[] args) {
        a();  // 메서드를 호출한다.

        System.out.println("sum = " + sum);

        StackEx02 s = new StackEx02();  // heap 공간에 value 할당된다.
        System.out.println("value = " + s.value);
        // 더 이상 s 변수를 참조하지 않기 때문에 value는 자동으로 사라진다.
    }
}
