package by.it.aborisenok.project.java.controller;

import by.it.aborisenok.project.java.beans.*;
import by.it.aborisenok.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Лёша on 08.11.2016.
 */
public class CmdDeleteUser extends Action{
    @Override
    Action execute(HttpServletRequest reg) {
        DAO dao = DAO.getDAO();

        String strID = reg.getParameter("User");
        int ID = Integer.parseInt(strID);
        User user = new User();
        user.setID(ID);

        dao.user.delete(user);
        return Actions.ADMINCAB.action;
    }
}
