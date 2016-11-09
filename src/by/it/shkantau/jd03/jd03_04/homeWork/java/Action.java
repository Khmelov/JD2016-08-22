package by.it.shkantau.jd03.jd03_04.homeWork.java;

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
    LOGOUT {
        {
            this.command = new CommandLogout();
            this.inPage="/logout.jsp";
            this.okPage ="/login.jsp";
        }
    },
    ERROR {
        {
            this.command = new CommandLogout();
        }
    },
     STUFFINGCREW {
            {
                this.command = new CommandStuffingCrew();
                this.inPage="/index.jsp";
                this.okPage ="/stuffingCrew.jsp";
            }

        },
     ADDFLIGHT {
            {
                this.command = new CommandAddFlight();
                this.inPage="/index.jsp";
                this.okPage ="/addFlight.jsp";
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