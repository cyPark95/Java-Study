package BridgePattern;

public class Main {

    public static void main(String[] args) {
        PrintMorseCode morseCode = new PrintMorseCode(new FlashMorseCode());
        morseCode.p().c().y();
    }
}
