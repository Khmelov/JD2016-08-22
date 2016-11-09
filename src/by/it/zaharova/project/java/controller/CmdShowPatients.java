package by.it.zaharova.project.java.controller;

import by.it.zaharova.project.java.beans.Patients;
import by.it.zaharova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.util.List;

class CmdShowPatients extends Action {

  

    @Override
    Action execute(HttpServletRequest req) {
        
        DAO dao=DAO.getDAO();
        if (Form.isPost(req)){
            Patients patients=new Patients();
            try {
                patients.setID(Form.getInt(req,"ID"));
                patients.setFirst_name(Form.getString(req, "First_name", Patterns.FIRSTNAME));
                patients.setSecond_name(Form.getString(req, "Second_name", Patterns.SECONDNAME));
                patients.setAddress(Form.getString(req, "Address", Patterns.ADDRESS));
                patients.setPhone_number(Form.getString(req, "Phone_number", Patterns.PHONENUMBER));
                patients.setFK_doctors(Form.getInt(req,"FK_doctors"));

                req.setAttribute(Messages.msgMessage,patients);
                if (patients.getID()>0){
                    dao.patients.update(patients);
                }
                if (patients.getID()<0){
                    patients.setID(patients.getID()*(-1));
                    dao.patients.delete(patients);
                }
                if (patients.getID()==0){
                    dao.patients.create(patients);
                }

            } catch (ParseException e) {
                e.printStackTrace();
                req.setAttribute(Messages.msgMessage,"Ошибка!!");
            }
        }
        req.setAttribute("patientss",dao.patients.getAll(""));

        return null;
    }
}
