package by.it.akhmelev.jd02_06.p05_decorator;

import by.it.akhmelev.jd02_06.p05_decorator.decorators.MagicDecorator;
import by.it.akhmelev.jd02_06.p05_decorator.decorators.ColorDecorator;
import by.it.akhmelev.jd02_06.p05_decorator.objects.Ork;
import by.it.akhmelev.jd02_06.p05_decorator.objects.Unit;
import by.it.akhmelev.jd02_06.p05_decorator.objects.Soldier;
import by.it.akhmelev.jd02_06.p05_decorator.objects.Rider;

public class Start {


    public static void main(String[] args) {

        Unit rider;
        Unit soldier;
        Unit ork;

        boolean showDecoration = Math.random()>0.5;
        if (!showDecoration){
            rider = new Rider();
            soldier = new Soldier();
            ork = new Ork();
        }else{
            rider = new MagicDecorator(new Rider());
            soldier = new MagicDecorator(new Soldier());
            ork = new ColorDecorator(new MagicDecorator(new Ork()));
        }

        rider.draw();
        soldier.draw();
        ork.draw();
        
        
    }

}
