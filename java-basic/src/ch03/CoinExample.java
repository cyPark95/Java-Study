package ch03;

public class CoinExample {

    public static void main(String[] args) {

        // 최소 동전 구하기 500, 100, 50, 10
        int money = 2680;
        int restMoney = money;

        // 변수명의 첫 글자는 숫자가 될 수 없다.
        int count500 = 0;
        int count100 = 0;
        int count50 = 0;
        int count10 = 0;

        // 스탭 1
        count500 = restMoney / 500;
        System.out.println("500 원 : " + count500);       // 180원 남음
        restMoney = money % 500;
        System.out.println("남은금액 : " + restMoney);

        // 스탭 2
        count100 = restMoney / 100;
        System.out.println("100 원 : " + count100);       // 80원 남음
        restMoney = restMoney % 100;
        System.out.println("남은금액 : " + restMoney);

        // 스탭 3
        count50 = restMoney / 50;
        System.out.println("50 원 : " + count50);         // 30원 남음
        restMoney = restMoney % 50;
        System.out.println("남은금액 : " + restMoney);

        // 스탭 4
        count10 = restMoney / 10;
        System.out.println("50 원 : " + count10);         // 0원 남음
        restMoney = restMoney % 10;
        System.out.println("남은금액 : " + restMoney);

        // 마무리
        System.out.println("=====================");
        System.out.println(money + "의 최소 동전 개수는?");
        System.out.println("500 원 " + count500 + "개");
        System.out.println("100 원 " + count100 + "개");
        System.out.println("50 원 " + count50 + "개");
        System.out.println("10 원 " + count10 + "개");
    }
}
