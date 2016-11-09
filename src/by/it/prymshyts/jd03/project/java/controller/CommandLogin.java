package by.it.prymshyts.jd03.project.java.controller;

import by.it.prymshyts.jd03.project.java.beans.User;
import by.it.prymshyts.jd03.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.LOGIN.inPage;

        if (FormHelper.isPost(request)) {

            if (request.getParameter("Password") == null) {
                return page;
            }
            String password = request.getParameter("Password");
            String login    = request.getParameter("Login");

            if (FormHelper.valid(password) && FormHelper.valid(login)) {
                DAO dao = DAO.getDAO();

                List<User> users = dao.getUserDAO().getAll(
                        String.format("WHERE Login='%s' AND Password='%s'", login, password));
                User user = null;

                if (users.size() > 0) {
                    user = users.get(0);
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                }
                if (user == null) {
                    request.setAttribute(
                            Action.msgMessage,
                            "Неверные данные повторите ввод.");
                    page = Action.LOGIN.inPage;
                } else {
                    request.setAttribute(
                            Action.msgMessage,
                            "Добро пожаловать, " + user.getLogin());
                    page = Action.LOGIN.okPage;
                }
            }
        }
        return page;
    }
}