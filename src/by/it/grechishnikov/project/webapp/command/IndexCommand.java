package by.it.grechishnikov.project.webapp.command;

import javax.servlet.http.HttpServletRequest;

public class IndexCommand implements Command {
    public String execute(HttpServletRequest req) {

        return "/index.jsp";
    }
}
