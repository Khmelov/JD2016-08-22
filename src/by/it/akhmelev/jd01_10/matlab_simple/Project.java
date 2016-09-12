package by.it.akhmelev.jd01_10.matlab_simple;

public class Project {
    //это основной класс учебного проекта, поэтому нужно добавить
    public static void main(String[ ] args) {
    //проверяем сложение
        Variable one=new Variable("2.2");
        Variable two=new Variable("3.3");
    //создадим результат сложения
        Variable res=one.add(two);
    //проверим, работает ли проектик
        System.out.print(one+"+"+two+"="+res);
    }

}
