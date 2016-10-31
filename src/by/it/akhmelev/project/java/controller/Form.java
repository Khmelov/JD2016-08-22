package by.it.akhmelev.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class Form {
    static String getString(HttpServletRequest req,
                            String parameter,
                            String pattern) throws ParseException {
        String value=req.getParameter(parameter);
        if (value!=null & value.matches(pattern))
            return value;
        else
            throw new ParseException("Incorrect String: "+parameter,0);
    }

    static boolean isPost(HttpServletRequest req){
        String method=req.getMethod();
        return method!=null && method.equalsIgnoreCase("post");
    }


}
