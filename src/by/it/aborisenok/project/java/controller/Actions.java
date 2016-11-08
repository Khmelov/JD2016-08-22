package by.it.aborisenok.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Actions {

    INDEX {{
        this.action = new CmdIndex();
    }},
    SIGNIN {{
        this.action = new CmdSignin();
    }},
    SIGNUP {{
        this.action = new CmdSignup();
    }},
    SIGNOUT {{
        this.action = new CmdSignout();
    }},
    TAKETALON {{
        this.action = new CmdTakeTalon();
    }},
    BOOKINGSTEP1 {{
        this.action = new CmdBookingStep1();
    }},
    BOOKINGSTEP2 {{
        this.action = new CmdBookingStep2();
    }},
    BOOKINGSTEP3 {{
        this.action = new CmdBookingStep3();
    }},
    BOOKINGSTEP4 {{
        this.action = new CmdBookingStep4();
    }},
    GETTALON {{
        this.action = new CmdGetTalon();
    }},
    MYTALON {{
        this.action = new CmdMyTalon();
    }},
    DOWNLOAD {{
        this.action = new CmdDownload();
    }},
    DELETE {{
        this.action = new CmdDelete();
    }},
    ERROR {{
        this.action = new CmdError();
    }};

    protected Action action = null;

    static Action defineFrom(HttpServletRequest req) {
        Action result = null;
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
