package by.it.akhmelev.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

class CommandError implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.ERROR.inPage;
    }
}