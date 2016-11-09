package by.it.kisel.project.java.controller;

import by.it.kisel.project.java.beans.Persons;
import by.it.kisel.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

class CmdShowPersons extends Action {

    private String debugOut(List<Persons> personss) {
            StringBuilder out=new StringBuilder();
            for (Persons persons:personss){
                out.append(persons.toString()).append("<br>");
            }
            return out.toString();
        }

//    @Override
//    Action execute(HttpServletRequest req) {
//        DAO dao= DAO.getDAO();
//        req.setAttribute("persons","<hr>"+debugOut(dao.persons.getAll(""))+"<hr>");
//        return null;
//    }

    @Override
    Action execute(HttpServletRequest req) {
        HttpSession session=req.getSession();
        Persons admin=(Persons)session.getAttribute("persons");
        if (admin==null){
            req.setAttribute(Messages.msgError,"Доступно только администратору!");
            return Actions.LOGIN.action;}
        int idRole=admin.getFK_role();
        if (idRole!=1)
        {
            req.setAttribute(Messages.msgError,"Доступно только администратору!");
            return Actions.LOGIN.action;
        }
        DAO dao=DAO.getDAO();
        if (Form.isPost(req)){
            Persons persons=new Persons();
            try {
                persons.setID(Form.getInt(req,"ID"));
                persons.setFirstName(Form.getString(req, "FirstName", Patterns.FIRSTNAME));
                persons.setSecondName(Form.getString(req, "SecondName", Patterns.SECONDNAME));
                persons.setPhoneNumber(Form.getString(req, "PhoneNumber", Patterns.PHONENUMBER));
                persons.setEmail(Form.getString(req, "Email", Patterns.EMAIL));
                persons.setFK_role(Form.getInt(req,"FK_role"));

                req.setAttribute(Messages.msgMessage,persons);
                if (persons.getID()>0){
                    dao.persons.update(persons);
                }
                if (persons.getID()<0){
                    persons.setID(persons.getID()*(-1));
                    dao.persons.delete(persons);
                }
                if (persons.getID()==0){
                    dao.persons.create(persons);
                }

            } catch (ParseException e) {
                e.printStackTrace();
                req.setAttribute(Messages.msgMessage,"Ошибка!!");
            }
        }
        req.setAttribute("personss",dao.persons.getAll(""));
        req.setAttribute("roles",dao.role.getAll(""));
        return null;
    }
}
