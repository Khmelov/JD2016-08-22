package by.it.grechishnikov.project.webapp.java.command;

import by.it.grechishnikov.project.webapp.java.bean.Goods;
import by.it.grechishnikov.project.webapp.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

class CatalogCommand implements Command {
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        List<Goods> catalog = DAO.getInstance().getGoodsDAO().getAll();
        req.getSession().setAttribute("catalog", catalog);
        return Commands.CATALOG.message;
    }
}
