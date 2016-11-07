package by.it.voronovich.project.java;

import by.it.voronovich.project.java.bean.User;
import by.it.voronovich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

class CommandSignUp implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.SIGNUP.inPage;

        if (request.getParameter("Name") == null || request.getParameter("Surname") == null
                || request.getParameter("Login") == null || request.getParameter("Password") == null
                || request.getParameter("Email") == null) {
            request.setAttribute(Action.msgMessage, "Для регистрации вашего аккаунта заполните все даанные.");
            return page;
        }

        DAO dao = DAO.getDAO();
        User user = new User();

            if (!(dao.user.getAll("WHERE Login='" + request.getParameter("Login")+"'").isEmpty())) {
                request.setAttribute(Action.msgMessage, "Пользователь не создан. Данный логин занят.");
                page = Action.SIGNUP.inPage;
            } else {
                if (!(dao.user.getAll("WHERE Email='" + request.getParameter("Email")+"'").isEmpty())) {
                    request.setAttribute(Action.msgMessage, "Пользователь не создан. Данная почта занята.");
                    page = Action.SIGNUP.inPage;
                } else {
                    user.setIdUsers(0);
                    user.setFK_Role(2);
                    user.setName(request.getParameter("Name"));
                    user.setSurname(request.getParameter("Surname"));
                    user.setEmail(request.getParameter("Email"));
                    user.setLogin(request.getParameter("Login"));
                    user.setPassword(request.getParameter("Password"));

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
            }
        return page;
    }
}