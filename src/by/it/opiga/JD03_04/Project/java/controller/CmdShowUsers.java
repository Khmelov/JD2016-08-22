package by.it.opiga.JD03_04.Project.java.controller;

import by.it.opiga.JD03_04.Project.java.beans.mybeans.Order;
import by.it.opiga.JD03_04.Project.java.beans.mybeans.User;
import by.it.opiga.JD03_04.Project.java.dao.myDAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

public class CmdShowUsers extends Action{

//    private String debugOut(List<User> users) {
//        StringBuilder out=new StringBuilder();
//        for (User user:users){
//            out.append(user.toString()).append("<br>");
//        }
//        return out.toString();
//    }

    @Override
    Action execute(HttpServletRequest req,HttpServletResponse resp) {
        User user=new User();

        Order order=new Order();
        HttpSession session=req.getSession();
        User amd=(User)session.getAttribute("user");

        if (amd==null) {
            return Actions.LOGIN.action;

        }
        else {
            int idRole = amd.getFK_role();
            if (idRole != 2) {
                req.setAttribute(Messages.msgMessage, "You don't have enough rights!");
                return Actions.LOGOUT.action;
            }
            else {

                DAO dao = DAO.getDAO();
                if (Form.isPost(req)) {
                    try {
                        user.setID(Form.getInt(req, "ID"));
                        user.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
                        user.setPass(Form.getString(req, "Password", Patterns.PASSWORD));
                        user.setEmail(Form.getString(req, "Email", Patterns.EMAIL));
                        user.setFK_role(Form.getInt(req, "fk_Role"));
                        if (user.getID() > 0) {
                            dao.user.update(user);
                        }
                        if (user.getID() < 0) {
                            user.setID(user.getID() * (-1));
                            order.setFK_user(user.getID());
                            dao.order.delete(order);
                            dao.user.delete(user);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                        req.setAttribute(Messages.msgMessage, e.getMessage());
                    }
                }
                req.setAttribute("users",dao.user.getAll(""));
                req.setAttribute("roles",dao.role.getAll(""));
            }
        }
        return null;
    }
}
