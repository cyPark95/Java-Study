package ch07;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * BufferedReader
 * 1. 숫자 -> 부호화
 * 2. 문자를 가변적으로 받을 수 있다.
 *    배열의 공간 낭비가 없다.
 *
 * 특징
 *      1. 양 끝단의 버퍼의 크기를 맞춘다.
 *      2. 버퍼가 가등차면 자동으로 전송된다.(flush)
 *          (자동 전송의 조건 : 상대의 버퍼가 비워져 있어야 한다.)
 *      3. 전송된 후에는 버퍼가 비워지고, 그 자리에는 나머지 데이터가 갱신된다.
 */
public class StreamEx03 {

    public static void main(String[] args) {
        InputStream in = System.in;  // System.in (키보드)
        InputStreamReader ir = new InputStreamReader(in);  // 65 -> A 로 부호화
        BufferedReader br = new BufferedReader(ir);

        try {
            String data = br.readLine();
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
