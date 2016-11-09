package by.it.kisel.project.java.controller;

import by.it.kisel.project.java.beans.Orders;
import by.it.kisel.project.java.beans.Rooms;
import by.it.kisel.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateOrder extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        Orders orders = new Orders();
        Rooms rooms = new Rooms();
        if (Form.isPost(req)) {
            try {
                orders.setID(0);
                orders.setArrivalDate(Form.getInt(req,"ArrivalDate"));
                orders.setDepartureDate(Form.getInt(req,"DepartureDate"));
                orders.setTotalPrice((orders.getDepartureDate()-orders.getArrivalDate())*rooms.getPriceForDay());
               // orders.setTotalPrice(Form.getInt(req,"TotalPrice"));
                orders.setFK_rooms(Form.getInt(req,"FK_rooms"));
                orders.setFK_persons(Form.getInt(req,"FK_persons"));
            } catch (Exception e) {
                req.setAttribute(Messages.msgError, "NO VALID FIELDS");
                return null;
            }
            DAO dao = DAO.getDAO();
            if (dao.orders.create(orders)) {
                req.setAttribute(Messages.msgMessage, "ORDER ADDED");
                return Actions.SHOWORDERSFORUSERS.action;
            } else
                req.setAttribute(Messages.msgError, "FILL ERROR");
        }
        return null;
    }
}
