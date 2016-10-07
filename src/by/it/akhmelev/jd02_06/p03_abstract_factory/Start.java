package by.it.akhmelev.jd02_06.p03_abstract_factory;

import by.it.akhmelev.jd02_06.p03_abstract_factory.factory.impl.BelorussianFactory;
import by.it.akhmelev.jd02_06.p03_abstract_factory.factory.impl.USAFactory;
import by.it.akhmelev.jd02_06.p03_abstract_factory.factory.interfaces.TransportFactory;

public class Start {
    private static TransportFactory factory;
    public static void main(String[] args) {
        boolean home = Math.random()>0.5;
        if (home){
            factory = new BelorussianFactory();
        }else{
            factory = new USAFactory();
        }
        factory.createAircraft().flight();
        factory.createCar().drive();
    }

}
