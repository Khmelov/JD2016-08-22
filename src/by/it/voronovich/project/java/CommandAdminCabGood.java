package by.it.voronovich.project.java;

import by.it.voronovich.project.java.bean.CatalogGood;
import by.it.voronovich.project.java.dao.CatalogGoodDAO;
import by.it.voronovich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandAdminCabGood implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.ADMINCABGOOD.inPage;

        List<CatalogGood> goodList = new CatalogGoodDAO().getAll("");
        if (!goodList.isEmpty()) {
            request.setAttribute("goodList", goodList);
        }
        DAO dao= DAO.getDAO();
        if (FormHelper.isPost(request)){
            CatalogGood cg=new CatalogGood();
            try {
                cg.setIdCatalog(Integer.parseInt(request.getParameter("idCatalog")));
                cg.setBrand(request.getParameter("Brand"));
                cg.setModel(request.getParameter("Model"));
                cg.setPrice(Double.parseDouble(request.getParameter("Price")));
                cg.setReleaseDate(request.getParameter("ReleaseDate"));
                cg.setWeight(request.getParameter("Weight"));
                if (cg.getIdCatalog()>0){
                    if(dao.cg.update(cg)) {
                        request.setAttribute(Action.msgMessage, "Изменения приняты");
                        page = Action.ADMINCABGOOD.okPage;
                    }
                }
                if (cg.getIdCatalog()<0){
                    cg.setIdCatalog(cg.getIdCatalog()*(-1));
                    if(dao.cg.delete(cg)){
                        request.setAttribute(Action.msgMessage, "Товар удален");
                        page = Action.ADMINCABGOOD.okPage;
                    }
                }
                if (cg.getIdCatalog()==0){
                    if(dao.cg.create(cg)){
                        request.setAttribute(Action.msgMessage, "Товар добавлен");
                        page = Action.ADMINCABGOOD.okPage;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute(Action.msgMessage,"Ошибка!!!");
            }
        }
        request.setAttribute("goodList",dao.cg.getAll(""));
        return page;
    }
}