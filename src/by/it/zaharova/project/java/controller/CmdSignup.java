package by.it.zaharova.project.java.controller;

import by.it.zaharova.project.java.beans.Patients;
import by.it.zaharova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

class CmdSignup extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        Patients patients = new Patients();
        if (Form.isPost(req)) {
            try {
                patients.setID(0);
                patients.setFirst_name(Form.getString(req, "First_name", Patterns.FIRSTNAME));
                patients.setSecond_name(Form.getString(req, "Second_name", Patterns.SECONDNAME));
                patients.setAddress(Form.getString(req, "Address", Patterns.ADDRESS));
                patients.setPhone_number(Form.getString(req, "Phone_number", Patterns.PHONENUMBER));
                patients.setFK_doctors(Form.getInt(req,"FK_doctors"));
            } catch (Exception e) {
                req.setAttribute(Messages.msgError, "NO VALID FIELDS");
                return null;
            }
            DAO dao = DAO.getDAO();
            if (dao.patients.create(patients)) {
                HttpSession session = req.getSession();
                session.setAttribute("patients", patients);
               return null;
            }


//            List<Patients> patientss = dao.patients.getAll(
//                    String.format("where ID = '%d', First_name = '%s', Second_name = '%s', Address = '%s', Phone_number = '%s', FK_doctors='%d'",
//                            patients.getID(),
//                            patients.getFirst_name(),
//                            patients.getSecond_name(),
//                            patients.getAddress(),
//                            patients.getPhone_number(),
//                            patients.getFK_doctors()
//            ));
//           if (patientss.size()>0) {
//               patients = patientss.get(0);
//               HttpSession session = req.getSession();
//               session.setAttribute("patients",patients);
//               return Actions.INDEX.action;
//           }
//          else req.setAttribute(Messages.msgMessage, "Ошибка");
        }
        return null;
    }
}
