package by.it.prymshyts.jd03.project.java.controller;

import by.it.prymshyts.jd03.project.java.beans.Article;
import by.it.prymshyts.jd03.project.java.beans.User;
import by.it.prymshyts.jd03.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandShowArticles implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        DAO dao = DAO.getDAO();

        List<User> userList       = dao.getUserDAO().getAll();
        List<Article> articleList = dao.getArticleDAO().getAll();
        request.setAttribute("users", userList);
        request.setAttribute("articles", articleList);

        return Action.SHOWARTICLES.inPage;
    }
}
