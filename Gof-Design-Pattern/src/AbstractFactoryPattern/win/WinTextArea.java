package AbstractFactoryPattern.win;

import AbstractFactoryPattern.abst.TextArea;

public class WinTextArea implements TextArea {
    @Override
    public String getText() {
        return "윈도우 텍스트 영역";
    }
}
