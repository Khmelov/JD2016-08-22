package by.it.akhmelev.jd02_06.p05_decorator.decorators;

import by.it.akhmelev.jd02_06.p05_decorator.objects.Unit;

public class ColorDecorator extends Decorator {
    public ColorDecorator(Unit component) {
        super(component);
    }
    @Override
    public void afterDraw() {
        System.out.println(" ... added color");
    }
}
