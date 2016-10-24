package by.it.akhmelev.jd03_04.java;

import javax.servlet.http.HttpServletRequest;
interface ActionCommand {
    String execute(HttpServletRequest request);
}