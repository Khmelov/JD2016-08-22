package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CmdSignup extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        User user = new User();
        try {
            user.setId(0);
            user.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
            user.setPassword(req.getParameter("Password"));
            user.setEmail(req.getParameter("Email"));
            user.setFk_Role(2);
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
        return null;
    }
}
