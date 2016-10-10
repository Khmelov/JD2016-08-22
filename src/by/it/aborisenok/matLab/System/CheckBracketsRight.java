package by.it.aborisenok.matLab.System;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by aborisenok on 07.10.2016.
 */
public class CheckBracketsRight {
    {
        System.out.println("***TaskC3");
        String correct = "((){}[()])";
        String wrong = "({}[({)])";
        System.out.println("Правильный вариант:" + correct);
        checkBrackets(correct);
        System.out.println("Неправильный вариант:" + wrong);
        checkBrackets(wrong);
    }

    /**
     * Метод служит для определения корректности расстановки скобок в выражениях
     * Этот метод можно использовать для проверки правильности ввода выражения в MathLab
     * @param expression входное выражение типа String
     */
    public static boolean checkBrackets(String expression){
        // список вариантов скобок используемых в выражении
        String variants = "({[]})";
        // создаём список вариантов корректного закрытия скобок
        ArrayList<String> combination = new ArrayList<>();
        combination.add("()");
        combination.add("{}");
        combination.add("[]");
        // создаём стек для хранения последовательности скобок
        Stack<String> stack = new Stack<>();
        // проходимся по символам переданного в метод выражения
        for (int i = 0; i < expression.length(); i++) {
            String charValue = String.valueOf(expression.charAt(i)); // приводим i-ый символ к строке
            // проверяем является ли символ вариантом скобок
            if (variants.contains(charValue)){
                // проверяем не пустой ли наш stack, если пустой то добавляем в него скобку
                if (!stack.isEmpty()){
                    // проверяем образуют ли последний добавленный элемент в стеке и
                    // i-ая скобка из переданного выражения комбинацию закрытых скобок,
                    // которые определены а списке combination
                    if (combination.contains(stack.peek()+charValue)){
                        stack.pop(); // если содержатся, то удаляем последний элемента steck
                    } else {
                        stack.add(charValue); // если нет, то добавляем скобку в стек
                    }
                }else {
                    stack.add(charValue);
                }
            }
        }
        // если скобок в stack не осталось, значит каждая открывающая скобка имела закрывающую
        // иначе скобки были расставленны некоректно
        if (stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
