package by.it.prymshyts.jd03.jd03_02.CRUD;

import by.it.prymshyts.jd03.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ArticleCRUD {

    public boolean create(Article article) throws SQLException {
        article.setID(0);
        String createUserSQL = String.format(
                "INSERT INTO Article(Title, Info, FK_User)" +
                        " VALUES('%s', '%s', %d);",
                article.getTitle(),
                article.getInfo(),
                article.getFK_User());

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(createUserSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }

    public Article read(int id) throws SQLException {
        Article articleResult = null;
        String readUserSQL = String.format(
                "SELECT * FROM Article WHERE ID=%d", id);

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                articleResult = new Article(
                        resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getInt("Post_date"),
                        resultSet.getString("Info"),
                        resultSet.getInt("FK_User")
                );
            }
        } catch (SQLException e) {
            throw e;
        }

        return articleResult;
    }

    public boolean update(Article article) throws SQLException {
        String updateUserSQL = String.format(
                "UPDATE Article SET Title='%s'," +
                        " Post_date=%d, Info='%s'" +
                        " WHERE Article.ID=%d;",
                article.getTitle(),
                article.getPost_date(),
                article.getInfo(),
                article.getID());

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(updateUserSQL) == 1);
        } catch (SQLException e) {
            throw  e;
        }
    }

    public boolean delete(Article article) throws SQLException {
        String deleteUserSQL = String.format(
                "DELETE FROM Article WHERE Article.ID=%d", article.getID());

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteUserSQL) == 1);
        } catch (SQLException e) {
            throw  e;
        }
    }

    public ArrayList<Article> getAll() throws SQLException {
        ArrayList<Article> articleArrayList = new ArrayList<>();
        String getAllSQL = "SELECT * FROM Article;";

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()
        ) {


            ResultSet resultSet = statement.executeQuery(getAllSQL);
            while (resultSet.next()) {
                articleArrayList.add(new Article(
                        resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getInt("Post_date"),
                        resultSet.getString("Info"),
                        resultSet.getInt("FK_User")
                ));
            }
        } catch (SQLException e) {
            throw e;
        }

        return articleArrayList;
    }
}
