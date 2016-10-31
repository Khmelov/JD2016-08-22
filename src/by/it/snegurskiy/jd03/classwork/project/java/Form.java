package by.it.snegurskiy.jd03.classwork.project.java;

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

}
