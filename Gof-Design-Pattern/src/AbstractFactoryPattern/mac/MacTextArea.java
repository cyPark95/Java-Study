package AbstractFactoryPattern.mac;

import AbstractFactoryPattern.abst.TextArea;

public class MacTextArea implements TextArea {
    @Override
    public String getText() {
        return "맥 텍스트 영역";
    }
}
