package by.it.kisel.project.java.controller;

import by.it.kisel.project.java.beans.Orders;
import by.it.kisel.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

class CmdShowOrdersForUsers extends Action {

//    @Override
//    Action execute(HttpServletRequest req) {
//        DAO dao= DAO.getDAO();
//        req.setAttribute("ordersforusers",dao.orders.getAll(""));
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
        List<Orders> ordersforusers = dao.orders.getAll(limit);
        req.setAttribute("ordersCount", dao.orders.getCount(""));
        for (Orders orders : ordersforusers) {
            orders.setViewNumber(++startNumber);
        }
        req.setAttribute("ordersforusers", ordersforusers);
        return null;
    }
}
