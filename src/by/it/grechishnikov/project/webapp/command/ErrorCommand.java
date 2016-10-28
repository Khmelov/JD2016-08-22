package by.it.grechishnikov.project.webapp.command;

import javax.servlet.http.HttpServletRequest;

public class ErrorCommand implements Command {
    public String execute(HttpServletRequest req) {
        return "/error.jsp";
    }
}
