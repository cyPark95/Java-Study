package ch06;

/**
 * 이전 멍청한 구구단 코드를 반복문을 활용하기!
 */
public class ForEx03 {

    public static void main(String[] args) {

        for(int i=2; i<10; i++){
            for(int j=1; j<10; j++) {
                System.out.println(i + " * " + j + " = " + i * j);
            }
            System.out.println();
        }
    }
}
