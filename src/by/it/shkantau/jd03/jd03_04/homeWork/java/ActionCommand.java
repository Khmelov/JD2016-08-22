package by.it.shkantau.jd03.jd03_04.homeWork.java;

import javax.servlet.http.HttpServletRequest;

interface ActionCommand {
    String execute(HttpServletRequest request);
}