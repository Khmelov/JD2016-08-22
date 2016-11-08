package by.it.aborisenok.project.java.dao;


import by.it.aborisenok.project.java.beans.Talon;
import by.it.aborisenok.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aborisenok on 26.10.2016.
 */
public class TalonDAO extends AbstractDAO implements InterfaceDAO<Talon> {
    @Override
    public Talon read(int id) {
        List<Talon> talons = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (talons.size() > 0) {
            return talons.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Talon talon) {
        String createTalonSQL = String.format(
                "INSERT INTO `talon` (FK_Policlinic, FK_User, FK_Doctor, FK_VisitDate) " +
                        "values('%d','%d','%d','%d');",
                talon.getFK_Policlinic(),
                talon.getFK_User(),
                talon.getFK_Doctor(),
                talon.getFK_VisitDate());
        talon.setID(executeUpdate(createTalonSQL));
        return (talon.getID()>0);
    }

    @Override
    public boolean update(Talon talon) {

        String updateTalonSQL = String.format(
                "UPDATE `talon` SET FK_Policlinic = '%d', " +
                        "FK_User = '%d', " +
                        "FK_Doctor = '%d', " +
                        "FK_VisitDate = '%d'" +
                        " WHERE talon.ID = %d",
                talon.getFK_Policlinic(),
                talon.getFK_User(),
                talon.getFK_VisitDate(),
                talon.getFK_VisitDate(),
                talon.getID()
        );
        return (0 < executeUpdate(updateTalonSQL));
    }

    @Override
    public boolean delete(Talon talon) {
        String sql = String.format(
                "DELETE FROM `talon` WHERE `talon`.`ID` = %d;", talon.getID()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Talon> getAll(String WHERE) {
        List<Talon> talons = new ArrayList<>();
        String sql = "SELECT * FROM talon " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Talon talon = new Talon();
                talon.setID(rs.getInt("ID"));
                talon.setFK_Policlinic(rs.getInt("FK_Policlinic"));
                talon.setFK_User(rs.getInt("FK_User"));
                talon.setFK_Doctor(rs.getInt("FK_Doctor"));
                talon.setFK_VisitDate(rs.getInt("FK_VisitDate"));

                talons.add(talon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  talons;
    }
}
