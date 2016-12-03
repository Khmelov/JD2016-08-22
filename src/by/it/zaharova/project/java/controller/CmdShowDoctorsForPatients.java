package by.it.zaharova.project.java.controller;

import by.it.zaharova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

class CmdShowDoctorsForPatients extends Action {

    @Override
    Action execute(HttpServletRequest req) {
        DAO dao= DAO.getDAO();
        req.setAttribute("doctorss",dao.doctors.getAll(""));
        return null;
    }
}
