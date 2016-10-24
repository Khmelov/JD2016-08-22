package by.it.prymshyts.jd03.jd03_03.dao;

import by.it.prymshyts.jd03.DB;
import by.it.prymshyts.jd03.jd03_03.beans.Article;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO extends DAO implements InterfaceDAO<Article> {
    @Override
    public Article read(int id) {
        List<Article> articles = getAll("WHERE ID=" + id + " LIMIT 0,1;");
        if (articles.size() > 0) {
            return articles.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean create(Article article) {
        String createUserSQL = String.format(
                "INSERT INTO Article(Title, Info, FK_User)" +
                        " VALUES('%s', '%s', %d);",
                article.getTitle(),
                article.getInfo(),
                article.getFK_User());
        return (0 < executeUpdate(createUserSQL));
    }

    @Override
    public boolean update(Article article) {
        String updateUserSQL = String.format(
                "UPDATE Article SET Title='%s'," +
                        " Post_date=%d, Info='%s'" +
                        " WHERE Article.ID=%d;",
                article.getTitle(),
                article.getPost_date(),
                article.getInfo(),
                article.getID());
        return (0 < executeUpdate(updateUserSQL));
    }

    @Override
    public boolean delete(Article article) {
        String deleteUserSQL = String.format(
                "DELETE FROM Article WHERE Article.ID=%d", article.getID());
        return (0 < executeUpdate((deleteUserSQL)));
    }

    @Override
    public List<Article> getAll() {
        return getAll("");
    }

    @Override
    public List<Article> getAll(String condition) {
        List<Article> articles = new ArrayList<>();
        String getAllSQL = "SELECT * FROM Article " + condition + ";";

        try (Connection connection = DB.getConnection();
             Statement statement   = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(getAllSQL);
            while (resultSet.next()) {
                articles.add(new Article(
                        resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getInt("Post_date"),
                        resultSet.getString("Info"),
                        resultSet.getInt("FK_User")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articles;
    }
}
