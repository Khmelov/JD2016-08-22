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
            case "logout": return logoutCommand(req);
            default    :
                req.getSession().setAttribute("message", "Неправильная команда");
                return Commands.ERROR.message;
        }
    }

    private String logoutCommand(HttpServletRequest req) {
        req.getSession().invalidate();
        return Commands.INDEX.message;
    }

    private static String addCommand(HttpServletRequest req) {
        try {
            //получаем товар
            int goodsId = Integer.parseInt(req.getParameter("id")) - 1;
            //достаем пользователя
            User user = (User) req.getSession().getAttribute("user");
            //Добавляем заказ
            DAO.getInstance().getOrdersDAO().create(new Order(user.getId(), ++goodsId));
        } catch (Exception e) {
            req.getSession().setAttribute("message", "Войдите в систему, что бы сделать покупку.");
            return Commands.ERROR.message;
        }
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
        User user = (User) req.getSession().getAttribute("user");
        int id = user.getId();
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
