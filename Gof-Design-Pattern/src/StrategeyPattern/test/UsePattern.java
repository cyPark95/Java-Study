package StrategeyPattern.test;

public class UsePattern {
    private final Pattern pattern;

    public UsePattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public void printUsePatternName() {
        // 다른 객체에 기능을 위임
        System.out.println("Use Pattern Name: [" + pattern.getPatternName() + "]");
    }
}
