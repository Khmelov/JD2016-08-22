package by.it.dubatovka.JD01.jd01_02;

public class TaskB {
    public static double[] kvadrUravn(int[] mas) {
        int a = mas[0];
        int b = mas[1];
        int c = mas[2];
        int d = b * b - 4 * a * c;
        double[] x = {0, 0, 2};
        if (d < 0)
            x[2] = 0;

        if (d >= 0) {
            x[0] = (-b + Math.sqrt(d)) / 2 * a;
            x[1] = (-b - Math.sqrt(d)) / 2 * a;
            if (0 == d) x[2] = 1;
        }

        return x;
    }

    public static String month(int i) {
        String mm;
        switch (i) {
            case 1:
                mm = "Январь";
                break;
            case 2:
                mm = "Февраль";
                break;
            case 3:
                mm = "Март";
                break;
            case 4:
                mm = "Апрель";
                break;
            case 5:
                mm = "Май";
                break;
            case 6:
                mm = "Июнь";
                break;
            case 7:
                mm = "Июль";
                break;
            case 8:
                mm = "Август";
                break;
            case 9:
                mm = "Сентябрь";
                break;
            case 10:
                mm = "Октябрь";
                break;
            case 11:
                mm = "Ноябрь";
                break;
            case 12:
                mm = "Декабрь";
                break;
            default:
                mm = "Ошибка. Неккоректно введено число. Соответствующего месяца нет";
        }
        return mm;
    }
}






