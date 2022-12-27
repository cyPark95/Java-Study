package AbstractFactoryPattern;

import AbstractFactoryPattern.abst.Button;
import AbstractFactoryPattern.abst.GuiFactory;
import AbstractFactoryPattern.abst.TextArea;
import AbstractFactoryPattern.concrete.FactoryInstance;

public class Main {

    public static void main(String[] args) {
        GuiFactory factory = FactoryInstance.instanceOf();
        Button button = factory.createButton();
        TextArea textArea = factory.createTextArea();

        System.out.println(textArea.getText());
        button.click();
    }
}
