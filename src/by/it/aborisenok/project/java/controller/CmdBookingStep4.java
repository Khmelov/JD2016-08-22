package by.it.aborisenok.project.java.controller;

import by.it.aborisenok.project.java.beans.*;
import by.it.aborisenok.project.java.dao.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Лёша on 01.11.2016.
 */
public class CmdBookingStep4 extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        StringBuilder builder = new StringBuilder();

        DAO dao = DAO.getDAO();

        String name = req.getParameter("Name");
        List<Doctor> doctors = dao.doctor.getAll("WHERE Name='" + name + "';");
        int i = doctors.get(0).getID();

        for (VisitDate visitDate : dao.visitDate.getAll("WHERE FK_Doctor='" + i + "';"))
        {

            Timestamp time = visitDate.getVisitTime();

            builder.append("<option value=\""+ time.toString() +"\">"+ time.toString() +"</option>\n");
        }
        req.getSession().setAttribute("Doctor", doctors.get(0));
        req.setAttribute("message", builder);

        return null;
    }
}
