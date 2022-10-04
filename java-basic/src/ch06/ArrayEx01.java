package ch06;

/**
 * 배열
 *
 * 1. 연속된 3개의 int 형 공간이 필요할 때, 사용한다.
 * 2. 데이타 읽기 속도가 빠르다.
 * 3. 시작 주소만 저장하고 바라본다.
 * 4. 0번지 주소부터 시작한다.
 */
public class ArrayEx01 {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6};

        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println(nums[2]);

//        System.out.println(nums[3]);
    }
}
