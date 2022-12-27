package AbstractFactoryPattern.mac;

import AbstractFactoryPattern.abst.Button;
import AbstractFactoryPattern.abst.GuiFactory;
import AbstractFactoryPattern.abst.TextArea;

public class MacGuiFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextArea createTextArea() {
        return new MacTextArea();
    }
}
