package by.it.dubatovka.jd03_02.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ObjectsCRUD {
    public Objects create(Objects objects) throws SQLException {
        objects.setID(0);
        String createObjectsSQL = String.format("insert into objects(zia) values ('%s')", objects.getZia());

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            if (statement.executeUpdate(createObjectsSQL) == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    objects.setID(resultSet.getInt(1));
                }
            }
        } catch (SQLException sqle) {
            throw sqle;
        }
        return objects;
    }

    public Objects read(int ID) throws SQLException {
        Objects objectsResult = null;
        String readObjectsSQL = "SELECT * FROM objects WHERE objects.ID=" + ID;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();) {
            final ResultSet resultSet = statement.executeQuery(readObjectsSQL);
            if (resultSet.next()) {
                objectsResult = new Objects(
                        resultSet.getInt("ID"),
                        resultSet.getString("zia"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return objectsResult;
    }

    public Objects update(Objects object) throws SQLException {
        Objects objectResult = null;
        String updateObjectSQL = String.format("UPDATE objects SET zia = '%s' WHERE objects.ID='%d'",
                object.getZia(), object.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()) {
            if (statement.executeUpdate(updateObjectSQL) == 1)
                objectResult = object;
        } catch (SQLException e) {
            throw e;
        }
        return objectResult;
    }

    public boolean delete(Objects object) throws SQLException {
        String deleteObjectSQL = String.format("DELETE FROM objects Where objects.ID = '%d'", object.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();) {
            return (statement.executeUpdate(deleteObjectSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
