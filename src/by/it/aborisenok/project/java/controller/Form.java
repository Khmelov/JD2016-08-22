package by.it.aborisenok.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

class Form {

    static boolean isPost(HttpServletRequest req) {
        return (req.getMethod()!=null && req.getMethod().equalsIgnoreCase("post"));
        }
    }
