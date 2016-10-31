package by.it.grechishnikov.project.webapp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CatalogCommand implements Command {
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return Commands.CATALOG.message;
    }
}
