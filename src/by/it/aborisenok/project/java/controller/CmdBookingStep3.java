package by.it.aborisenok.project.java.controller;


import by.it.aborisenok.project.java.beans.Doctor;
import by.it.aborisenok.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Лёша on 01.11.2016.
 */
public class CmdBookingStep3 extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        StringBuilder builder = new StringBuilder();

        DAO dao = DAO.getDAO();

        String specialization = req.getParameter("Specialization");

        for (Doctor doct : dao.doctor.getAll("WHERE Specialization='" + specialization + "';"))
        {

            String name = doct.getName();
            String surname = doct.getSurname();

            builder.append("<option value=\""+ name +"\">"+ name + " " + surname +"</option>\n");
        }
        req.setAttribute("message", builder);
        return null;
    }
}
