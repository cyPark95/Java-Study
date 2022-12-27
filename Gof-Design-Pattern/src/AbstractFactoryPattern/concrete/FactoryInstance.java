package AbstractFactoryPattern.concrete;

import AbstractFactoryPattern.abst.GuiFactory;
import AbstractFactoryPattern.linux.LinuxGuiFactory;
import AbstractFactoryPattern.mac.MacGuiFactory;
import AbstractFactoryPattern.win.WinGuiFactory;

/**
 * 구체적인 팩토리 클래스로 GuiFactory 클래스의 추상 메서드를 오버라이드함으로써 구체적인 제품을 생성
 */
public class FactoryInstance {

    public static GuiFactory instanceOf() {

        String os = System.getProperty("os.name").toUpperCase();

        if (os.contains("LINUX")) {
            return new LinuxGuiFactory();
        } else if (os.contains("MAC")) {
            return new MacGuiFactory();
        } else if (os.contains("WIN")) {
            return new WinGuiFactory();
        } else {
            throw new Error();
        }
    }
}
