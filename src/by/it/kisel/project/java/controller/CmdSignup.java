package by.it.kisel.project.java.controller;

import by.it.kisel.project.java.beans.Persons;
import by.it.kisel.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

class CmdSignup extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        Persons persons = new Persons();
        if (Form.isPost(req)) {
            try {
                persons.setID(0);
                persons.setFirstName(Form.getString(req, "FirstName", Patterns.FIRSTNAME));
                persons.setSecondName(Form.getString(req, "SecondName", Patterns.SECONDNAME));
                persons.setPhoneNumber(Form.getString(req, "PhoneNumber", Patterns.PHONENUMBER));
                persons.setEmail(Form.getString(req, "Email", Patterns.EMAIL));
                persons.setFK_role(Form.getInt(req,"FK_role"));
            } catch (Exception e) {
                req.setAttribute(Messages.msgError, "NO VALID FIELDS");
                return null;
            }
            DAO dao = DAO.getDAO();
            if (dao.persons.create(persons)) {
                req.setAttribute(Messages.msgMessage, "USER ADDED");
                return Actions.LOGIN.action;
            } else
                req.setAttribute(Messages.msgError, "FILL ERROR");
        }
        return null;
    }
}
