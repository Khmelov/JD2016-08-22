package by.it.dubatovka.jd01_08;

/**
 * Created by Dubatovka Sergey on 17.09.2016.
 */
public class RunnerBuilding {
    public static void main(String[] args) {

        //Построили Здание (Театр) 1000м2 - установили ему адрес
        PublicBuilding publicBuilding = new Theatre();
        publicBuilding.buildNew(1000);
        publicBuilding.setAdress("Скрыганова 14");
        //проверим площадь, режим работы, адрес
        publicBuilding.getBuildingArea();
        publicBuilding.openTime();
        publicBuilding.getAdress();
        //случается катаклизм
        publicBuilding.cataclysm();
        //ремонтируем
        publicBuilding.repair();
        //случается катаклизм
        publicBuilding.cataclysm();
        //ремонтируем
        publicBuilding.repair();
        //сносим здание
        publicBuilding.destroy();
        //проверяем его адрес
        publicBuilding.getAdress();
        //пробуем установить адрес снесенному зданию
        publicBuilding.setAdress("г. Минск, пл. Парижской Коммуны, 1");
        //проверяем афишу
        publicBuilding.openTime();
        //строим новый театр
        PublicBuilding publicBuildingNew = new Theatre();
        //установаем адрес построенному театру
        publicBuildingNew.setAdress("г. Минск, пл. Парижской Коммуны, 1");
        publicBuildingNew.getAdress();
        publicBuildingNew.repair();
        publicBuildingNew.getBuildingArea();
        publicBuildingNew.openTime("Петр Чайковский\n" +
                "ЩЕЛКУНЧИК");




    }
}
