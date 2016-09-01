package by.it.akhmelev.jd01_02;

class TaskA {
    //метод поиска самого длинного элемента и его длины
    //результат - строка для вывода на консоль
    static String getMax(int array[]) {
        Integer res = 0;               //самое короткое число
        for (Integer i : array) {
            if (res.toString().length() < i.toString().length()) {
                res = i;
            }
        }
        return "MAX=" + res.toString() + " length=" + res.toString().length();
    }


    //метод поиска самого короткого элемента и его длины
    //результат - строка для вывода на консоль
    static String getMin(int array[]) {
        Integer res = Integer.MIN_VALUE; //самое длинное число
        for (Integer i : array) {
            if (res.toString().length() > i.toString().length()) {
                res = i;
            }
        }
        return "MIN=" + res.toString() + " length=" + res.toString().length();
    }

    //метод вычисления среднего арифметического
    static double mean(int array[]) {
        double res = 0;
        //все сложить
        for (int i : array) res = res + i; //можно и так: res+=i;
        //найти среднее
        res = res / array.length;          //можно и так: res/=array.length;
        return res;
    }

    //метод поиска числа, состоящего из разных цифр
    static boolean uniqueDigits(Integer value){
        char ch[]=value.toString().toCharArray();
        for (int i=0;i<ch.length;i++)
            for (int j=i+1;j<ch.length;j++)
                if (ch[i]==ch[j]) return false;
        //если не попалось одинаковых цифр, то они все разные
        return true;
    }



}










