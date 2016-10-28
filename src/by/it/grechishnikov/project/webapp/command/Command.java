package by.it.grechishnikov.project.webapp.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String LOGIN_REGEX = "[a-zA-Z0-9]+";
    String PASSWORD_REGEX = "[a-zA-Z0-9]{6,}";
    String EMAIL_REGEX = "[a-zA-Z0-9]+[@][a-zA-Z]+[.][a-zA-Z]+";

    String execute(HttpServletRequest req);
}
