package AbstractFactoryPattern.linux;

import AbstractFactoryPattern.abst.Button;
import AbstractFactoryPattern.abst.GuiFactory;
import AbstractFactoryPattern.abst.TextArea;

public class LinuxGuiFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public TextArea createTextArea() {
        return new LinuxTextArea();
    }
}
