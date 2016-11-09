package by.it.zaharova.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Actions {
    INDEX {{
        this.action = new CmdIndex();
    }},
    SHOWPATIENTS {{
        this.action = new CmdShowPatients();
    }},
    CREATEDIAGNOSTIC {{
        this.action = new CmdCreateDiagnostic();
    }},
    SHOWDIAGNOSTIC {{
        this.action = new CmdShowDiagnostic();
    }},
    SHOWDOCTORSFORPATIENTS {{
        this.action = new CmdShowDoctorsForPatients();
    }},
    SIGNUP {{
        this.action = new CmdSignup();
    }},
    LOGIN {{
        this.action = new CmdLogin();
    }},
    LOGOUT {{
        this.action = new CmdLogOut();
    }},
    PROFILE {{
        this.action = new CmdProfile();
    }},
    ERROR {{
        this.action = new CmdError();
    }};

    protected Action action = null;

    static Action defineFrom(HttpServletRequest req) {
        Action result = Actions.INDEX.action;
        String cmdName = req.getParameter("command");
        if (cmdName != null && !cmdName.isEmpty())
            try {
                result = Actions.valueOf(cmdName.toUpperCase()).action;
            } catch (IllegalArgumentException e) {
                result = Actions.ERROR.action;
            }
        return result;
    }

}
