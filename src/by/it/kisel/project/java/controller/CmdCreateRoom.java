package by.it.kisel.project.java.controller;

import by.it.kisel.project.java.beans.Rooms;
import by.it.kisel.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateRoom extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        Rooms rooms = new Rooms();
        if (Form.isPost(req)) {
            try {
                rooms.setID(0);
                rooms.setRoomCount(Integer.parseInt(req.getParameter("RoomCount")));
                rooms.setQuality(Integer.parseInt(req.getParameter("Quality")));
                rooms.setPriceForDay(Integer.parseInt(req.getParameter("PriceForDay")));
                rooms.setConditioner(req.getParameter("Conditioner"));
                rooms.setDescription(req.getParameter("Description"));
            } catch (Exception e) {
                req.setAttribute(Messages.msgError, "NO VALID FIELDS");
                return null;
            }
            DAO dao = DAO.getDAO();
            if (dao.rooms.create(rooms)) {
                req.setAttribute(Messages.msgMessage, "ROOM ADDED");
                return Actions.INDEX.action;
            } else
                req.setAttribute(Messages.msgError, "FILL ERROR");
        }

        return null;
    }
}
