package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CmdLogin extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        User user = new User();
        try {
            user.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
            user.setPassword(req.getParameter("Password"));
        } catch (Exception e) {
            req.setAttribute(Messages.msgError, "NO VALID FIELDS");
            return null;
        }
        DAO dao= DAO.getDAO();
        if
        (dao.user.getAll(
                String.format("where Login='%s' and Password='%s'",
                        user.getLogin(),
                        user.getPassword()
                )).size()>0
        )
        {
            return Actions.LOGOUT.action;
        }
        req.setAttribute(Messages.msgError,"NO SUCH USER");
        return null;
    }
}
