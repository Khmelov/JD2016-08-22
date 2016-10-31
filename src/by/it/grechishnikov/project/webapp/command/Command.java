package by.it.grechishnikov.project.webapp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    String LOGIN_REGEX = "[a-zA-Z0-9_.-]+";
    String PASSWORD_REGEX = "[a-zA-Z0-9_.-]{6,}";
    String EMAIL_REGEX = "[a-zA-Z0-9_.-]+[@][a-zA-Z_.-]+[.][a-zA-Z]+";

    String execute(HttpServletRequest req, HttpServletResponse resp);
}
