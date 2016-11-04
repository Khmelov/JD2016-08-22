package by.it.shkantau.project.java;

import javax.servlet.http.HttpServletRequest;

class CmdError extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        return Actions.ERROR.action;
    }
}