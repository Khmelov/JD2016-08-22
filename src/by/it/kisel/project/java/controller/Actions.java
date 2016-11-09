package by.it.kisel.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Actions {
    INDEX {{
        this.action = new CmdIndex();
    }},
    CREATEORDER {{
        this.action = new CmdCreateOrder();
    }},
    CREATESTATUS {{
        this.action = new CmdCreateStatus();
    }},
    SHOWPERSONS {{
        this.action = new CmdShowPersons();
    }},
    SHOWORDERS {{
        this.action = new CmdShowOrders();
    }},
    SHOWORDERSFORUSERS {{
        this.action = new CmdShowOrdersForUsers();
    }},
    SHOWSTATUS {{
        this.action = new CmdShowStatus();
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
    }},
    CREATEROOM {{
        this.action = new CmdCreateRoom();
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
