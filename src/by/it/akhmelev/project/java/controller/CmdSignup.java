package by.it.akhmelev.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends Action{
    @Override
    Action execute(HttpServletRequest reg) {
        return Actions.LOGIN.action;
    }
}
