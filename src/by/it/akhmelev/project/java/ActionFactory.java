package by.it.akhmelev.project.java;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new CommandError();
        // извлечение имени команды из запроса ?command=action_name
        String action = request.getParameter("command");
        // получение объекта, соответствующего команде
        if (action != null && !action.isEmpty()) {
            try {
                Action currentEnum = Action.valueOf(action.toUpperCase());
                current = currentEnum.getCurrentCommand();
            } catch (IllegalArgumentException e) {
                request.setAttribute(Action.msgError, "<b>Неизвестная команда: "+action+"</b>");
                request.setAttribute(Action.msgMessage, "<b>Неизвестная команда: "+action+"</b>");
            }
        }
        //если команда не найдена, то вернем пустую.
        //иначе вернем команду для выполнения
        return current;
    }
}