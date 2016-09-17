package by.it.dubatovka.jd01_08;

/**
 * Created by Dubatovka Sergey on 17.09.2016.
 */
public abstract class PublicBuilding implements IBuild {

    private boolean needToRepair = false;
    protected String name = "Общественное здание";
    private double buildingArea=500;        //площадь здания
    private String adress;               //адрес здания


    @Override

    public void buildNew(int buildingArea) {
        System.out.print("----buildNew--- ");
        this.buildingArea = buildingArea;
        this.name = "Общественное здание";
        needToRepair = false;


    }




    @Override
    public void destroy() {
        System.out.print("---destroy--- ");
        this.name = "Здание снесли. Здесь был " + name;
        this.buildingArea = 0;
        needToRepair = false;
        this.adress = " ";
        System.out.println(this.name);

    }

    @Override
    public void repair() {
        System.out.print("---repair---- ");
        if (needToRepair) System.out.println("Здание отремонтировано.");
        else if (buildingArea != 0) System.out.println("Ремонт не требуется. Здание новое");
        else System.out.println("Ремонт невозможен. Здание разрушено");
    }

    @Override
    public void setAdress(String newAdress) {
        System.out.print("---setAdress--- ");
        if (buildingArea != 0) {
            this.adress = newAdress;
            System.out.println("Зданию присвоен адрес : " + adress);
        } else System.out.println("Здание отсутствует. Адрес присвоить нельзя.Постройте новое здание");
    }

    @Override
    public void getAdress() {
        System.out.print("---getAdress--- ");
        if (adress != " ")
            System.out.println("Адрес здания : " + adress);
        else System.out.println("Здание снесли. Адреса нет");

    }

    @Override
    public double getBuildingArea() {

        System.out.print("---getBuildingArea--- ");
        System.out.println("Площадь: " + buildingArea + "м2");
        return buildingArea ;

    }

    @Override
    public void cataclysm() {
        System.out.print("---cataslysm--- ");
        int random = (int) Math.round(Math.random());
        if (random == 0) {
            needToRepair = true;
            System.out.println("Случилось землятрясение");
        } else {
            needToRepair = false;
            System.out.println("Сильный ветер");
        }

    }

    public abstract String openTime(); //статический полиморфизм
    public abstract String openTime(String afisha);
}
