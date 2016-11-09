package by.it.zaharova.project.java.controller;

import by.it.zaharova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;


class CmdIndex extends Action {

    @Override
    Action execute(HttpServletRequest req) {
       DAO dao= DAO.getDAO();
        req.setAttribute("diagnostics",dao.diagnostic.getAll(""));
        return null;
    }
}
