package by.it.grechishnikov.project.webapp.command;

import javax.servlet.http.HttpServletRequest;

public class SearchCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        return "/search.jsp";
    }
}
