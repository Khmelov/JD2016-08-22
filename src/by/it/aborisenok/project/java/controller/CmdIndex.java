package by.it.aborisenok.project.java.controller;

import by.it.aborisenok.project.java.beans.Policlinic;
import by.it.aborisenok.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Лёша on 03.11.2016.
 */
public class CmdIndex extends Action {

    @Override
    Action execute(HttpServletRequest reg) {
        int policlinicCount;
        int doctorCount;

        DAO dao = DAO.getDAO();

        policlinicCount = dao.policlinic.getAll("").size();

        doctorCount = dao.doctor.getAll("").size();

        reg.setAttribute("policlinicCount", policlinicCount);
        reg.setAttribute("doctorCount", doctorCount);
        return null;
    }
}
