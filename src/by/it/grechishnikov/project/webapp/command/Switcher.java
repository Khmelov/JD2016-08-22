package by.it.grechishnikov.project.webapp.command;

import by.it.grechishnikov.project.webapp.ServletController;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;

public class Switcher {
    public static String getJsp(Commands command, HttpServletRequest req) {
        if(command == Commands.CATALOG) {
            return new CatalogCommand().execute(req);
        } else if(command == Commands.INDEX) {
            return new IndexCommand().execute(req);
        } else if(command == Commands.LOGIN) {
            return new LoginCommand().execute(req);
        } else if(command == Commands.SIGN_UP) {
            return new SignUpCommand().execute(req);
        } else if(command == Commands.SEARCH) {
            return new SearchCommand().execute(req);
        }
        else return new ErrorCommand().execute(req);
    }

    public static String request(HttpServletRequest req) {
        String command = req.getParameter("command");
        ServletController.logger.log(Level.INFO, "\n****method request, command = " + command + "****");
        if(command == null || command.isEmpty()) {
            return getJsp(Commands.ERROR, req);
        } else {
            switch (command) {
                case "catalog":
                    return getJsp(Commands.CATALOG, req);
                case "index":
                    return getJsp(Commands.INDEX, req);
                case "search":
                    return getJsp(Commands.SEARCH, req);
                case "login":
                    return getJsp(Commands.LOGIN, req);
                case "signup":
                    return getJsp(Commands.SIGN_UP, req);
                default:
                    return getJsp(Commands.ERROR, req);
            }
        }
    }
}
