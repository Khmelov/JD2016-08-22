package by.it.akhmelev.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Actions {
SIGNUP {{this.action=new CmdSignup();}},
LOGIN {{this.action=new CmdLogin();}},
LOGOUT {{this.action=new CmdLogout();}},
ERROR  {{this.action=new CmdError();}};

protected Action action=null;

static Action defineFrom(HttpServletRequest req){
    Action result;
    String cmdName = req.getParameter("command").toUpperCase();
    try {
        result=Actions.valueOf(cmdName).action;
    }
    catch (IllegalArgumentException e) {
        result=Actions.ERROR.action;
    }
    return result;
}

}
