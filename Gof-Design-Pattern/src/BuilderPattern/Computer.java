package BuilderPattern;

public class Computer implements ComputerBuilder {

    private String mb;
    private String cpu;
    private String gpu;
    private String ram;
    private String storage;
    private String power;

    public Computer() {
    }

    public Computer(String cpu, String gpu, String ram, String storage, String mb, String power) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
        this.mb = mb;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", mb='" + mb + '\'' +
                ", power='" + power + '\'' +
                '}';
    }

    @Override
    public ComputerBuilder cpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @Override
    public ComputerBuilder gpu(String gpu) {
        this.gpu = gpu;
        return this;
    }

    @Override
    public ComputerBuilder ram(String ram) {
        this.ram = ram;
        return this;
    }

    @Override
    public ComputerBuilder storage(String storage) {
        this.storage = storage;
        return this;
    }

    @Override
    public ComputerBuilder power(String power) {
        this.power = power;
        return this;
    }

    @Override
    public Computer getComputer() {
        return this;
    }
}
