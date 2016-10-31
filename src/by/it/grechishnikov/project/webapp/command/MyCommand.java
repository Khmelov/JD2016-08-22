package by.it.grechishnikov.project.webapp.command;

import by.it.grechishnikov.project.webapp.bean.Order;
import by.it.grechishnikov.project.webapp.bean.User;
import by.it.grechishnikov.project.webapp.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        String login = "";
        for(Cookie cookie : cookies) {
            if(cookie.getName().equalsIgnoreCase("login")) {
                login = cookie.getValue();
                return "/test.html";
            }
        }
        HttpSession session = req.getSession(true);
        try {
            String out = req.getParameter("logout");
            if(out.equals("yes")) {
                session.invalidate();
                return Commands.INDEX.message;
            }
            User user = (User) session.getAttribute("user");
            if(!user.getLogin().isEmpty()) {
                return "/test.html";
            }
            List<Order> list = DAO.getInstance().getOrdersDAO().getAll();
            req.setAttribute("login", user.getLogin());
            req.setAttribute("email", user.getEmail());
            List<Order> orders = new ArrayList<>();
            for(Order o : list) {
                if(o.getUser() == user.getId()) {
                    orders.add(o);
                }
            }
            req.setAttribute("ordersList", orders);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Commands.MY.message;
    }
}
