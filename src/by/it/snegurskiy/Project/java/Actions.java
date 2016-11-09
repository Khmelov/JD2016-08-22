package by.it.snegurskiy.Project.java;


import javax.servlet.http.HttpServletRequest;

enum Actions {
    PUTMONEY {{
        this.action = new CommandPutMoney();
    }},
    NEWPAY {{
        this.action = new CommandNewPay();
    }},
    UNBLOCK {{
        this.action = new CommandUnBlock();
    }},
    BLOCK {{
        this.action = new CommandBlock();
    }},
    MAINUSER {{
        this.action = new CommandMainUser();
    }},
    MAINADMIN {{
        this.action = new CommandMainAdmin();
    }},

    SIGNUP {{
        this.action = new CommandSignUp();
    }},
    LOGIN {{
        this.action = new CommandLogin();
    }},

    ERROR {{
        this.action = new CommandError();
    }};

    protected Action action = null;

    static Action defineFrom(HttpServletRequest req) {
        Action result=Actions.LOGIN.action;
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