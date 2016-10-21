package by.it.snegurskiy.jd01.jd01_02;

/**
 * Created by snegurskiy.nn on 27.08.2016.
 */
public class B {

    public static String selectionMonth (int Array) {

        String monthString;
        switch (Array) {
            case 1:  monthString = "Январь";
                break;
            case 2:  monthString = "Февраль";
                break;
            case 3:  monthString = "Март";
                break;
            case 4:  monthString = "Апрель";
                break;
            case 5:  monthString = "Май";
                break;
            case 6:  monthString = "Июнь";
                break;
            case 7:  monthString = "Июль";
                break;
            case 8:  monthString = "Август";
                break;
            case 9:  monthString = "Сентябрь";
                break;
            case 10: monthString = "Октябрь";
                break;
            case 11: monthString = "Ноябрь";
                break;
            case 12: monthString = "Декабрь";
                break;
            default: monthString = "Не знаем такого";
                break;}
                return monthString;
    }

    public static double [] searhRoot (double Array []){
        double Discriminant=Array[1]*Array[1]-4*Array[0]*Array[2];
        if (Discriminant<0) System.out.println("нет корней(нет мнимого:))");
        else {
            Array[3] = (-1 * Array[1] + Math.sqrt(Discriminant))/(2 * Array[0]);
            Array[4]=(-1*Array[1]-Math.sqrt(Discriminant))/(2*Array[0]);
            System.out.println("Корни уравнения: "+ Array[3]+ " "+ Array[4]);}
        return Array;
    }
}
