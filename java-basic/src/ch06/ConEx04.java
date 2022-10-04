package ch06;

public class ConEx04 {

    public static void main(String[] args) {

        // 연습문제 1
        // 1~10까지 출력하시오.
        // 하지만 6은 출력하지 마시오.
        for(int i=1; i<11; i++){
            if(i != 6){
                System.out.println(i);
            }
        }
        System.out.println();

        // 연습문제 2
        // 10~1까지의 수를 출력하시오.
        // 단, 숫자가 3일때는 출력하지 마시오.
        for(int i=10; i>0; i--){
            if(i != 3){
                System.out.println(i);
            }
        }
        System.out.println();

        // 연습문제 3
        // 1~20까지의 수를 출력하시오.
        // 단, 2의 배수일때만 출력하시오.
        for(int i=1; i<21; i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
        System.out.println();
        for(int i=2; i<21; i+=2){
            System.out.println(i);
        }
    }
}
