package by.it.aborisenok.project.java.controller;

import by.it.aborisenok.project.java.beans.User;
import by.it.aborisenok.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Лёша on 01.11.2016.
 */
public class CmdSignin extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        User user = new User();
        if (Form.isPost(req)) {
            try {
                user.setLogin(req.getParameter("Login"));
                user.setPassword(req.getParameter("Password"));
            } catch (Exception e) {
                req.setAttribute(Messages.msgError, "NO VALID FIELDS");
                return null;
            }
            DAO dao = DAO.getDAO();
            List<User> users = dao.user.getAll(
                    String.format("where Login='%s' and Password='%s'",
                            user.getLogin(),
                            user.getPassword()
                    ));
            if (users.size() > 0) {
                user = users.get(0);
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                return Actions.INDEX.action;
            }
            req.setAttribute(Messages.msgError, "NO SUCH USER");
        }
        return null;
    }
}
