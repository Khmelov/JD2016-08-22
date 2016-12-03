package by.it.aborisenok.project.java.controller;


import by.it.aborisenok.project.java.beans.*;
import by.it.aborisenok.project.java.dao.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * Created by Лёша on 01.11.2016.
 */
public class CmdGetTalon extends Action {

    @Override
    public Action execute(HttpServletRequest req) {
        Policlinic policlinic = (Policlinic) req.getSession().getAttribute("Policlinic");
        Doctor doctor = (Doctor) req.getSession().getAttribute("Doctor");
        User user = (User) req.getSession().getAttribute("user");
        String time = req.getParameter("Time");

        DAO dao = DAO.getDAO();

        List<VisitDate> visitDates = dao.visitDate.getAll("WHERE Time='"+ time +"';");
        VisitDate visitDate = visitDates.get(0);


        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(policlinic.getName() + " " + policlinic.getStreet() + " " + policlinic.getHouse());
        stringBuilder.append("<br>");
        stringBuilder.append("---------------------------------------------------");
        stringBuilder.append("<br>");
        stringBuilder.append("Doctor: " + doctor.getName() + " " + doctor.getSurname());
        stringBuilder.append("<br>");
        stringBuilder.append(" Speshiality: " + doctor.getSpecialization() + "Category: " + doctor.getCategory());
        stringBuilder.append("<br>");
        stringBuilder.append("---------------------------------------------------");
        stringBuilder.append("<br>");
        stringBuilder.append("Visit Date: " + time);
        stringBuilder.append("<br>");
        stringBuilder.append("----------------------------------------------------");
        stringBuilder.append("<br>");
        stringBuilder.append("Pacient: " + user.getName() + " " + user.getSurname());
        stringBuilder.append("<br>");
        stringBuilder.append("Adress: " + user.getCity() + " " + user.getStreet() + " " + user.getHouse());

        Talon talon = new Talon();
        talon.setFK_Policlinic(policlinic.getID());
        talon.setFK_User(user.getID());
        talon.setFK_Doctor(doctor.getID());
        talon.setFK_VisitDate(visitDate.getID());

        dao.talon.create(talon);

        req.setAttribute("message",stringBuilder);

        dao.visitDate.delete(visitDate);
        return null;
    }
}
