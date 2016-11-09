package by.it.kisel.project.java.controller;

import by.it.kisel.project.java.beans.Orders;
import by.it.kisel.project.java.beans.Persons;
import by.it.kisel.project.java.beans.Rooms;
import by.it.kisel.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

class CmdShowOrders extends Action {

    private String debugOut(List<Orders> orderss) {
            StringBuilder out=new StringBuilder();
            for (Orders orders:orderss){
                out.append(orders.toString()).append("<br>");
            }
            return out.toString();
        }

//    @Override
//    Action execute(HttpServletRequest req) {
//        DAO dao= DAO.getDAO();
//        req.setAttribute("orders","<hr>"+debugOut(dao.orders.getAll(""))+"<hr>");
//        return null;
//    }

    @Override
    Action execute(HttpServletRequest req) {
        HttpSession session=req.getSession();
        Persons admin=(Persons)session.getAttribute("persons");
        if (admin==null){
            req.setAttribute(Messages.msgError,"Доступно только администратору!");
            return Actions.LOGIN.action;}
        int idRole=admin.getFK_role();
        if (idRole!=1)
        {
            req.setAttribute(Messages.msgError,"Доступно только администратору!");
            return Actions.LOGIN.action;
        }
        DAO dao=DAO.getDAO();
        if (Form.isPost(req)){
            Rooms rooms = new Rooms();
            Orders orders=new Orders();
            try {
                orders.setID(Form.getInt(req,"ID"));
                orders.setArrivalDate(Form.getInt(req, "ArrivalDate"));
                orders.setDepartureDate(Form.getInt(req, "DepartureDate"));
                orders.setTotalPrice((orders.getDepartureDate()-orders.getArrivalDate())*rooms.getPriceForDay());
                //orders.setTotalPrice(Form.getInt(req,"TotalPrice"));
                orders.setFK_rooms(Form.getInt(req, "FK_rooms"));
                orders.setFK_persons(Form.getInt(req,"FK_persons"));

                req.setAttribute(Messages.msgMessage,orders);
                if (orders.getID()>0){
                    dao.orders.update(orders);
                }
                if (orders.getID()<0){
                    orders.setID(orders.getID()*(-1));
                    dao.orders.delete(orders);
                }
                if (orders.getID()==0){
                    dao.orders.create(orders);
                }

            } catch (ParseException e) {
                e.printStackTrace();
                req.setAttribute(Messages.msgMessage,"Ошибка!!");
            }
        }
        req.setAttribute("orderss",dao.orders.getAll(""));
        return null;
    }
}
