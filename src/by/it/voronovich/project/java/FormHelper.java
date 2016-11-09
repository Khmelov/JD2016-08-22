package by.it.voronovich.project.java;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
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
        return (value!=null) && value.matches(pattern);
    }

    static boolean isPost(HttpServletRequest req) {
        return (req.getMethod()!=null && req.getMethod().equalsIgnoreCase("post"));
    }

    static String getString(HttpServletRequest req,
                            String parameter,
                            String pattern) throws ParseException {
        String value=req.getParameter(parameter);
        if (value != null) {
            if (value.matches(pattern))
                return value;
            else
                throw new ParseException("Incorrect String: "+parameter,0);
        }
        return null;
    }

    static int getInt(HttpServletRequest req,
                      String parameter) throws ParseException {
        String value=req.getParameter(parameter);
        if (value != null) {
            if (value.matches("[0-9-]+"))
            {return (Integer.parseInt(value));}
        }
        throw new ParseException("Incorrect String: "+parameter,0);
    }
}
