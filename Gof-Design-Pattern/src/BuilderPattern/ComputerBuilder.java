package BuilderPattern;

public interface ComputerBuilder {

    ComputerBuilder cpu(String cpu);
    ComputerBuilder gpu(String gpu);
    ComputerBuilder ram(String ram);
    ComputerBuilder storage(String storage);
    ComputerBuilder power(String power);

    Computer getComputer();
}
