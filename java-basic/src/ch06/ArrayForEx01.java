package ch06;

public class ArrayForEx01 {

    static void 남은금액계산(int[] coin, int restMoney){
        for(int i=0; i<4; i++) {
            System.out.println(coin[i] + " 원 : " + restMoney / coin[i]);
            restMoney = restMoney % coin[i];
            System.out.println("남은금액 : " + restMoney);
        }
    }

    public static void main(String[] args) {
        // 최소 동전 구하기 500, 100, 50, 10
        int[] coin = {500, 100, 50, 10};
        int money = 2680;
        int restMoney = money;

        // 아래의 4개의 스탭을 배열과 for문을 이용해서 수정하기!! - 리팩토링(재생산)
        남은금액계산(coin, restMoney);
    }
}
