package by.it.akhmelev.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Actions {
INDEX {{this.action=new CmdIndex();}},
SHOWUSERS {{this.action=new CmdShowUsers();}},
SIGNUP {{this.action=new CmdSignup();}},
LOGIN {{this.action=new CmdLogin();}},
PROFILE {{this.action=new CmdProfile();}},
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
