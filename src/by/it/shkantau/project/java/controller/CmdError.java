package by.it.shkantau.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CmdError extends Action {

    @Override
    Action execute(HttpServletRequest request, HttpServletResponse response) {
        return Actions.ERROR.action;
    }
}