package by.it.voronovich.project.java;

import by.it.voronovich.project.java.bean.CatalogGood;
import by.it.voronovich.project.java.bean.Order;
import by.it.voronovich.project.java.bean.User;
import by.it.voronovich.project.java.dao.CatalogGoodDAO;
import by.it.voronovich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandCatalog implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.CATALOG.inPage;

        List<CatalogGood> listCatalog = new CatalogGoodDAO().getAll("");
        if (!listCatalog.isEmpty()) {
            request.setAttribute("listCatalog", listCatalog);
        }

        DAO dao = DAO.getDAO();
        if (request.getParameter("idCatalog") != null) {
            try {
                User user = (User) request.getSession(true).getAttribute("user");
                int fku = user.getIdUsers();
                Order order = new Order();
                order.setFK_Catalog(Integer.parseInt(request.getParameter("idCatalog")));
                order.setFK_Users(fku);
                if (dao.order.create(order)) {
                    request.setAttribute(
                            Action.msgMessage,
                            "Товар был успешно добавлен в перечень Ваших заказов.");
                    page = Action.CATALOG.okPage;
                }
            } catch (NullPointerException e) {
                request.setAttribute(
                        Action.msgMessage,
                        "Для осуществления заказа требуется авторизация");
                page = Action.CATALOG.inPage;
            }
        }
        return page;
    }
}
