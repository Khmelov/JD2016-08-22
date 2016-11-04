package by.it.dubatovka.project_helpdesk.java;


import by.it.dubatovka.project_helpdesk.java.beans.User;
import by.it.dubatovka.project_helpdesk.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        User user = new User();
        try {
            user.setID(0);
            user.setLogin(Form.getString(req, "login", Patterns.LOGIN));
            user.setPassword(req.getParameter("passwordinput"));
            user.setEmail(req.getParameter("email"));
            user.setFk_role(2);

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
        //return Actions.SIGNUP.action;
        return null;
    }
}
