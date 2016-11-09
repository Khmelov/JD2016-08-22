package by.it.grechishnikov.project.webapp.java.command;

import by.it.grechishnikov.project.webapp.java.bean.Goods;
import by.it.grechishnikov.project.webapp.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

class SearchCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        //удаляем старый поиск
        req.getSession().removeAttribute("result");
        String searchLine = req.getParameter("search").toLowerCase();
        List<Goods> catalog = DAO.getInstance().getGoodsDAO().getAll();
        if(searchLine.isEmpty()) {
            //если запрос пустой, то выводим весь каталог
            req.getSession().setAttribute("result", catalog);
            return Commands.SEARCH.message;
        }
        List<Goods> result = new ArrayList<>();
        for(Goods goods : catalog) {
            String name = goods.getName().toLowerCase();
            String description = goods.getDescription().toLowerCase();
            //Если название или описание содержат строку запроса, то выводим данный объект
            if(name.contains(searchLine) || description.contains(searchLine)) {
                result.add(goods);
            }
        }
        req.getSession().setAttribute("result", result);
        return Commands.SEARCH.message;
    }
}
