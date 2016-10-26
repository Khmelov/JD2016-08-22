package by.it.prymshyts.jd03.jd03_03.dao;

import by.it.prymshyts.jd03.DB;

import java.sql.Connection;
import java.sql.Statement;

public class DAO {

    private static  DAO dao = null;

    private RoleDAO roleDAO;
    private UserDAO userDAO;
    private ArticleDAO articleDAO;

    protected DAO() {}

    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                dao = new DAO();

                dao.roleDAO    = new RoleDAO();
                dao.userDAO    = new UserDAO();
                dao.articleDAO = new ArticleDAO();
            }
        }
        return dao;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public ArticleDAO getArticleDAO() {
        return articleDAO;
    }

    protected int executeUpdate(String sql) {
        int result = -1;

        try (Connection connection = DB.getConnection();
            Statement statement   = connection.createStatement()
        ) {
            result = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
