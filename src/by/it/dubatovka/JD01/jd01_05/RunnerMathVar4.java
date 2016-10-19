package by.it.dubatovka.JD01.jd01_05;

/**
 * Created by Sergey Dubatovka on 06.09.2016.
 */
public class RunnerMathVar4 {
    public static void main(String[] args) {

        double a = -3.45;
        double b = 349.1;
        //Вариант 4. Задачя 1
        System.out.println("Вариант 4.");
        System.out.println("1.1 Разбивка по частям.");
        System.out.println(Task_1.task11(a, b));
        System.out.println();

        System.out.println("1.2  Полное выражение:");
        System.out.println(Task_1.task12(a, b));
        System.out.println("----------------------------------------");
        System.out.println();

        //Задача 2.
        System.out.println("2. Задание №2:");
        System.out.println(Task_2.task2(3.24, 5.8));
        System.out.println();

        //Задача 3.
        System.out.println("3. Задание №3:");
        Task_3.task3();
        System.out.println();

        //Задача 4.
        System.out.println("4. Задание №4:");
        Task_4.task_4();
        System.out.println();

        //Задача 5.
        System.out.println("5. Задание №5:");
        Task_5.task_5();
        System.out.println();

        //Задача 6.
        System.out.println("6. Задание №6:");
        double z[] = Task_6.get_Array();
        Task_6 task_6 = new Task_6();

        task_6.print_Array(z, "Массив z[i]=e^|2b+1|, b(-2;2), шаг 0,2:");
        double c[] = task_6.get_EveryThirdElement(z);
        task_6.print_Array(c, "Массив с[] - составлен из элементов, имеющих нечетные индексы массива z[], которые <3");

        System.out.println("Произведение элементов, имеющих нечетные индексы массива z[], которые <3:");
        System.out.println("Результат= " + task_6.proizvedenieElemArray(c));
    }
}
