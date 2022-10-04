package ch07;

/**
 * String
 * 장점 : 같은 문자열이면 같은 공간을 공유              => 메모리 효율이 높다
 * 단점 : 문자열을 변경하게 될 때마다 새로운 메모리가 할당  => 자주 변경하는 경우에는 사용X
 */
public class StringEx01 {

    public static void main(String[] args) {
        String s1 = new String("바다");  // 100 번지
        String s2 = new String("바다");  // 200 번지
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);  // == : 주소를 비교!!

        String s3 = "바다";  // 500 번지
        String s4 = "바다";  // 500 번지
        System.out.println(s3 == s4);

        s4 += "태양";
        System.out.println(s3);
        System.out.println(s4);

        // 문자열을 비교할 때 => s1, s2, s3 : 바다
        // equals => 문자열 값 자체와 주소 두개를 비교한다.(둘 중 하나만 같아도 true)
        System.out.println(s1.equals("바다"));
    }
}
