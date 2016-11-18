package by.it.filimonchik.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Actions {
    INDEX {{
        this.action = new CmdIndex();
    }},
    CREATEAD {{
        this.action = new CmdCreateAd();
    }},
    SHOWUSERS {{
        this.action = new CmdShowUsers();
    }},
    SIGNUP {{
        this.action = new CmdSignup();
    }},
    LOGIN {{
        this.action = new CmdLogin();
    }},
    PROFILE {{
        this.action = new CmdProfile();
    }},
    ERROR {{
        this.action = new CmdError();
    }};

    protected Action action = null;

    static Action defineFrom(HttpServletRequest req) {
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
