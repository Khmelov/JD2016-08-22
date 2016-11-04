package by.it.prymshyts.jd03.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class ActionFactory {
    ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new CommandError();

        String action = request.getParameter("command");

        if (action != null && !action.isEmpty()) {
            try {
                Action currentEnum = Action.valueOf(action.toUpperCase());
                current = currentEnum.getCurrentCommand();
            } catch (IllegalArgumentException e) {
                request.setAttribute(Action.msgError, "<b>Неизвестная команда: " + action + "</b>");
                request.setAttribute(Action.msgMessage, "<b>Неизвестная команда: " + action + "</b>");
            }
        }

        return current;
    }
}