package by.it.prymshyts.jd03.project.java.controller;

import by.it.prymshyts.jd03.project.java.beans.Article;
import by.it.prymshyts.jd03.project.java.beans.User;
import by.it.prymshyts.jd03.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;

public class CommandCreateArticle implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return Action.LOGIN.inPage;
        }

        if (FormHelper.isPost(request)) {
            Article article = new Article();
            try {
                article.setTitle(FormHelper.getString(request,"Title",".*"));
                article.setInfo(FormHelper.getString(request,"Info",".*"));
                article.setFK_User(user.getID());
                Date date = new Date();
                article.setPost_date((int) date.getTime()/1000);

                DAO dao = DAO.getDAO();
                dao.getArticleDAO().create(article);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return Action.CREATEARTICLE.inPage;
    }
}
