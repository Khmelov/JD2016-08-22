package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdIndex extends Action{

    private String debugOut(List<Ad> ads) {
            StringBuilder out=new StringBuilder();
            for (Ad ad:ads){
                out.append(ad.toString()).append("<br>");
            }
            return out.toString();
        }

    @Override
    Action execute(HttpServletRequest req) {
        DAO dao=DAO.getDAO();
        req.setAttribute("ads","<hr>"+debugOut(dao.ad.getAll(""))+"<hr>");
        return null;
    }
}
