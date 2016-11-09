package by.it.opiga.JD03_04.Project.java.controller;

import by.it.opiga.JD03_04.Project.java.beans.mybeans.Order;
import by.it.opiga.JD03_04.Project.java.dao.myDAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CmdCreateOrder extends Action {
    @Override
    Action execute(HttpServletRequest req,HttpServletResponse resp) {
        Order order = new Order();
        try {
            order.setFio(req.getParameter("fio"));
            order.setPassport(req.getParameter("passport"));
            order.setPhone(Integer.parseInt(req.getParameter("phone")));
            order.setCategory(req.getParameter("category"));
            order.setPayment(req.getParameter("payment"));
            order.setFK_user(Integer.parseInt(req.getParameter("FK_user")));
            order.setFK_status(Integer.parseInt(req.getParameter("FK_status")));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                Date d=sdf.parse(req.getParameter("leavee"));
                long ml=d.getTime();
                order.setLeave(ml);

                Date d2=sdf.parse(req.getParameter("arrive"));
                long m2=d2.getTime();
                order.setArrive(m2);



        } catch (Exception e) {
            req.setAttribute(Messages.msgError, "NO VALID FIELDS");
            return null;
        }
        DAO dao = DAO.getDAO();
        if (dao.order.create(order)) {
            req.setAttribute(Messages.msgMessage, "ORDER ADDED");
            return Actions.CREATEORDER.action;
        } else
            req.setAttribute(Messages.msgError, "FILL ERROR");
        return null;
    }

//    public static void main(String[] args) {
////        Timestamp unixTime=new Timestamp(1452546660000);
//        String unixTime = "1452546660000";
//        long s=Long.parseLong(unixTime);
//        System.out.println(s);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//        Date resultdate = new Date(s);
//        System.out.println(sdf.format(resultdate));
//    }
}
