package by.it.prymshyts.jd01.jd01_05;

public class Runner {

    public static void main(String[] args) {

        //1
        System.out.println("Задание 1:");
        System.out.println("Вариант 1 = " + Task1.optionA());
        System.out.println("Вариант 2 = " + Task1.optionB());
        System.out.println();

        //2
        System.out.println("Задание 2:");
        System.out.println(Task2.calculate());
        System.out.println();

        //3
        System.out.println("Задание 3:");
        Task3.printTable();
        System.out.println();

        //4
        System.out.println("Задание 4:");
        System.out.println(Task4.calculate());
        System.out.println();

        //5
        System.out.println("Задание 5:");
        Task5.calculate();
        System.out.println();

        //6
        System.out.println("Задание 6:");

        double[] array = Task6.getArray(30);
        System.out.println("Изначальный массив:");
        Task6.printArray(array, "arr");

        double[] newArray = Task6.getNewArray(array);
        System.out.println("Новый массив:");
        Task6.printArray(newArray, "arr");

        System.out.println("Среднее геометрическое значение нового массива = " + Task6.getGeometricMean(newArray) + "\n");

        //7
        System.out.println("Задание 7:");

        int[] A = Task7.getArrayA();
        int[] B = Task7.getArrayB(A);

        System.out.println("Массив А:");
        Task7.printArrayA(A);
        System.out.println("Массив В:");
        Task7.printArrayB(B);

        //Дополнительное
        System.out.println("Дополнительное задание (все метода класса Math):\n");
        Extra.getMathMethods();
    }
}
