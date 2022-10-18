package ch06;

import java.util.ArrayList;

public class CollectionEx01 {

    public static void main(String[] args) {
        // 기본 자료형    => 값을 가지고 있다.
        // 레퍼런스 자료형 => 주소를 가지고 있다.
        // 래핑클래스 = Integer, Double, Character, Boolean 등
        ArrayList<Integer> c1 = new ArrayList<>();

        c1.add(1);
        c1.add(2);
        c1.add(3);
        c1.add(4);
        c1.add(5);

//        System.out.println(c1.get(0));

        int size = c1.size();
        System.out.println("사이즈 : " + size);
        // for 문 (반복문)
        for(int i=0; i<size; i++){
            System.out.println(c1.get(i));
        }
    }
}
