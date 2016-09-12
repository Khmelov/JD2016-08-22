package by.it.grechishnikov.jd01_02;

/**
 * Created by Evgeniy on 24.08.16.
 */
public class TaskA {
    public static void printMin(String[] arr) {
        //Ищем самое короткое число
        String min = arr[0];
        for(String s : arr) {
            if(min.length() > s.length()) {
                min = s;
            }
        }
        System.out.println("Самое короткое число = " + Integer.parseInt(min) + ", его длинна = " + min.length());
    }

    public static void printMax(String[] arr) {
        //Ищем самое длинное число
        String max = arr[0];
        for(String s : arr) {
            if(max.length() < s.length()) {
                max = s;
            }
        }
        System.out.println("Самое длинное число = " + Integer.parseInt(max) + ", его длинна = " + max.length());
    }

    public static void printMean(String[] arr) {
        //Печатаем числа, длинна которых меньше среднего арифметического
        double mean = mean(Util.getIntArr(arr));
        String result = "Числа, длинна которых меньше среднего арифметического: ";
        for(String s : arr) {
            if(s.length() < mean) {
                result += s + " ";
            }
        }
        System.out.println(result);
    }

    public static double mean(int[] arr) {
        //Поиск среднего арифметического
        double sum = 0;
        for(int i : arr) {
            sum += i;
        }
        double mean = sum / arr.length;
        System.out.println("Среднее арифметическое введеных чисел= " + mean);
        return mean;
    }

    public static void getUniqInt(String[] arr) {
        //Поиск уникального числа
        label: for(String s : arr) {
            String list = "";
            for(char c : s.toCharArray()) {
                if(!list.contains(String.valueOf(c))) {
                    list += c;
                }
                else {
                    continue label;// Переход на след. итерацию внешнего цикла, т.к. данное число не оказалось уникальным
                }
            }
            if(list.equals(s)) {
                System.out.println("Первое уникальное число = " + list);
                return;
            }
        }
    }
}
