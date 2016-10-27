package by.it.dubatovka.jd03_02.crud;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatusCRUD {
    public Status create(Status status) throws SQLException {
        status.setIdStatus(0);
        String createStatusSQL = String.format("insert into status(statusName) values ('%s')", status.getStatusName());

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            if (statement.executeUpdate(createStatusSQL) == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    status.setIdStatus(resultSet.getInt(1));
                }
            }
        } catch (SQLException sqle) {
            throw sqle;
        }
        return status;
    }

    public Status read(int idStatus) throws SQLException {
        Status statusResult = null;
        String readStatusSQL = "SELECT * FROM status WHERE status.idStatus=" + idStatus;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();) {
            final ResultSet resultSet = statement.executeQuery(readStatusSQL);
            if (resultSet.next()) {
                statusResult = new Status(
                        resultSet.getInt("idStatus"),
                        resultSet.getString("statusName"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return statusResult;
    }

    public Status update(Status status) throws SQLException {
        Status statusResult = null;
        String updateStatusSQL = String.format("UPDATE status SET statusName = '%s' WHERE status.idStatus='%d'",
                status.getStatusName(), status.getIdStatus());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()) {
            if (statement.executeUpdate(updateStatusSQL) == 1)
                statusResult = status;
        } catch (SQLException e) {
            throw e;
        }
        return statusResult;
    }

    public boolean delete(Status status) throws SQLException {
        String deleteStatusSQL = String.format("DELETE FROM status Where status.idStatus = '%d'", status.getIdStatus());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()) {
            return (statement.executeUpdate(deleteStatusSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}



