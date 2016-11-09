package by.it.grechishnikov.project.webapp.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class ErrorCommand implements Command {
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute("message", "Неизвестная ошибка");
        return Commands.ERROR.message;
    }
}
