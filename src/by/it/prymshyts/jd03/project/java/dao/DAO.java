package by.it.prymshyts.jd03.project.java.dao;

import java.sql.Connection;
import java.sql.Statement;

public class DAO {

    private static DAO dao;

    private RoleDAO roleDAO;
    private UserDAO userDAO;
    private ArticleDAO articleDAO;

    private String lastSQL;

    protected DAO() {}

    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();

                    dao.roleDAO    = new RoleDAO();
                    dao.userDAO    = new UserDAO();
                    dao.articleDAO = new ArticleDAO();
                }
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

    public String getLastSQL() {
        return lastSQL;
    }

    protected int executeUpdate(String sql) {
        int result = -1;

        try (Connection connection = DB.getConnection();
             Statement statement   = connection.createStatement()
        ) {
            lastSQL = "executeUpdate:" + sql;
            result = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
