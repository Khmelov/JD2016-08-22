package by.it.shkantau.jd01.jd01_05;

public class Runner_JD05 {
    public static void main(String[] args) {
//        System.out.println("Task1.1 z=" + Task1.task1(756.13, 0.3));
//        System.out.println("Task1.2 z=" +  Task1.task2(756.13, 0.3));
//        System.out.println("Task2 y=" + Task2.task2(0.3, -21.17));
//        Task3.task3(2,3,0.1);
//        Task4.task4('*', 2, 3, 0.1);
//        Task5.calculate();

        double [] array = Task6.task6(20,  5.33, 9);
        Task6.printArray(array, "Full array");
        Task6.printArray(Task6.trimArrayToValue(array , 3.5), "Trim to " + 3.5 + " array");
        System.out.println("Geometric mean = " + Task6.getGeometricMean(array));
    }
}
