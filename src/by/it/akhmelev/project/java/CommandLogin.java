package by.it.akhmelev.project.java;

import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.LOGIN.inPage;

        //проверим отправлены ли данные из формы, если нет, то покажем форму
        if (request.getParameter("Password") == null) {
            return page;
        }
        String password=request.getParameter("Password");   //пароль
        String login=request.getParameter("Login");   //логин

        if (FormHelper.valid(password) && FormHelper.valid(login)) {
            DAO dao = DAO.getDAO();
            List<User> users=dao.user.getAll(
                    String.format("where Login='%s' and Password='%s'",login,password));
        User user=null;
        if (users.size()>0) {
            user=users.get(0);
        }
        if (user==null) {
            request.setAttribute(
                    Action.msgMessage,
                    "Неверные данные повторите ввод.");
            page = Action.LOGIN.inPage;
            } else {
            request.setAttribute(
                    Action.msgMessage,
                    "Добро пожаловать, "+user.getLogin());
            page = Action.LOGIN.okPage;
            }
        }
        return page;
    }
}