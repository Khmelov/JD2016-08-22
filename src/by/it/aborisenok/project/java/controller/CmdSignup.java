package by.it.aborisenok.project.java.controller;

import by.it.aborisenok.project.java.beans.User;
import by.it.aborisenok.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * Created by Лёша on 01.11.2016.
 */
public class CmdSignup extends Action {

    @Override
    public Action execute(HttpServletRequest req) {
        User user = new User();
        if (Form.isPost(req)) {
            try {

                user.setID(0);
                user.setLogin(req.getParameter("Login"));
                user.setPassword(req.getParameter("Password"));
                user.setName(req.getParameter("Name"));
                user.setSurname(req.getParameter("Surname"));
                user.setBirthDay(Timestamp.valueOf(req.getParameter("Birthday") + " 00:00:00"));
                user.setCity(req.getParameter("City"));
                user.setStreet(req.getParameter("Street"));
                user.setHouse(Integer.parseInt(req.getParameter("House")));
                user.setFlat(Integer.parseInt(req.getParameter("Flat")));
                user.setFK_Role(2);

            } catch (Exception e) {
                req.setAttribute(Messages.msgMessage, "NO VALID FIELDS");
                return null;
            }
            DAO dao = DAO.getDAO();
            if (dao.user.create(user)) {
                req.setAttribute(Messages.msgMessage, "USER ADDED");
                return Actions.INDEX.action;
            } else
                req.setAttribute(Messages.msgMessage, "FILL ERROR");
        }
        return null;
    }
}
