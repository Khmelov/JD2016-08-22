package by.it.zaharova.project.java.controller;

import by.it.zaharova.project.java.beans.Doctors;
import by.it.zaharova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

class CmdLogin extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        Doctors doctors = new Doctors();
        if (Form.isPost(req)) {
            try {
                doctors.setID(0);
                doctors.setName_surname(Form.getString(req, "Name_surname", Patterns.FIRSTNAME));
                doctors.setSpeciality(Form.getString(req, "Speciality", Patterns.SPECIALITY));
                doctors.setPhone_number(Form.getString(req, "Phone_number", Patterns.PHONENUMBER));
                doctors.setCabinet(Form.getString(req, "Cabinet", Patterns.CABINET));
            } catch (Exception e) {
                req.setAttribute(Messages.msgError, "NO VALID FIELDS");
                return null;
            }
            DAO dao = DAO.getDAO();
            if (dao.doctors.create(doctors)) {
                HttpSession session = req.getSession();
                session.setAttribute("doctors", doctors);
               // req.setAttribute("doctors", doctors);
                return null;
            }
//            List<Doctors> doctorss = dao.doctors.getAll(
//                    String.format("where ID = '$d', Name_surname = '%s', Speciality = '%s',  Phone_number = '%s', Cabinet=%s",
//                            doctors.getID(),
//                            doctors.getName_surname(),
//                            doctors.getSpeciality(),
//                            doctors.getPhone_number(),
//                            doctors.getCabinet()
//                    ));
//            if (doctorss.size()>0) {
//                doctors = doctorss.get(0);
//                HttpSession session = req.getSession();
//                session.setAttribute("doctors",doctors);
//                return Actions.INDEX.action;
//            }
//            else req.setAttribute(Messages.msgMessage, "Ошибка");
        }
            return null;
        }

}
