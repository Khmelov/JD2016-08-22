package by.it.zaharova.JD03_03.custom_dao;

import by.it.zaharova.JD03_03.beans.Status;
import by.it.zaharova.JD03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO extends AbstractDAO implements InterfaceDAO<Status> {
    @Override
    public List<Status> getAll(String WHERE) {
        List<Status> statuss = new ArrayList<>();
        String sql = "SELECT * FROM status " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Status status = new Status();
                status.setID(rs.getInt("ID"));
                status.setPatient_status(rs.getString("Patient_status"));
                status.setFK_diagnostic(rs.getInt("FK_diagnostic"));
                statuss.add(status);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return statuss;
    }

    @Override
    public Status read(int id) {
        List<Status> status = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (status.size() > 0) {
            return status.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(Status status) {
        String sql = String.format(
                "insert into status(Patient_status,FK_diagnostic) values('%s',%d);",
                status.getPatient_status(), status.getFK_diagnostic()
        );
        status.setID(executeUpdate(sql));
        return (status.getID()>0);
    }
    @Override
    public boolean update(Status status) {
        String sql = String.format(
                "UPDATE status SET Patient_status = '%s', FK_diagnostic=%d WHERE status.ID = %d",
                status.getPatient_status(), status.getFK_diagnostic(), status.getID()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(Status status) {
        String sql = String.format(
                "DELETE FROM `status` WHERE `status`.`ID` = %d;", status.getID()
        );
        return (0 < executeUpdate(sql));
    }


}
