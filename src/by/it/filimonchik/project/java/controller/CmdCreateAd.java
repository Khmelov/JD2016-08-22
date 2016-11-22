package by.it.filimonchik.project.java.controller;

import by.it.filimonchik.project.java.bean.Ad;
import by.it.filimonchik.project.java.bean.User;
import by.it.filimonchik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

class CmdCreateAd extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        User user=(User)req.getSession().getAttribute("user");
        if (user==null) return Actions.LOGIN.action;

        if (Form.isPost(req)) {
            Ad ad=new Ad();
            try {
                ad.setFK_Model(Form.getString(req,"FK_Model", ".*"));
                ad.setFK_Car_body(Form.getString(req,"FK_Car_body",".*"));

                ad.setFK_Color(Form.getString(req,"FK_Color",".*"));
                ad.setPrice(Form.getInt(req,"Price"));
                ad.setFK_Users(user.getID());

                DAO dao=DAO.getDAO();
                dao.ad.create(ad);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return Actions.INDEX.action;
        }
        else
            return null;
    }
}
