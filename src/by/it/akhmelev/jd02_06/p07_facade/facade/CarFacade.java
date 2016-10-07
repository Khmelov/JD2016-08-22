package by.it.akhmelev.jd02_06.p07_facade.facade;

// фасад для работы 
import by.it.akhmelev.jd02_06.p07_facade.parts.Door;
import by.it.akhmelev.jd02_06.p07_facade.parts.Wheel;
import by.it.akhmelev.jd02_06.p07_facade.parts.Zazhiganie;

public class CarFacade {

    private Door door = new Door();
    private Zazhiganie zazhiganie = new Zazhiganie();
    private Wheel wheel = new Wheel();

    public void go(){
        door.open();
        zazhiganie.fire();
        wheel.turn();
    }
    
        
    
}
