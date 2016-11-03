package by.it.aborisenok.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Actions {

SIGNIN {
    {
        this.command = new CmdSignin();
        this.inPage = "/index.jsp";
        this.okPage = "/index.jsp";
    }
},

SIGNUP {
    {
        this.command = new CmdSignup();
        this.inPage="/index.jsp";
        this.okPage ="/signup.jsp";
    }
},

ADUSER {
    {
        this.command = new CmdAdUser();
        this.inPage = "/signup.jsp";
        this.okPage = "/main.jsp";
    }
},

EXIT {
    {
        this.command = new CmdExit();
        this.inPage = "/index.jsp";
        this.okPage = "/logout.jsp";
    }
},

MYTALON {
    {
      this.command = new CmdMyTalon();
      this.inPage = "/index.jsp";
      this.okPage = "/mytalon.jsp";
    }
},

BOOKINGSTEP1 {
    {
        this.command = new CmdBookingStep1();
        this.inPage = "/main.jsp";
        this.okPage = "/bookingstep1.jsp";
    }
},

BOOKINGSTEP2 {
    {
        this.command = new CmdBookingStep2();
        this.inPage = "/bookingstep1.jsp";
        this.okPage = "/bookingstep2.jsp";
    }
},

BOOKINGSTEP3 {
    {
        this.command = new CmdBookingStep3();
        this.inPage = "/bookingstep2.jsp";
        this.okPage = "/bookingstep3.jsp";
    }
},

GETTALON {
    {
        this.command = new CmdGetTalon();
        this.inPage = "/bookingstep3.jsp";
        this.okPage = "/gettalon.jsp";
    }
},

DOWNLOAD {
    {
        this.command = new CmdDownload();
        this.inPage = "/gettalon.jsp";
        this.okPage = "/gettalon.jsp";
    }
},

DELETE {
    {
        this.command = new CmdDelete();
        this.inPage = "/bookingstep1.jsp";
        this.okPage = "/bookingstep3.jsp";
    }
},

LOGIN {
    {
        this.command = new CmdLogin();
        this.inPage = "/index.jsp";
        this.okPage = "/main.jsp";
    }
},

LOGOUT {
    {
        this.command = new CmdLogout();
        this.inPage = "/logout.jsp";
        this.okPage = "/index.jsp";
    }
},
ERROR  {
    {
        this.command = new CmdError();
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
