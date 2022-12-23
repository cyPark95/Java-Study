package StrategeyPattern.test;

import StrategeyPattern.GameCharacter;
import StrategeyPattern.Knife;
import StrategeyPattern.Sword;

public class Main {

    public static void main(String[] args) {
        Pattern pattern = new MyPattern();

        // 기능을 사용하기 위한 통로
        System.out.println("Pattern Name: [" + pattern.getPatternName() + "]");

        UsePattern usePattern = new UsePattern(pattern);
        usePattern.printUsePatternName();
    }
}
