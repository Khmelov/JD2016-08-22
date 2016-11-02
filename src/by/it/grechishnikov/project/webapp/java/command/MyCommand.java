package by.it.grechishnikov.project.webapp.java.command;

import by.it.grechishnikov.project.webapp.java.bean.*;
import by.it.grechishnikov.project.webapp.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

class MyCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        //Ищем в сессии юзера
        HttpSession session = req.getSession(true);
        try {
            User user = (User) session.getAttribute("user");
            session.setAttribute("jsp_message", user.toString());
            //Добавляем в сессию список товаров пользователя
            List<Order> list = DAO.getInstance().getOrdersDAO().getAll();
            List<Order> orders = new ArrayList<>();
            for(Order o : list) {
                if(o.getUser() == user.getId()) {
                    orders.add(o);
                }
            }
            req.getSession().setAttribute("ordersList", orders);

            List<Goods> catalog = DAO.getInstance().getGoodsDAO().getAll();
            req.getSession().setAttribute("catalog", catalog);
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("jsp_error", "ошибка логина");
        }
        return Commands.MY.message;
    }
}