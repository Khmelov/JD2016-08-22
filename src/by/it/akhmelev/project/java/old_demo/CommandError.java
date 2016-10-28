package by.it.akhmelev.project.java.old_demo;

import javax.servlet.http.HttpServletRequest;

class CommandError implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.ERROR.inPage;
    }
}