package by.it.grechishnikov.matLab.controller;


import by.it.grechishnikov.matLab.controller.operation.*;
import by.it.grechishnikov.matLab.model.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private Operation operation = new Operation();
    private String name = "";

    /**
     * Запускаем парсер
     * @param text - строка для парсинга
     * @return - возвращаем распарсенное уравнение в виде строки
     */
    public String run(String text) {
        Var var = parse(text);
        var.assign();
        name = "";
        return var.toString();
    }

    /**
     * Одному богу известно, что тут происходит
     * @param text - уравнение
     * @return - чудесным образом полученная переменная
     */
    private Var parse(String text) {
        if (text.isEmpty()) {
            System.out.println("Ошибка. Пустая строка.");
            return null;
        }
        name = getName(text);
        //получаем уравнение
        String equation = getEquation(text);
        //раскрываем скобки
        while(equation.contains("(")) {
            Pattern pattern = Pattern.compile("[(][0-9. +*/a-zA-Z-]+[)]");
            Matcher matcher = pattern.matcher(equation);
            matcher.find();
            String inner = matcher.group();
            String tmp = inner.replaceAll("[()]", "");
            Var var = parse(tmp);
            equation = equation.replace(inner, var.valueToString());
        }
        //загружаем переменные
        while(true) {
            try {
                Pattern pattern = Pattern.compile("[a-zA-Z]");
                Matcher matcher = pattern.matcher(equation);
                matcher.find();
                String inner = matcher.group();
                Var var = Runner.storage.get(inner);
                equation = equation.replace(inner, var.valueToString());
            } catch (Exception e) {
                break;
            }
        }
        //делаем умножение и деление
        while(equation.contains("*") || equation.contains("/")) {
            Pattern pattern = Pattern.compile("[0-9. {},]+[*/ ][0-9. {},]+");
            Matcher matcher = pattern.matcher(equation);
            matcher.find();
            String inner = matcher.group();
            equation = equation.replace(inner, calculate(inner));
        }
        //делаем сложение и вычитание
        while(true) {
            try {
                return new Scalar(name, Double.parseDouble(equation));
            } catch (Exception e) {
                Pattern pattern = Pattern.compile("[0-9. {},]+[-+ ][0-9. {},]++");
                Matcher matcher = pattern.matcher(equation);
                matcher.find();
                String inner = matcher.group();
                equation = equation.replace(inner, calculate(inner));
            }
        }
    }

    /**
     * Производим математические действия
     * @param inner - текст для парсинга
     * @return - результат умножения(деления, суммы, разницы)
     */
    private String calculate(String inner) {
        Pattern pattern = Pattern.compile("[0-9. {},]+");
        Matcher matcher = pattern.matcher(inner);
        matcher.find();
        String first = matcher.group();
        Var v1;
        if(first.contains("{")) {
            double[] arr = parseArray(first);
            v1 = new Vector(name, arr);
        } else {
            v1 = new Scalar(name, Double.parseDouble(first));
        }
        matcher.find();
        String second = matcher.group();
        Var v2;
        if(second.contains("{")) {
            double[] arr = parseArray(second);
            v2 = new Vector(name, arr);
        } else {
            v2 = new Scalar(Double.parseDouble(second));
        }

        if(inner.contains("*")) {
            return operation.mul(name, v1, v2).valueToString();
        } else if(inner.contains("/")) {
            return operation.div(name, v1, v2).valueToString();
        } else if(inner.contains("+")) {
            return operation.add(name, v1, v2).valueToString();
        } else if(inner.contains("-")) {
            return operation.sub(name, v1, v2).valueToString();
        }
        return null;
    }

    private double[] parseArray(String first) {
        Pattern pattern = Pattern.compile("[0-9. ]+");
        Matcher matcher = pattern.matcher(first);

        return new double[0];
    }

    /**
     * Находим имя переменной в уравнении
     * @param text - уравнение
     * @return - возвращаем имя
     */
    private String getName(String text) {
        if(name.isEmpty()) {
            name = text.substring(0, text.indexOf("="));
        }
        return name;
    }

    /**
     * Возвращает правую часть уравнения
     * @param text - все уравнение
     * @return - правая часть уравнения
     */
    private String getEquation(String text) {
        if(!text.contains("=")) {
            return text;
        } else {
            String equation = text.substring(text.indexOf("=") + 1);
            equation = equation.trim();
            return equation;
        }
    }
}
