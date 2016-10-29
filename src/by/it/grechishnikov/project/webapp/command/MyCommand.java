package by.it.grechishnikov.project.webapp.command;

import javax.servlet.http.HttpServletRequest;

public class MyCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        return "/my.jsp";
    }
}
