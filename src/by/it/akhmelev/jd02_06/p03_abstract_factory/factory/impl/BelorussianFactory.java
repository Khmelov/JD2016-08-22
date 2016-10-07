package by.it.akhmelev.jd02_06.p03_abstract_factory.factory.impl;

import by.it.akhmelev.jd02_06.p03_abstract_factory.factory.interfaces.TransportFactory;
import by.it.akhmelev.jd02_06.p03_abstract_factory.transport.interfaces.Aircraft;
import by.it.akhmelev.jd02_06.p03_abstract_factory.transport.interfaces.Car;
import by.it.akhmelev.jd02_06.p03_abstract_factory.transport.impl.car.Maz;
import by.it.akhmelev.jd02_06.p03_abstract_factory.transport.impl.aircraft.TU134;

// российские транспортные средства
public class BelorussianFactory implements TransportFactory{

    @Override
    public Car createCar() {
        return new Maz();
    }

    @Override
    public Aircraft createAircraft() {
        return new TU134();
    }

}
