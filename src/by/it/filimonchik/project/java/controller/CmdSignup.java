package by.it.filimonchik.project.java.controller;

import by.it.filimonchik.project.java.bean.User;
import by.it.filimonchik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

class CmdSignup extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        User user = new User();
        if (Form.isPost(req)) {
            try {
                user.setID(0);
                user.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
                user.setPassword(Form.getString(req, "Password", Patterns.PASSWORD));
                user.setEmail(Form.getString(req, "Email", Patterns.EMAIL));
                user.setFK_Role(2);
            } catch (Exception e) {
                req.setAttribute(Messages.msgError, "NO VALID FIELDS");
                return null;
            }
            DAO dao = DAO.getDAO();
            if (dao.user.create(user)) {
                req.setAttribute(Messages.msgMessage, "USER ADDED");
                return Actions.LOGIN.action;
            } else
                req.setAttribute(Messages.msgError, "FILL ERROR");
        }
        return null;
    }
}
