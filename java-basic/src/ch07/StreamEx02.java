package ch07;

import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx02 {

    public static void main(String[] args) {
        InputStream in = System.in;  // System.in (키보드)
        InputStreamReader ir = new InputStreamReader(in);  // 65 -> A 로 부호화

        try {
            // input 데이터 배열 크기를 크게 잡아놓으면 낭비가 심하다.
            char[] data = new char[1000];
            ir.read(data);
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
