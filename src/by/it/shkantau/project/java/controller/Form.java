package by.it.shkantau.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class Form {
    static String getString(HttpServletRequest req,
                            String parameter,
                            String pattern) throws ParseException {
        String value=req.getParameter(parameter);
        if (value!=null ) {
            if (value.matches(pattern)) {
                return value;
            }else {
                throw new ParseException("Incorrect String: "+parameter,0);
            }
        }else {
            throw new NullPointerException("Empty HttpRequest parameter " + parameter);
        }
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
