package BuilderPattern;

public class Main {

    public static void main(String[] args) {

        // 가독성도 낮고, 순서가 중요하다.
        Computer computer = new Computer("i7", "GTX", "16G", "1TB", "PRIME", "500W");

        ComputerBuilder computerBuilder = new Computer();
        Computer buildComputer = computerBuilder
                .cpu("i7")
                .gpu("GTX")
                .ram("16G")
                .storage("1TB")
                .power("500W")
                .getComputer();

        System.out.println("Construct Computer: " + computer);
        System.out.println("Builder Computer  : " + buildComputer);
    }
}
