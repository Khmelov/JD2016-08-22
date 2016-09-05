package by.it.snegurskiy.jd01_05;

/**
 * Created by user on 05.09.2016.
 */
public class Runner05 {

    public static void main(String[] args) {

        //Task1
        System.out.println("Task1");
        double x = 1.26453;
        System.out.println(Task1.optionA(x));
        System.out.println(Task1.optionB(x));


        //Task2
        System.out.println("Task2");
        System.out.println(Task2.calculate(0.3, -21.17));

        //Task3
        System.out.println("Task3");
        Task3.printTable();

        //Task4
        System.out.println("Task4");
        System.out.println(Task4.calculate(2.408));

        //Task5
        System.out.println("Task5");
        Task5.calculate();

        //Task6
        System.out.println("Task6");
        double a[] = Task6.getArray();
        Task6 task6 = new Task6();
        task6.printArray(a, "testname", true);
        double b[] = task6.getEveryThirdElement(a);
        task6.printArray(b, "array", true);
    }


    }

