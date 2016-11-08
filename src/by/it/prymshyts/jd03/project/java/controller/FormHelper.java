package by.it.prymshyts.jd03.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Enumeration;

class FormHelper {

    static String getString(HttpServletRequest req,
                            String parameter,
                            String pattern) throws ParseException {
        String value=req.getParameter(parameter);
        if (value != null) {
            if (value.matches(pattern))
                return value;
            else
                throw new ParseException("Incorrect String: " + parameter,0);
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
        throw new ParseException("Incorrect String: " + parameter,0);
    }

    static double getDouble(HttpServletRequest req,
                            String parameter) throws ParseException {
        String value=req.getParameter(parameter);
        if (value != null) {
            if (value.matches("[.,0-9-]+"))
            {return (Double.parseDouble(value));}
        }
        throw new ParseException("Incorrect String: " + parameter,0);
    }

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

    static boolean valid(String value){
        String defaultPattern=".*";
        return valid(value,defaultPattern);
    }

    private static boolean valid(String value,String pattern){
        return (value!=null) && value.matches(pattern);
    }

    static boolean isPost(HttpServletRequest request) {
        String method = request.getMethod();
        return method != null && method.equalsIgnoreCase("post");
    }
}
