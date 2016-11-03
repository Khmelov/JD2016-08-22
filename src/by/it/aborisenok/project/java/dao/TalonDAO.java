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
        return null;
    }

    @Override
    public boolean create(Talon entity) {
        return false;
    }

    @Override
    public boolean update(Talon entity) {
        return false;
    }

    @Override
    public boolean delete(Talon entity) {
        return false;
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
