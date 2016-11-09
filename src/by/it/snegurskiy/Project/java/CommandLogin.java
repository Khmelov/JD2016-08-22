package by.it.snegurskiy.Project.java;



import by.it.snegurskiy.Project.java.Bean.Users;
import by.it.snegurskiy.Project.java.DAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

class CommandLogin extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        Users user = new Users();
        if (Form.isPost(req)) {
            try {
                user.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
                user.setPassword(req.getParameter("Password"));
            } catch (Exception e) {
                req.setAttribute(Messages.msgError, "NO VALID FIELDS");
                return null;
            }
            DAO dao = DAO.getDAO();
            List<Users> users = dao.user.getAll(
                    String.format("where Login='%s' and Password='%s'",
                            user.getLogin(),
                            user.getPassword()
                    ));
            if (users.size() > 0) {
                user = users.get(0);
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(600);

                if (user.getFK_Role() == 1) return Actions.MAINADMIN.action;
                if (user.getFK_Role() == 2 && user.getFK_Status() == 1) return Actions.MAINUSER.action;
                if (user.getFK_Role() == 2 && user.getFK_Status() == 2) {
                    req.setAttribute(Messages.msgMessage, "Пользователь заблокирован, обратитесь к администратору");
                    return null;
                }


            }

            req.setAttribute(Messages.msgError, "Такой пользователь не зарегестрирован" + user);


        }
            return null;

        }
}
