package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
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
            List<Ad> ads= DAO.getDAO().ad.getAll("");
            req.setAttribute("ads",ads);
        }
        return null;
    }
}
