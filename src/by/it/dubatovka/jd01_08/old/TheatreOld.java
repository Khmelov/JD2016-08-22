package by.it.dubatovka.jd01_08.old;

/**
 * Created by Dubatovka Sergey on 17.09.2016.
 */
public class TheatreOld extends PublicBuildingOld {

    public String afisha = " 29 сентября, 19.00\n" +
            "КАРМЕН\n" +
            "опера в 3-х действиях\n";

    double x = getBuildingArea();

    @Override
    public void buildNew(int buildingArea) {
        super.buildNew(buildingArea);
        this.name = "ТЕАТР";

        System.out.println(this.name);
    }


    @Override
    public String openTime() {
        System.out.print("---openTime--- ");

        if (x != 0) {
            System.out.println("Афиша:\n" + afisha);
            return afisha;
        } else {
            System.out.println("Здания нет и сеансов нет");
            return null;
        }
    }

    @Override
    public String openTime(String afisha) {
        System.out.print("---openTime---СтатПолим--- ");
        this.afisha = afisha;

        if (x != 0) {
            System.out.println("Афиша:\n" + afisha);
            return afisha;
        } else {
            System.out.println("Здания нет и сеансов нет");
            return null;
        }

    }

}




