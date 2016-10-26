package by.it.akhmelev.project.java;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

class FormHelper {
    //этот класс для чтения и валидации данных в форме
    //этот метод для отладки. Он покажет в виде текста, что пришло из формы
    static String strDebugForm(HttpServletRequest request) {
        String formText = "";
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String field = parameterNames.nextElement();
            String value = request.getParameter(field);
            formText = formText.concat(field + "=" + value + "; ");
        }
        return formText;
    }
    //валидация данных из формы с шаблоном по умолчанию
    static boolean valid(String value){
        String defaultPattern=".*";
        return valid(value,defaultPattern);
    }

    //валидация данных из формы с заданным шаблоном
    private static boolean valid(String value,String pattern){
        //проверка на внимательность (для определения, вы просто копируете код или читаете)
        //тут же явно не все, нужно проврить не просто вхождение паттерна в строку
        //а полное соответствие всей строки шаблону. Доделайте.
        return (value!=null) && value.matches(pattern);
    }
}
