package by.it.kisel.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

class Form {
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

    static double getDouble(HttpServletRequest req,
                            String parameter) throws ParseException {
        String value = req.getParameter(parameter);
        if (value != null) {
            if (value.matches("[.,0-9-]+")) {
                return (Double.parseDouble(value));
            }
        }
        throw new ParseException("Incorrect String: " + parameter, 0);
    }
    static boolean isPost(HttpServletRequest req) {
        return (req.getMethod()!=null && req.getMethod().equalsIgnoreCase("post"));
        }
    }
