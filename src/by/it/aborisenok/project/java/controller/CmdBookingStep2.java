package by.it.aborisenok.project.java.controller;


import by.it.aborisenok.project.java.beans.Doctor;
import by.it.aborisenok.project.java.beans.Policlinic;
import by.it.aborisenok.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Лёша on 01.11.2016.
 */
public class CmdBookingStep2 extends Action {

    @Override
    public Action execute(HttpServletRequest req) {
        StringBuilder builder = new StringBuilder();

        DAO dao = DAO.getDAO();

        String policlinic = req.getParameter("Policlinic");

        List<Policlinic> policlinics = dao.policlinic.getAll("WHERE Name='" + policlinic + "';");
        int i = policlinics.get(0).getID();
        ArrayList<String> speshis = new ArrayList<>();
        for (Doctor doct : dao.doctor.getAll("WHERE FK_Policlinic='" + i + "';"))
        {

            String spesh = doct.getSpecialization();

            if (!speshis.contains(spesh)){
                speshis.add(spesh);
                builder.append("<option value=\""+ spesh +"\">"+ spesh + "</option>\n");
            }


        }
        req.getSession().setAttribute("Policlinic", policlinics.get(0));
        req.setAttribute("message", builder);

        return null;
    }
}
