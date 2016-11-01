package by.it.dubatovka.project_helpdesk.java;


import javax.servlet.http.HttpServletRequest;

public enum Actions {
    PROFILE{{this.action=new CmdProfile();}},
    SHOWALLADS{{this.action=new CmdShowAllAds();}},
    CREATEAD {{this.action=new CmdCreateAd();}},
    SHOWUSERS {{this.action=new CmdShowUsers();}},
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
