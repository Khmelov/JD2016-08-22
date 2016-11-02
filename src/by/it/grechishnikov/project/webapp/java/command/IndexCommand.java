package by.it.grechishnikov.project.webapp.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class IndexCommand implements Command {
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return Commands.INDEX.message;
    }
}
