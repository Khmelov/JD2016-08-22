package by.it.voronovich.JD01_08;

/**
 * @version 1.0
 * @author Voronovich Dmitry
 */

public class Main {

    public static void main(String[] args) {

        //Наследование Уровень А
        ExtramuralStudent student = new ExtramuralStudent();

        student.doSports();
        student.meetFriends();
        student.passExams();
        student.earnSomeMoney();
        student.study();
        student.rest();

        System.out.println(" ");
        //Статический полиморфизм Уровень B

        student.setPriseEducation(1100);
        student.getPriseEducation();
        System.out.println(student.toString());

        student.setPriseEducation(1000,0.1);
        student.getPriseEducation();
        System.out.println(student.toString());

        System.out.println(" ");
        //Динамический полиморфизм Уровень C простой вариант
        student.study();
        student.passExams();

        ExtramuralStudent student2 = new AnotherExtramuralStudent();
        student2.study();
        student2.passExams();

        System.out.println(" ");
        //Динамический полиморфизм Уровень C  вариант по-сложнее
        student.averageExamMark(9);

        student2.averageExamMark(1); //значение mark берется из класса ExtramuralSrudent ибо сработал метод super.getMark()

        System.out.println(" ");
        //есть еще неявный динамический полиморфизм с методом toString()
    }
}
