package by.it.aborisenok.JD01_02;

public class Runner {

    public static void main(String[] args) {
        //прочитаем линию значений с клавиатуры.
        //String  line=InOut.getOneLine();
        String  line = "111 22 343 123 67 4 33 22 834 66";
        //получим массив чисел с которым будем работать:
        int arr[] = Util.lineToIntArray(line);
        //1. Найти самое короткое и самое длинное число.
        //   Вывести найденные числа и их длину.
        String max = TaskA.getMax(arr);
        System.out.println(max);
        String min = TaskA.getMin(arr);
        System.out.println(min);

        //2. Вывести на консоль те числа, длина которых меньше
        //   (больше) средней.
        double mean=TaskA.mean(arr);
        System.out.print("Числа меньше "+mean+" таковы: ");
        for (int i:arr) {
            if (i<mean) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
        //3. Найти число, состоящее только из различных цифр.
        //Если таких чисел несколько, найти первое из них.
        for (int i:arr) {
            if (TaskA.uniqueDigits(i)) {
                System.out.print("Найдено число из разных цифр: "+i);
                break; //больше ничего не ищем
            }
        }


    }
}
