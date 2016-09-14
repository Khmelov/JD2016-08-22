package by.it.voronovich.JD01_08;

/**
 * @version 1.0
 * @author Voronovich Dmitry
 */

public class AnotherExtramuralStudent extends ExtramuralStudent{

    @Override
    public void study() {
        System.out.println("Учусь в поте лица...");
    }

    @Override
    public void passExams() {
        System.out.println("Опять сдаю экзамены...");;
    }

    @Override
    public void averageExamMark(double mark) {
        System.out.println("А вот моя средняя оценка: " + super.getMark());
    }
}

