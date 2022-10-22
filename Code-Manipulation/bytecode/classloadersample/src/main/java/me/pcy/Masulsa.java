package me.pcy;

public class Masulsa {

    public static void main(String[] args) {
        // 클래스 로딩 시점에 class 파일 자체를 변경하는 방법
//        ClassLoader classLoader = Masulsa.class.getClassLoader();
//        TypePool typePool = TypePool.Default.of(classLoader);
//
//        try {
//            new ByteBuddy().redefine(
//                            typePool.describe("me.pcy.Moja").resolve(),
//                            ClassFileLocator.ForClassLoader.of(classLoader)
//                    )
//                    .method(named("pullOut")).intercept(FixedValue.value("Rebbit!"))
//                    .make().saveIn(new File("/Users/chan-yung/java/Java-Study/Code-Manipulation/bytecode/classloadersample/target/classes/"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println(new Moja().pullOut());
    }
}
