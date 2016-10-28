package by.it.akhmelev.project.java.old_demo;

import javax.servlet.http.HttpServletRequest;

interface ActionCommand {
    String execute(HttpServletRequest request);
}