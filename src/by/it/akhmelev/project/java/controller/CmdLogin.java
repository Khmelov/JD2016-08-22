package by.it.akhmelev.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CmdLogin extends Action{
    @Override
    Action execute(HttpServletRequest reg) {
        reg.setAttribute("message","Hello from login");
        return null;
    }
}
