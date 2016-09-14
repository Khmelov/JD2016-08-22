package by.it.voronovich.JD01_08;

/**
 * @version 1.0
 * @author Voronovich Dmitry
 */

public abstract class Student implements IEnrollee {

    private double discount;
    private double priseEducation;

    public void setPriseEducation(double priseEducation) {
        this.priseEducation = priseEducation;
    }
    //переопределим метод сеттера
    public void setPriseEducation(double priseEducation, double discount) {
        this.priseEducation = priseEducation;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getPriseEducation() {
        double result = 0;
        result = this.priseEducation *(1-this.discount);
        return result;
    }
    @Override
    public void study() {
        System.out.println("Учусь!");
    }

    @Override
    public void rest() {
        System.out.println("Отдыхаю...");
    }

    @Override
    public void earnSomeMoney() {
        System.out.println("Подработка...");
    }

    @Override
    public void passExams() {
        System.out.println("Сдаю экзамены :(");
    }

    @Override
    public void doSports() {
        System.out.println("Занимаюсь спортом!");
    }

    @Override
    public void meetFriends() {
        System.out.println("Встречаюсь с друзьями!");
    }

}
