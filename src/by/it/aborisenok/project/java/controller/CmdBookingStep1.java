package by.it.aborisenok.project.java.controller;

import by.it.aborisenok.project.java.beans.Policlinic;
import by.it.aborisenok.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Лёша on 01.11.2016.
 */
public class CmdBookingStep1 extends Action {

    @Override
    public Action execute(HttpServletRequest req) {

        StringBuilder builder = new StringBuilder();

        DAO dao = DAO.getDAO();

        for (Policlinic polic : dao.policlinic.getAll(""))
        {
            String name = polic.getName();
            String adress = polic.getStreet() + ", " + polic.getHouse();
            builder.append("<option value=\""+ name +"\">"+ name + ", " + adress + "</option>\n");
        }

        req.setAttribute("message", builder);
        return null;
    }
}
