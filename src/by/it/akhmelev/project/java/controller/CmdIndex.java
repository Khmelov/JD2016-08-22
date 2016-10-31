package by.it.akhmelev.project.java.controller;


import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Action {

    String outListAds(List<Ad> ads) {
        StringBuilder sb = new StringBuilder();
        for (Ad ad : ads) {
            sb.append(ad.toString()).append("<br>");
        }
        return sb.toString();
    }

    @Override
    Action execute(HttpServletRequest req) {
        //auth????
        DAO dao = DAO.getDAO();
        List<Ad> ads = dao.ad.getAll("");
        req.setAttribute("ads", "<hr>"+ outListAds(ads)+"<hr>");
        return null;
    }
}
