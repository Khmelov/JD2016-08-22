package by.it.akhmelev.jd02_04.matlab_with_parser;

import by.it.akhmelev.jd02_04.matlab_with_parser.vars.Var;
import by.it.akhmelev.jd02_04.matlab_with_parser.vars.VarF;
import by.it.akhmelev.jd02_04.matlab_with_parser.vars.VarM;
import by.it.akhmelev.jd02_04.matlab_with_parser.vars.VarV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final String[] levelOperation = {"=", "+", "-", "*", "/"};   //таблица приоритетов операций
    private ArrayList<String> strVar=new ArrayList<>();                  //переменные
    private ArrayList<String> operation=new ArrayList<>();               //операции

    public Var getResult() {
        return result;
    }

    private Var result;

    private void debug(){
        System.out.print("debug: "+strVar.get(0));
        int i=0;
        for (String op: operation) {
            System.out.print(op+strVar.get(++i));
        }
        System.out.println();
    }

    private int getPrioritet(String oneOperation) {
        int result = -1;
        for (int j = 0; j < levelOperation.length; j++) {
            if (oneOperation.equals(levelOperation[j]) && result < j)
                result = j;
        }
        return result;
    }

    private int findOpNumber() { //ищет самую приоритетную операцию (ее номер в массиве)
        int result = -1;
        int bestLevel=-1;
        for (int i = 0; i < operation.size(); i++) {
            int iLevel=getPrioritet(operation.get(i));
            if (iLevel > bestLevel)
            {
                bestLevel=iLevel;
                result = i;
            }
        }
        return result;
    }

    private Var parseOneVar(String strVar) { //находит одну переменную
        if (strVar.matches(Patterns.exMat)) return new VarM(strVar);
        else if (strVar.matches(Patterns.exVec)) return new VarV(strVar);
        else if (strVar.matches(Patterns.exVal)) return new VarF(strVar);
        else return null;
    }

    private void oneOperation(int number) { //выполняет одну операцию

        Var result=null;
        String oper=operation.get(number);
        Var one=parseOneVar(strVar.get(number));
        assert one != null;
        Var two=parseOneVar(strVar.get(number+1));
        assert two != null;
        if (oper.equals("+")) result=one.add(two);
        if (oper.equals("-")) result=one.sub(two);
        if (oper.equals("*")) result=one.mul(two);
        if (oper.equals("/")) result=one.div(two);
        operation.remove(number);
        strVar.remove(number);
        strVar.set(number, String.valueOf(result));
    }

    public Var calc(String str) {
        //временная замена минусов на свой вариант
        //A=6*-4
        str = str.replaceAll("\\+-", "+MINUS");
        str = str.replaceAll("\\*-", "*MINUS");
        str = str.replaceAll("--", "-MINUS");
        str = str.replaceAll("/-", "/MINUS");

        //удаление всех пробелов и пробельных символов
        str = str.replaceAll("\\s", "");

        //разбор выражения на отдельные операции и операнды

        String[] vars=str.split(Patterns.exOperation);
        //возвращаем минусы "на родину"
        for (int i = 0; i < vars.length; i++) {
            vars[i]=vars[i].replace("MINUS","-");
        }
        //создаем коллекцию переменных в виде строк
        strVar = new ArrayList<>(Arrays.asList(vars));

        //создаем коллекцию операций в виде строк
        Pattern p = Pattern.compile(Patterns.exOperation);
        Matcher matcher = p.matcher(str);
        while (matcher.find()) {
            String op=matcher.group(0);
            operation.add(op);
        }


        while (operation.size() > 0) {
            int i = findOpNumber(); //нашли наиболее высокоприоритетную операцию
            //debug();
            oneOperation(i); //выполнили ее
        }

        //операций больше нет. возвращаем итог расчетов
        result = parseOneVar(strVar.get(0));

        return result;
    }
}
