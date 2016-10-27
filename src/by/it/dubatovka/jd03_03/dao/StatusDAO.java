package by.it.dubatovka.jd03_03.dao;


import by.it.dubatovka.jd03_02.crud.ConnectionCreator;
import by.it.dubatovka.jd03_02.crud.Status;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO extends AbstractDAO implements InterfaceDAO<Status> {
    @Override
    public Status read(int id) {
        List<Status> statuses = getAll("WHERE ID=" + id + " LIMIT 0,1;");
        if (statuses.size() > 0) return statuses.get(0);
        else return null;
    }

    @Override
    public boolean create(Status status) {
        String createStatusSQL = String.format("insert into status(statusName) values ('%s')", status.getStatusName());
        status.setID(executeUpdate(createStatusSQL));
        return (status.getID() > 0);
    }

    @Override
    public boolean update(Status status) {
        String updateStatusSQL = String.format("UPDATE status SET statusName = '%s' WHERE status.ID='%d'",
                status.getStatusName(), status.getID());
        return (executeUpdate(updateStatusSQL) > 0);
    }

    @Override
    public boolean delete(Status status) {
        String deleteStatusSQL = String.format("DELETE FROM status WHERE status.ID = '%d'", status.getID());
        return (0 < executeUpdate(deleteStatusSQL));
    }

    @Override
    public List<Status> getAll(String WhereAndOrder) {
        List<Status> statuses = new ArrayList<>();
        String sql = "SELECT * FROM status " + WhereAndOrder + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Status status = new Status();
                status.setID(rs.getInt("ID"));
                status.setStatusName(rs.getString("statusName"));
                statuses.add(status);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return statuses;
    }
}
