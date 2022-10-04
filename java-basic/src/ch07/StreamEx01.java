package ch07;

import java.io.InputStream;

/**
 * 키보드 => Byte Stream => 컴퓨터
 *          인코딩 데이터
 */
public class StreamEx01 {

    public static void main(String[] args) {
        InputStream in = System.in;  // System.in (키보드)

        // 1. 키보드는 A를 인코딩해서 01000001으로 컴퓨터에게 전송
        // 2. ByteStream으로 흘러 들어간다.(Input)
        // 3. read() aptjemfh 01000001 -> 65로 디코딩한다.
        // 4. 65를 -> 문자로 부호화 시킨다.
        try {
            // 2진수 -> 10진수로 변환해서 받아준다.
            int data = in.read();
            System.out.println((char)data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
