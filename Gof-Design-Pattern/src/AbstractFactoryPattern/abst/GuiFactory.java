package AbstractFactoryPattern.abst;

/**
 * 실제 팩토리 클래스의 공통 인터페이스
 */
public interface GuiFactory {

    Button createButton();
    TextArea createTextArea();
}
