package by.it.grechishnikov.matLab.controller;


import by.it.grechishnikov.matLab.model.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
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
            Pattern pattern = Pattern.compile("[0-9. ]+[*/ ][0-9. ]+");
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
                Pattern pattern = Pattern.compile("[0-9. ]+[-+ ][0-9. ]+");
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
        Pattern pattern = Pattern.compile("[0-9.]+");
        Matcher matcher = pattern.matcher(inner);
        matcher.find();
        double first = Double.parseDouble(matcher.group());
        matcher.find();
        double second = Double.parseDouble(matcher.group());
        if(inner.contains("*")) {
            return String.valueOf(first * second);
        } else if(inner.contains("/")) {
            return String.valueOf(first / second);
        } else if(inner.contains("+")) {
            return String.valueOf(first + second);
        } else if(inner.contains("-")) {
            return String.valueOf(first - second);
        }
        return null;
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
