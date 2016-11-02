package by.it.grechishnikov.project.webapp.java.command;

import by.it.grechishnikov.project.webapp.java.bean.*;
import by.it.grechishnikov.project.webapp.java.dao.DAO;
import by.it.grechishnikov.project.webapp.java.dao.OrdersDAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

class OrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String command = req.getParameter("type");
        switch (command) {
            case "add" : return addCommand(req);
            case "sub" : return subCommand(req);
            case "buy" : return buyCommand(req);
            default    : return Commands.ERROR.message;
        }
    }

    private static String addCommand(HttpServletRequest req) {
        //получаем товар
        int goodsId = Integer.parseInt(req.getParameter("id")) - 1;
        //достаем пользователя
        Cookie[] cookies = req.getCookies();
        String login = "";
        for(Cookie c : cookies) {
            if(c.getName().equalsIgnoreCase("login")) {
                login = c.getValue();
            }
        }
        if(login.isEmpty()) {
            return Commands.ERROR.message;
        }
        User user = (User) req.getSession().getAttribute(login);
        //Добавляем заказ
        DAO.getInstance().getOrdersDAO().create(new Order(user.getId(), ++goodsId));
        return Commands.ORDER.message;
    }

    private static String subCommand(HttpServletRequest req) {
        //получаем индекс
        int goodsId = Integer.parseInt(req.getParameter("id"));
        //Удаляем заказ
        DAO.getInstance().getOrdersDAO().delete(goodsId);
        return Commands.ORDER.message;
    }

    private static String buyCommand(HttpServletRequest req) {
        //находим id пользователя
        Cookie[] cookies = req.getCookies();
        int id = -1;
        for(Cookie c : cookies) {
            if(c.getName().equalsIgnoreCase("id")) {
                id = Integer.parseInt(c.getValue());
            }
        }
        if(id == -1) {
            return Commands.ERROR.message;
        }
        //находим заказы пользователя
        List<Order> list = DAO.getInstance().getOrdersDAO().getAll();
        OrdersDAO dao = DAO.getInstance().getOrdersDAO();
        //удаляем их
        for (Order o : list) {
            if(o.getUser() == id) {
                dao.delete(o.getId());
            }
        }
        return Commands.ORDER.message;
    }
}
