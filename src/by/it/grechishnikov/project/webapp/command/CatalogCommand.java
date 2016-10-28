package by.it.grechishnikov.project.webapp.command;

import javax.servlet.http.HttpServletRequest;

public class CatalogCommand implements Command {
    public String execute(HttpServletRequest req) {

        return "/catalog.jsp";
    }
}
