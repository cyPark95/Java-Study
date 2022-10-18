package ch06;

public class ArrayEx02 {

    public static void main(String[] args) {
        // 3개의 공강니 heap 메모리에 생성된다.
        int[] nums = new int[3];

        nums[0] = 4;
        nums[1] = 5;

        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println(nums[2]);  // int 의 값이 초기화되지 않으면 0이 저장된다.
    }
}
