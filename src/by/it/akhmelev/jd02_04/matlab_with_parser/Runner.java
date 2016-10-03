package by.it.akhmelev.jd02_04.matlab_with_parser;

import by.it.akhmelev.jd02_04.matlab_with_parser.vars.Var;

import java.util.Scanner;

public class Runner {

    private static void printOneVar(Var v){
        if (v!=null) System.out.println(v);
    }
    public static void main(String[ ] args) {

        Scanner scanner=new Scanner(System.in);
        String line;
        Parser parser=new Parser();
        while ((line=scanner.nextLine())!=null){
            if (line.toLowerCase().equals("exit"))
                System.exit(0);
            Var var=parser.calc(line);
            System.out.println(var);
        }

        /*
        Нужно это перенести в тесты. Комментируем это.

        //вместо парсера ввода в DEMO использовано создание готовых объектов из строк
        //в реальном решении еще нужно программно определить тип объекта
        System.out.println("\nпроверка + - * / операций со скалярами");
        printOneVar(new VarF("1").add(new VarF("2")));
        printOneVar(new VarF("9").sub(new VarF("7")));
        printOneVar(new VarF("1.5").mul(new VarF("2")));
        printOneVar(new VarF("-4").div(new VarF("-1")));

        String vec="{1,2,3}";
        System.out.println("\nпроверка  + - * / операций с векторами справа и скалярами слева");
        printOneVar(new VarV(vec).add(new VarF("2")));
        printOneVar(new VarV(vec).sub(new VarF("1")));
        printOneVar(new VarV(vec).mul(new VarF("2")));
        printOneVar(new VarV(vec).div(new VarF("1")));

        System.out.println("\nпроверка  + - * / операций со скалярами справа и векторами слева");
        printOneVar(new VarF("1").add(new VarV(vec)));
        printOneVar(new VarF("2").sub(new VarV(vec)));
        printOneVar(new VarF("1").mul(new VarV(vec)));
        printOneVar(new VarF("2").div(new VarV(vec)));

        System.out.println("\nпроверка  + - * / операций с двумя векторами");
        printOneVar(new VarV(vec).add(new VarV(vec)));
        printOneVar(new VarV(vec).sub(new VarV(vec)));
        printOneVar(new VarV(vec).mul(new VarV(vec)));
        printOneVar(new VarV(vec).div(new VarV(vec)));

        System.out.println("\nпроверка  + - * /  операций с матрицей и вектором (не реализовано)");
        printOneVar(new VarM("").add(new VarV(vec)));
        printOneVar(new VarM("").sub(new VarV(vec)));
        printOneVar(new VarM("").mul(new VarV(vec)));
        printOneVar(new VarM("").div(new VarV(vec)));
        */

    }

}
