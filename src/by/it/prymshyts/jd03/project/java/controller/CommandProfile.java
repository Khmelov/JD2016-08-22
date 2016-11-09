package by.it.prymshyts.jd03.project.java.controller;

import by.it.prymshyts.jd03.project.java.beans.Article;
import by.it.prymshyts.jd03.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class CommandProfile implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        DAO dao = DAO.getDAO();

        if (FormHelper.isPost(request)) {
            Article article = new Article();

            try {
                article.setID(FormHelper.getInt(request, "ID"));
                article.setTitle(FormHelper.getString(request, "Title", ".*"));
                article.setInfo(FormHelper.getString(request, "Info", ".*"));
                request.setAttribute(Action.msgMessage, article);

                if (article.getID() > 0){
                    dao.getArticleDAO().update(article);
                }
                if (article.getID() < 0){
                    article.setID(article.getID() * (-1));
                    dao.getArticleDAO().delete(article);
                }

            } catch (ParseException e) {
                e.printStackTrace();
                request.setAttribute(Action.msgError, "Ошибка!");
            }
        }

        List<Article> articleList = dao.getArticleDAO().getAll();
        request.setAttribute("articles", articleList);

        return Action.PROFILE.inPage;
    }
}
