package by.it.grechishnikov.project.webapp.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Switcher {
    public static String getJsp(Commands command, HttpServletRequest req, HttpServletResponse resp) {
        if(command == Commands.MY) {
            return new MyCommand().execute(req, resp);
        } else if(command == Commands.CATALOG) {
            return new CatalogCommand().execute(req, resp);
        } else if(command == Commands.LOGIN) {
            return new LoginCommand().execute(req, resp);
        } else if(command == Commands.SIGN_UP) {
            return new SignUpCommand().execute(req, resp);
        } else if(command == Commands.ORDER) {
            return new OrderCommand().execute(req, resp);
        } else if(command == Commands.SEARCH) {
            return new SearchCommand().execute(req, resp);
        }
        else return new ErrorCommand().execute(req, resp);
    }

    public static String request(HttpServletRequest req, HttpServletResponse resp) {
        String command = req.getParameter("command");
        if(command == null || command.isEmpty()) {
            return getJsp(Commands.ERROR, req, resp);
        } else {
            switch (command) {
                case "my" :
                    return getJsp(Commands.MY, req, resp);
                case "catalog":
                    return getJsp(Commands.CATALOG, req, resp);
                case "search":
                    return getJsp(Commands.SEARCH, req, resp);
                case "login":
                    return getJsp(Commands.LOGIN, req, resp);
                case "signup":
                    return getJsp(Commands.SIGN_UP, req, resp);
                case "order" :
                    return getJsp(Commands.ORDER, req, resp);
                default:
                    return getJsp(Commands.ERROR, req, resp);
            }
        }
    }
}
