package by.it.grechishnikov.project.webapp.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class ContactsCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return Commands.CONTACTS.message;
    }
}
