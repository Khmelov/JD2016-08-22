package by.it.karpov.JD01_02;


import java.io.IOException;


public class Runner {
    public static void main(String[] args) throws IOException {
        String line = "15 43 111 156 66 232 987 44 853";
        int arr[] = Util.strToArray(line);
        String max = TaskA.getMax(arr);
        System.out.println(max);
        String min = TaskA.getMin(arr);
        System.out.println(min);
        //Задание 2
        double mean = TaskA.mean(arr);
        System.out.println("Числа меньше " + Math.round(mean) + ":");
        for (int i : arr) {
            if (i < mean) {
                System.out.println(i + " ");
            }
        }

        for (int i : arr) {
            if (TaskA.difNumb(i)) {
                System.out.println("Найдено число из разных цифр: " + i);
                break;
            }
        }
        TaskB b = new TaskB();
        b.make();
        b.printHor(1,25,5,5);
        b.Month();
    }
}
