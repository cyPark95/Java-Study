package ch04;

import java.util.Random;

// JDK 설치 - JDK(javac, java), JRE(라이브러리), JVM(가상머신)
public class LibEx01 {

    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt());
    }
}
