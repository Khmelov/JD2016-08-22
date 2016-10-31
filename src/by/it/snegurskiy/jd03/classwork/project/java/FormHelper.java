package by.it.snegurskiy.jd03.classwork.project.java;

import by.it.snegurskiy.jd03.classwork.project.java.Bean.Users;
import by.it.snegurskiy.jd03.classwork.project.java.DAO.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

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
    static boolean valid(String value) {
        String defaultPattern = ".*";
        return valid(value, defaultPattern);
    }

    //валидация данных из формы с заданным шаблоном
    private static boolean valid(String value, String pattern) {
        //проверка на внимательность (для определения, вы просто копируете код или читаете)
        //тут же явно не все, нужно проврить не просто вхождение паттерна в строку
        //а полное соответствие всей строки шаблону. Доделайте.
        return (value != null) && value.matches(pattern);
    }

//    static boolean proverkaVbaze(String login, String password) {
//
//        boolean proverka;
//
//        DAO dao = DAO.getDAO();
//        List<Users> users = dao.user.getAll(String.format("where Login='%s' and Password='%s'", login, password));
//
//        if (users.contains(login) & users.contains(password)) proverka=true;
//        else proverka=false;
//
//
//
//        return proverka;
//    }
}