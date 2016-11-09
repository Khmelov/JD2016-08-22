package by.it.kisel.project.java.controller;

import by.it.kisel.project.java.beans.Rooms;
import by.it.kisel.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

class CmdIndex extends Action {

//    @Override
//    Action execute(HttpServletRequest req) {
//       DAO dao= DAO.getDAO();
//        req.setAttribute("roomss",dao.rooms.getAll(""));
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
        List<Rooms> roomss = dao.rooms.getAll(limit);
        req.setAttribute("roomsCount", dao.rooms.getCount(""));
        for (Rooms rooms : roomss) {
            rooms.setViewNumber(++startNumber);
        }
        req.setAttribute("roomss", roomss);
        return null;
    }
}
