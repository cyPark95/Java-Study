package ch03;

public class ExampleEx03 {

    static double calc(double gasoline, double distance){
        System.out.println(distance / gasoline);
        int result = (int) (distance / gasoline);

        return result;
    }

    public static void main(String[] args) {
        double gasoline = 8.86;
        double distance = 182.736;
        double efficiency = calc(gasoline, distance);

        System.out.println("연비 : " +  efficiency + "km/L");
    }
}
