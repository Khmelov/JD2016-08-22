package by.it.akhmelev.jd02_06.p03_abstract_factory.transport.impl.aircraft;

import by.it.akhmelev.jd02_06.p03_abstract_factory.transport.interfaces.Aircraft;

public class Boeing747 implements Aircraft{
    @Override
    public void flight() {
        System.out.println("Boeing747 flight!");
    }
}
