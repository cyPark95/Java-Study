package BridgePattern;

public class PrintMorseCode extends MorseCode {

    public PrintMorseCode(MorseCodeFunction function) {
        super(function);
    }

    public PrintMorseCode p() {
        dot(); dash(); dash(); dot(); space();
        return this;
    }

    public PrintMorseCode c() {
        dash(); dot(); dash(); dot(); space();
        return this;
    }

    public PrintMorseCode y() {
        dash(); dot(); dash(); dash(); space();
        return this;
    }
}
