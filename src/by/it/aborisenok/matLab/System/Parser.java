package by.it.aborisenok.matLab.System;

import by.it.aborisenok.matLab.Errors.IllegalFormatOfVariableException;
import by.it.aborisenok.matLab.Errors.UseOfUnknownVariableException;
import by.it.aborisenok.matLab.Vars.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aborisenok on 04.10.2016.
 */
public class Parser {

    private final String[] levelOperation = {"=", "+", "-", "*", "/"};   //таблица приоритетов операций
    private ArrayList<String> strVar=new ArrayList<>();                  //переменные
    private ArrayList<String> operation=new ArrayList<>();               //операции

    public Var getResult() {
        return result;
    }

    private Var result;

    private void debug(){
        System.out.print("debug: " + strVar.get(0));
        int i = 0;
        for (String op : operation) {
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
        return VarFactory.getVar(strVar);
    }

    private void oneOperation(int number) { //выполняет одну операцию
        Var result = null;
        String oper = operation.get(number);
        String oneStr = strVar.get(number);
        String twoStr = strVar.get(number+1);
        if (!oper.equals("=")){
            Var one = parseOneVar(oneStr);
            System.err.println();
            Var two = parseOneVar(twoStr);
            assert one != null;
            assert two != null;
            if (oper.equals("+")) result=one.add(two);
            if (oper.equals("-")) result=one.sub(two);
            if (oper.equals("*")) result=one.mul(two);
            if (oper.equals("/")) result=one.div(two);
        } else {
            Var two = parseOneVar(twoStr);
            if (two != null)
            result = two;
            HashMapper.setVeriable(oneStr, two);
        }
        operation.remove(number);
        strVar.remove(number);
        strVar.set(number, String.valueOf(result));
    }


    public Var doCalc(String str){
        if (!CheckBracketsRight.checkBrackets(str))
            throw new IllegalFormatOfVariableException("Неверная расстановка скобок");
        String s1 = str;
        Pattern p = Pattern.compile(Patterns.expInBrackets);
        Matcher matcher = p.matcher(s1);
        if (matcher.find()){
            String s2 = matcher.group(0);
            String s3 = s2.replaceAll("\\(","").replaceAll("\\)","");
            String s4 = calc(s3);
            String s5 = s1.replace(s2, s4);
            return doCalc(s5);
        }
          String s6 = calc(s1);
          Var var = parseOneVar(s6);
        return var;
    }

    public String calc(String str) {
        //временная замена минусов на свой вариант
        //A=6*-4

        String oper = str;
        str = str.replaceAll("\\+-", "+MINUS");
        str = str.replaceAll("\\*-", "*MINUS");
        str = str.replaceAll("--", "-MINUS");
        str = str.replaceAll("/-", "/MINUS");
        str = str.replaceAll("\\=-", "=MINUS");
        str = str.replaceAll(",-", ",MINUS");
        if (str.charAt(0)=='-'){
            str = str.replaceFirst("-", "MINUS");
        }
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
           // debug();
                oneOperation(i); //выполнили ее
        }

        WorkInformation.setFullOperation("Typing expressions " + oper + " = " + strVar.get(0));

        return strVar.get(0);
    }
}
