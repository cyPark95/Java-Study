package PrototypePattern.DeepShallow;

public class Age {

    private int year;
    private int value;

    public Age(int year, int value) {
        this.year = year;
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Age{" +
                "year=" + year +
                ", value=" + value +
                '}';
    }
}
