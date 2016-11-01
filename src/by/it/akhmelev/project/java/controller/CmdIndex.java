package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdIndex extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao=DAO.getDAO();
        req.setAttribute("ads",dao.ad.getAll(""));
        return null;
    }
}
