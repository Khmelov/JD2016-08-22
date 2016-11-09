package by.it.opiga.JD03_04.Project.java.controller;

import by.it.opiga.JD03_04.Project.java.beans.mybeans.User;
import by.it.opiga.JD03_04.Project.java.dao.myDAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdSignup extends Action {
    @Override
    Action execute(HttpServletRequest req,HttpServletResponse resp) {
        User user = new User();
        try {
            user.setID(0);
            user.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
            user.setPass(Form.getString(req, "Password", Patterns.PASSWORD));
            user.setEmail(Form.getString(req, "Email", Patterns.EMAIL));
            user.setFK_role(1);

        } catch (Exception e) {
            req.setAttribute(Messages.msgError, "NO VALID FIELDS");
            return null;
        }
        DAO dao = DAO.getDAO();
        if (dao.user.create(user)) {
            req.setAttribute(Messages.msgMessage, "USER ADDED");
//            return Actions.LOGIN.action;
            return Actions.SHOWUSERS.action;
        } else
            req.setAttribute(Messages.msgError, "FILL ERROR");
        return null;
    }
}
