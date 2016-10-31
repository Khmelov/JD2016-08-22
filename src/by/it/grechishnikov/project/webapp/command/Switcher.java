package by.it.grechishnikov.project.webapp.command;

import by.it.grechishnikov.project.webapp.ServletController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;

public class Switcher {
    public static String getJsp(Commands command, HttpServletRequest req, HttpServletResponse resp) {
        if(command == Commands.INDEX) {
            return new IndexCommand().execute(req, resp);
        } else if(command == Commands.CONTACTS) {
            return new ContactsCommand().execute(req, resp);
        } else if(command == Commands.MY) {
            return new MyCommand().execute(req, resp);
        } else if(command == Commands.CATALOG) {
            return new CatalogCommand().execute(req, resp);
        } else if(command == Commands.ADMIN) {
            return new AdminCommand().execute(req, resp);
        } else if(command == Commands.LOGIN) {
            return new LoginCommand().execute(req, resp);
        } else if(command == Commands.SIGN_UP) {
            return new SignUpCommand().execute(req, resp);
        } else if(command == Commands.SEARCH) {
            return new SearchCommand().execute(req, resp);
        }
        else return new ErrorCommand().execute(req, resp);
    }

    public static String request(HttpServletRequest req, HttpServletResponse resp) {
        String command = req.getParameter("command");
        ServletController.logger.log(Level.INFO, "\n****method request, command = " + command + "****");
        if(command == null || command.isEmpty()) {
            return getJsp(Commands.ERROR, req, resp);
        } else {
            switch (command) {
                case "index":
                    return getJsp(Commands.INDEX, req, resp);
                case "contacts" :
                    return getJsp(Commands.CONTACTS, req, resp);
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
                case "admin" :
                    return getJsp(Commands.ADMIN, req, resp);
                default:
                    return getJsp(Commands.ERROR, req, resp);
            }
        }
    }
}
