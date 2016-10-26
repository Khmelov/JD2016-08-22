package by.it.akhmelev.project.java;

import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;
import by.it.akhmelev.project.java.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;

public class CommandSignUp implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.SIGNUP.inPage;

        //проверим отправлены ли данные из формы, если нет, то покажем форму
        if (request.getParameter("Email") == null) {
            return page;
        }

        User user = new User();
        user.setId(0);
        //добавляем пользователей и администраторов, но это демо!!!
        int fkUser = Integer.parseInt(request.getParameter("FK_role"));
        user.setFk_Role(fkUser);

        user.setEmail(request.getParameter("Email"));   //почта
        user.setLogin(request.getParameter("Login"));   //логин
        user.setPassword(request.getParameter("Password"));
        //пароль. тут проблема безопасности.
        // нужно "солить" и хешировать.

        //проверим поля (добавьте паттерны самостоятельно)
        if (FormHelper.valid(user.getEmail()) &&
                FormHelper.valid(user.getLogin()) &&
                FormHelper.valid(user.getPassword())
                ) {
            DAO dao = DAO.getDAO();
            if (dao.user.create(user)) {
                request.setAttribute(
                        Action.msgMessage,
                        "Пользователь создан. Введите данные для авторизации.");
                page = Action.SIGNUP.okPage;
            } else {
                request.setAttribute(
                        Action.msgMessage,
                        "Пользователь НЕ создан. Введите данные заново. " + dao.user.lastSQL);
                page = Action.SIGNUP.inPage;
            }
        }
        return page;
    }
}