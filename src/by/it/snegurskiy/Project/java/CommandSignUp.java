package by.it.snegurskiy.Project.java;

import by.it.snegurskiy.Project.java.Bean.Users;
import by.it.snegurskiy.Project.java.DAO.DAO;

import javax.servlet.http.HttpServletRequest;

class CommandSignUp extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        Users user = new Users();
        if (Form.isPost(req)) {
            try {
                user.setID(0);
                user.setSurname(Form.getString(req, "surname", Patterns.NAME));
                user.setName(Form.getString(req, "name", Patterns.NAME));
                user.setLogin(Form.getString(req, "login", Patterns.LOGIN));
                user.setPassword(Form.getString(req, "password", Patterns.PASSWORD));
                user.setFK_Role(2);
                user.setFK_Status(1);
            } catch (Exception e) {
                req.setAttribute(Messages.msgError, "Введены не корректные данные");
                return null;
            }
            DAO dao = DAO.getDAO();
            if (dao.user.create(user)) {
                req.setAttribute(Messages.msgMessage, "Добро пожаловать");
                return Actions.LOGIN.action;
            } else
                req.setAttribute(Messages.msgError, "Введены не корректные данные2");
        }
        return null;
    }
}
