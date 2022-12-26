package AdapterPattern;

public class Main {

    public static void main(String[] args) {

        Adapter adapter = new AdapterImpl();

        System.out.println("Twice Of 50 : " + adapter.twiceOf(50f));
        System.out.println("Half Of 50 : " + adapter.halfOf(50f));
    }
}
