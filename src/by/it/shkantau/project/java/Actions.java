package by.it.shkantau.project.java;

import javax.servlet.http.HttpServletRequest;

enum Actions {
    SIGNUP {{ this.action = new CmdSignUp();}},
    LOGIN { {this.action = new CmdLogin();}},
    LOGOUT {{this.action = new CmdLogout();}},
    INDEX {{this.action = new CmdIndex();}},
    PROFILE {{this.action = new CmdProfile();}},
    ERROR {{this.action = new CmdError();}},
    LISTUSERS {{this.action = new CmdListUsers();}},
    STUFFINGCREW {{this.action = new CmdStuffingCrew();}},
    NEWFLIGHT {{this.action = new CmdNewFlight();}};


    protected Action action = null;

    public static Action defineFrom(HttpServletRequest request){
        Action result ;
        String command = request.getParameter("command");
        if (command != null) {
            try {
                result = Actions.valueOf(command.toUpperCase()).action;
            } catch (IllegalArgumentException e) {
                result = Actions.ERROR.action;
            }
        }else {
            result = Actions.INDEX.action;
        }
        return result;
    }
}