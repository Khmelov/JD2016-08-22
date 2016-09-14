package by.it.voronovich.JD01_08;

/**
 * @version 1.0
 * @author Voronovich Dmitry
 */

public class ExtramuralStudent extends Student {

    private double mark = 7;

    @Override
    public String toString() { // динамический полиморфизм
        return "Стоимость обучения с учетом скидки " + (super.getDiscount() * 100) + " процентов, составляет " + super.getPriseEducation();
    }

    public void averageExamMark(double mark) {
        this.mark = mark;
        System.out.println("Моя средняя оценка: " + mark);
    }

    public double getMark() {
        return mark;
    }
}
