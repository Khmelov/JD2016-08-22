package by.it.dubatovka.jd03_02.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PriorityCRUD {
    public Priority create(Priority priority) throws SQLException {
        priority.setID(0);
        String createPrioritySQL = String.format("insert into priority(priorityName) values ('%s')", priority.getPriorityName());

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            if (statement.executeUpdate(createPrioritySQL) == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    priority.setID(resultSet.getInt(1));
                }
            }
        } catch (SQLException sqle) {
            throw sqle;
        }
        return priority;
    }

    public Priority read(int ID) throws SQLException {
        Priority priorityResult = null;
        String readPrioritySQL = "SELECT * FROM priority WHERE priority.ID=" + ID;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();) {
            final ResultSet resultSet = statement.executeQuery(readPrioritySQL);
            if (resultSet.next()) {
                priorityResult = new Priority(
                        resultSet.getInt("ID"),
                        resultSet.getString("priorityName"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return priorityResult;
    }

    public Priority update(Priority priority) throws SQLException {
        Priority priorityResult = null;
        String updatePrioritySQL = String.format("UPDATE priority SET priorityName = '%s' WHERE priority.ID='%d'",
                priority.getPriorityName(), priority.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()) {
            if (statement.executeUpdate(updatePrioritySQL) == 1)
                priorityResult = priority;
        } catch (SQLException e) {
            throw e;
        }
        return priorityResult;
    }

    public boolean delete(Priority priority) throws SQLException {
        String deletePrioritySQL = String.format("DELETE FROM priority Where priority.ID = '%d'", priority.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();) {
            return (statement.executeUpdate(deletePrioritySQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
