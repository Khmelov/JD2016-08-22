package by.it.snegurskiy.Project.java;

import by.it.snegurskiy.Project.java.Bean.Users;
import by.it.snegurskiy.Project.java.DAO.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

class CommandBlock extends Action {
    @Override
    Action execute(HttpServletRequest req) throws ParseException {

        DAO dao = new DAO();

        if (req.getParameter("button1") != null) {
            dao = DAO.getDAO();
            if (Form.isPost(req)) {
                Users user = new Users();
                user.setID(Form.getInt(req, "ID"));
                user.setSurname(Form.getString(req, "surname", Patterns.NAME));
                user.setName(Form.getString(req, "name", Patterns.NAME));
                user.setLogin(Form.getString(req, "login", Patterns.LOGIN));
                user.setPassword(Form.getString(req, "password", Patterns.PASSWORD));
                user.setFK_Role(Form.getInt(req, "FK_Role"));
                user.setFK_Status(2);
                dao.user.update(user);
            }
        } else if (req.getParameter("button2") != null) {
            dao = DAO.getDAO();
            if (Form.isPost(req)) {
                Users user = new Users();
                user.setID(Form.getInt(req, "ID"));
                user.setSurname(Form.getString(req, "surname", Patterns.NAME));
                user.setName(Form.getString(req, "name", Patterns.NAME));
                user.setLogin(Form.getString(req, "login", Patterns.LOGIN));
                user.setPassword(Form.getString(req, "password", Patterns.PASSWORD));
                user.setFK_Role(Form.getInt(req, "FK_Role"));
                user.setFK_Status(1);
                dao.user.update(user);
            }


        }

        return null;
    }

}
