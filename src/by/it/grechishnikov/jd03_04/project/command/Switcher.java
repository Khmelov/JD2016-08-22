package by.it.grechishnikov.jd03_04.project.command;

import javax.servlet.http.HttpServletRequest;

public class Switcher {
    public static String getJsp(Commands command) {
        if(command == Commands.CATALOG) {
            return new CatalogCommand().execute();
        } else if(command == Commands.INDEX) {
            return new IndexCommand().execute();
        } else if(command == Commands.LOGIN) {
            return new LoginCommand().execute();
        } else if(command == Commands.SIGN_UP) {
            return new SignUpCommand().execute();
        } else return new ErrorCommand().execute();
    }

    public static String request(HttpServletRequest req) {
        String command = req.getParameter("command");
        if(command == null || command.isEmpty()) {
            return getJsp(Commands.ERROR);
        }
        switch (command) {
            case "catalog" : return getJsp(Commands.CATALOG);
            case "index" : return getJsp(Commands.INDEX);
            case "login" : return getJsp(Commands.LOGIN);
            case "signUp" : return getJsp(Commands.SIGN_UP);
            default : return getJsp(Commands.ERROR);
        }
    }
}
