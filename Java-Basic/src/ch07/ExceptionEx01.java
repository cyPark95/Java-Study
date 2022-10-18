package ch07;

/**
 * 컴파일 예외의 부모 => Exception
 * 런타임 예외의 부모 => RuntimeException
 */
public class ExceptionEx01 {

    public static void main(String[] args) {

        // 컴파일 예외(Java 가 알 수 있다.)
        try {
            System.out.println("잠자기 시작!!");
            Thread.sleep(1000);         // 현재 사용하고 있는 스레드 1초동안 잠을 잔다!
            System.out.println("잠자기 끝!!");
        } catch (InterruptedException e) {    // Interrupt : 방해!!
            e.printStackTrace();
        }

        // 런타임 예외(개발자가 알 수 있다.)
        int[] nums = {1, 2, 3};

        try{
            System.out.println(nums[3]);  // 예외 처리를 안해주면 프로그램 강제 종료!!
        }catch(RuntimeException e){
            // catch 의 역할은 try (시도) 하다가 예외가 발생하면 어떻게 처리할지를 정의하는 영역
            System.out.println("괜찮아.. 그냥 진행해!!");
            System.out.println(e.getMessage());  // 로그 파일로 남겨둬야 한다.
            e.printStackTrace();
        }

        String data = null;

        try {
            System.out.println(data.length());
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            data = "만들었다!!";
            System.out.println(data.length());
        }

        System.out.println("메인 스레드 종료");
    }
}
