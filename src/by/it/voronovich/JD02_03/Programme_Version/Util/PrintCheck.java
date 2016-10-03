package by.it.voronovich.JD02_03.Programme_Version.Util;

import by.it.voronovich.JD02_03.Programme_Version.Client;
import static by.it.voronovich.JD02_03.Programme_Version.Util.GoodsList.getPriceDoub;

public class PrintCheck {



    public static void printCheckClient(Client client){

        double sum = 0;
        System.out.println("Чек/" +client + ":");
        for (int i = 0; i < client.choosenGoods.size(); i++) {
            System.out.printf("%-10s..........%4.2f рублей", client.choosenGoods.get(i), getPriceDoub(client.choosenGoods.get(i)));
            System.out.println("");
            sum += getPriceDoub(client.choosenGoods.get(i));
        }
        System.out.printf("Сумма...............%4.2f рублей", sum);
        System.out.println("");
    }
}
