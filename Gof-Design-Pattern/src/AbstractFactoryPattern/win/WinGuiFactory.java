package AbstractFactoryPattern.win;

import AbstractFactoryPattern.abst.Button;
import AbstractFactoryPattern.abst.GuiFactory;
import AbstractFactoryPattern.abst.TextArea;

public class WinGuiFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public TextArea createTextArea() {
        return new WinTextArea();
    }
}
