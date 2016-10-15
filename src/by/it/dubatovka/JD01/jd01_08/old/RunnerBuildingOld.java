package by.it.dubatovka.JD01.jd01_08.old;

/**
 * Created by Dubatovka Sergey on 17.09.2016.
 */
public class RunnerBuildingOld {
    public static void main(String[] args) {

        //Построили Здание (Театр) 1000м2 - установили ему адрес
        PublicBuildingOld publicBuilding = new TheatreOld();
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
        PublicBuildingOld publicBuilding1 = new TheatreOld();
        //установаем адрес построенному театру
        publicBuilding1.setAdress("г. Минск, пл. Парижской Коммуны, 1");
        publicBuilding1.getAdress();
        publicBuilding1.repair();
        publicBuilding1.getBuildingArea();
        publicBuilding1.openTime("Петр Чайковский\n" +
                "ЩЕЛКУНЧИК");


    }
}
