package by.it.akhmelev.jd02_06.p07_facade.objects;

import by.it.akhmelev.jd02_06.p07_facade.facade.CarFacade;
import by.it.akhmelev.jd02_06.p07_facade.parts.Door;
import by.it.akhmelev.jd02_06.p07_facade.parts.Wheel;
import by.it.akhmelev.jd02_06.p07_facade.parts.Zazhiganie;

public class Client {

    public static void main(String[] args) {
        // вызов без фасада
        Door door = new Door();
        door.open();

        Zazhiganie zazhiganie = new Zazhiganie();
        zazhiganie.fire();
        
        Wheel wheel = new Wheel();
        wheel.turn();
        

        // вызов с фасадом
        CarFacade carFacade = new CarFacade();
        carFacade.go();
    }
}
