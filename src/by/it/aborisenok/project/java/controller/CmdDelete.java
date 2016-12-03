package by.it.aborisenok.project.java.controller;

import by.it.aborisenok.project.java.beans.Talon;
import by.it.aborisenok.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Лёша on 01.11.2016.
 */
public class CmdDelete extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();

        String strID = req.getParameter("Talon");
        int ID = Integer.parseInt(strID);
        Talon talon = new Talon();
        talon.setID(ID);

        dao.talon.delete(talon);
        return Actions.MYTALON.action;
    }
}
