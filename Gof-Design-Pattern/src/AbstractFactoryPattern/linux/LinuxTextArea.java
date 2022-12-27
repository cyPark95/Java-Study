package AbstractFactoryPattern.linux;

import AbstractFactoryPattern.abst.TextArea;

public class LinuxTextArea implements TextArea {
    @Override
    public String getText() {
        return "리눅스 텍스트 영역";
    }
}
