package by.it.voronovich.project.java;

enum Action {
    SIGNUP {
        {
            this.command = new CommandSignUp();
            this.inPage="/signup.jsp";
            this.okPage ="/login.jsp";
        }
    },
    LOGIN {
        {
            this.command = new CommandLogin();
            this.inPage="/login.jsp";
            this.okPage ="/main.jsp";
        }
    },
    PROFILE{
        {
            this.command = new CommandProfile();
            this.inPage="/profile.jsp";
            this.okPage ="/login.jsp";
        }
    },
    ERROR {
        {
            this.command = new CommandError();
            this.inPage="/error.jsp";
        }
    },
    SHOWORDER {
        {
            this.command = new CommandShowOrder();
            this.inPage ="/showorder.jsp";
            this.okPage ="/main.jsp";
        }
    },
    ADMINCAB {
        {
            this.command = new CommandAdminCab();
            this.inPage ="/admincab.jsp";
            this.okPage ="/main.jsp";
        }
    },
    ADMINCABGOOD {
        {
            this.command = new CommandAdminCabGood();
            this.inPage ="/admincabgood.jsp";
            this.okPage ="/main.jsp";
        }
    },
    CATALOG {
        {
            this.command = new CommandCatalog();
            this.inPage="/catalog.jsp";
            this.okPage="/catalog.jsp";
        }
    };
    public String inPage="/error.jsp";
    public String okPage ="/error.jsp";
    public ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

    public static final String msgError="msg_error";
    public static final String msgMessage="message";

}