package by.it.kisel.JD01_05;

public class KontrZad1 {
    public static double polnV() {
        double x = 12.75;
        double y;
        y = ((Math.sin(Math.toRadians((Math.PI / 8) - 1)) + Math.pow(3 + x * x, 1 / 4)) / (Math.asin(Math.toRadians(x / 2)) - 5.326 * Math.pow(10, -2))) + Math.log(Math.abs(3.12 - x));
        return y;
    }

    public static double razbV() {
        double x = 12.75;
        double y, y1, y2, y3;
        y1 = Math.sin(Math.toRadians((Math.PI / 8) - 1)) + Math.pow(3 + x * x, 1 / 4);
        y2 = Math.asin(Math.toRadians(x / 2)) - 5.326 * Math.pow(10, -2);
        y3 = Math.log(Math.abs(3.12 - x));
        y = y1 / y2 + y3;
        return y;
    }
}
