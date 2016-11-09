package by.it.voronovich.project.java;

import by.it.voronovich.project.java.bean.CatalogGood;
import by.it.voronovich.project.java.bean.Order;
import by.it.voronovich.project.java.bean.User;
import by.it.voronovich.project.java.dao.DAO;
import by.it.voronovich.project.java.dao.OrderDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandShowOrder implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.SHOWORDER.inPage;

        User user = (User) request.getSession(true).getAttribute("user");
        if (user != null) {
            List<Order> listOrder = new OrderDAO().getAll("WHERE FK_Users=" + user.getIdUsers());
            int count = 0;
            for (Order e : listOrder) {
                if (e.getFK_Users() == user.getIdUsers()) {
                    int id = e.getFK_Catalog();
                    CatalogGood cg = DAO.getDAO().cg.read(id);
                    count += cg.getPrice();
                }
            }
            if (!listOrder.isEmpty()) {
                request.setAttribute("listOrder", listOrder);
                request.setAttribute("count", count);
            }
        } else {
            request.setAttribute(Action.msgMessage, "Для работы с корзиной покупок осуществите авторизацию");
        }

        DAO dao = DAO.getDAO();
        if (request.getParameter("idShoppingCart") != null) {
            List<Order> listOrder = new OrderDAO().getAll("WHERE idShoppingCart=" +
                    Integer.parseInt(request.getParameter("idShoppingCart")));
            Order order = listOrder.get(0);
            if (dao.order.delete(order)) {
                request.setAttribute(
                        Action.msgMessage,
                        "Заказ был успешно отменен.");
                page = Action.SHOWORDER.okPage;
            }
        }
        return page;
    }
}
