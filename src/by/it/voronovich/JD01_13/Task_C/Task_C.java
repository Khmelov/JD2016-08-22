package by.it.voronovich.JD01_13.Task_C;

import by.it.voronovich.JD01_08.Student;
import by.it.voronovich.JD01_08.ExtramuralStudent;
import by.it.voronovich.JD01_08.AnotherExtramuralStudent;

public class Task_C {

    public static void main(String[] args) {
        Student student = new AnotherExtramuralStudent();

        try {
            student.setPriseEducation(1000);
            if (student.getPriseEducation() < 700) {
                System.out.println(student.toString());
            } else throw new Exception("У студента нету столько денег за обучение, нужно снизить стоимость...");
        } catch(Exception e){
            System.err.print(e.getMessage());
        }
    }
}
