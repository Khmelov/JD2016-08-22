package by.it.grechishnikov.matLab.controller;


import by.it.grechishnikov.matLab.model.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private IReadable reader;

    public Parser(IReadable reader) {
        this.reader = reader;
    }

    public void run() {
        String text = reader.readValue();
        parse(text);
    }

    private String parse(String text) {
        if(text.isEmpty()) {
            System.out.println("Ошибка. Пустая строка.");
            return null;
        }
        String name = text.substring(0, 1);
        String equation = text.substring(text.indexOf("=") + 1);
        equation = equation.trim();
        String[] arg = equation.split("[-+*/ ]+");
        Queue<Var> queue = new ConcurrentLinkedQueue<>();
        for (String s : arg) {
            try {
                double d = Double.parseDouble(s);
                Scalar scalar = new Scalar(name, d);
                queue.add(scalar);
            } catch (NumberFormatException e) {
                try {
                    queue.add(Runner.storage.get(s));
                } catch (NullPointerException e2) {
                    System.out.println("Ошибка. Нет такого объекта в памяти.");
                    return null;
                }
            }
        }
        Pattern pattern = Pattern.compile("[-+*/]+");
        Matcher matcher = pattern.matcher(equation);
        String[] arr = new String[100];
        for (int i = 0; i < arr.length; i++) {
            if(matcher.find()) {
                arr[i] = matcher.group();
            } else break;
        }
        Var first = queue.poll();
        int count = 0;
        for (Var second : queue) {
            String s = arr[count];
            if(s.equals("+")) {
                first = Runner.operation.add(name, first, second);
            } else if(s.equals("-")) {
                first = Runner.operation.sub(name, first, second);
            } else if(s.equals("*")) {
                first = Runner.operation.mul(name, first, second);
            } else if (s.equals("/")) {
                first = Runner.operation.div(name, first, second);
            }
            count++;
        }
        first.assign();
        return first.toString();
    }

}
