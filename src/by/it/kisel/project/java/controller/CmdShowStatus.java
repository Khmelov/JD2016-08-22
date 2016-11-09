package by.it.kisel.project.java.controller;

import by.it.kisel.project.java.beans.Status;
import by.it.kisel.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;


class CmdShowStatus extends Action {

//    @Override
//    Action execute(HttpServletRequest req) {
//        DAO dao= DAO.getDAO();
//        req.setAttribute("statuss",dao.status.getAll(""));
//        return null;
//    }

    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        int startNumber = 0;
        try {
            startNumber = Form.getInt(req, "startNumber");
        } catch (ParseException e) {
            startNumber = 0;
        }
        String limit = String.format(" LIMIT %s,%s", startNumber, 10);
        List<Status> statuss = dao.status.getAll(limit);
        req.setAttribute("statusCount", dao.status.getCount(""));
        for (Status status : statuss) {
            status.setViewNumber(++startNumber);
        }
        req.setAttribute("statuss", statuss);
        return null;
    }
}
