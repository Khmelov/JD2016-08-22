package by.it.aborisenok.project.java.controller;

import by.it.aborisenok.project.java.beans.Doctor;
import by.it.aborisenok.project.java.beans.Policlinic;
import by.it.aborisenok.project.java.beans.Talon;
import by.it.aborisenok.project.java.beans.User;
import by.it.aborisenok.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Лёша on 01.11.2016.
 */
public class CmdMyTalon extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        StringBuilder builder = new StringBuilder();
        User user = (User) req.getSession().getAttribute("user");
        int userID = user.getID();

        DAO dao = DAO.getDAO();

        for (Talon talon : dao.talon.getAll("WHERE FK_User='" + userID + "';"))
        {
            String ID = String.valueOf(talon.getID());
            List<Policlinic> policlinics = dao.policlinic.getAll("WHERE ID='" + talon.getFK_Policlinic() + "';");
            String policlinic = policlinics.get(0).getName();
            List<Doctor> doctors= dao.doctor.getAll("WHERE ID='" + talon.getFK_Doctor() + "';");
            String doctor = doctors.get(0).getName() + " " + doctors.get(0).getSurname() + "(" + doctors.get(0).getSpecialization() + ")";


            String patient = user.getName() + " " + user.getSurname();

            String data = ID + ": Поликлиника - " + policlinic + ", Доктор - " + doctor + ", Пациент - " + patient;
            builder.append("<option value=\""+ talon.getID() +"\">"+ data + "</option>\n");
        }

        req.setAttribute("message", builder);
        return null;
    }
}
