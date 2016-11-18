package by.it.filimonchik.project.java.controller;

import by.it.filimonchik.project.java.bean.Ad;
import by.it.filimonchik.project.java.bean.User;
import by.it.filimonchik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

class CmdProfile extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            req.getSession().invalidate();
            return Actions.LOGIN.action;
        }
        else
        {
            User user=(User)req.getSession().getAttribute("user");
            DAO dao=DAO.getDAO();
            int startNumber=0;
            try {
                startNumber=Form.getInt(req,"startNumber");
            } catch (ParseException e) {
                startNumber=0;
            }
            String limit=String.format("where FK_Users=%d LIMIT %s,%s",user.getID(),startNumber,5);
            List<Ad> ads = dao.ad.getAll(limit);
            req.setAttribute("adCount", dao.ad.getCount(""));
            for (Ad ad : ads) {
                ad.setViewNumber(++startNumber);
            }
            req.setAttribute("ads", ads);


        }
        return null;
    }
}
