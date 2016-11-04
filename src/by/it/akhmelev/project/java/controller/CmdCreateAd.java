package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

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
                ad.setAddress(Form.getString(req,"Address",".*"));
                ad.setDescription(Form.getString(req,"Description",".*"));

                ad.setArea(Form.getDouble(req,"Area"));
                ad.setPrice(Form.getDouble(req,"Price"));

                ad.setFloor(Form.getInt(req,"Floor"));
                ad.setFloors(Form.getInt(req,"Floors"));

                ad.setRoomCount(Form.getInt(req,"RoomCount"));
                ad.setFK_Users(user.getId());

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
