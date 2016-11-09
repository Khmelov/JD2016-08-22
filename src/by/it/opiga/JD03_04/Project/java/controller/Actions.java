package by.it.opiga.JD03_04.Project.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Actions {
    INDEX {{this.action=new CmdIndex();}},
    UPDATE {{this.action=new CmdUpdate();}},
    CREATEORDER {{this.action=new CmdCreateOrder();}},
    SIGNUP {{this.action=new CmdSignup();}},
    LOGIN {{this.action=new CmdLogin();}},
    LOGOUT {{this.action=new CmdLogout();}},
    ERROR  {{this.action=new CmdError();}},
    SHOWUSERS {{this.action = new CmdShowUsers();
    }};

protected Action action=null;

static Action defineFrom(HttpServletRequest req){
    Action result=Actions.INDEX.action;
    String cmdName = req.getParameter("command");
    if (cmdName!=null && !cmdName.isEmpty())
        try {
            result = Actions.valueOf(cmdName.toUpperCase()).action;
        } catch (IllegalArgumentException e) {
            result = Actions.ERROR.action;
        }
    return result;
}
}
