package by.it.prymshyts.jd03.project.java.controller;

import javax.servlet.http.HttpServletRequest;

interface ActionCommand {
    String execute(HttpServletRequest request);
}