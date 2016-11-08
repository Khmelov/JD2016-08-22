package by.it.aborisenok.project.java.dao;


import by.it.aborisenok.project.java.beans.Policlinic;
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
public class PoliclinicDAO extends AbstractDAO implements InterfaceDAO<Policlinic> {
    @Override
    public Policlinic read(int id) {
        List<Policlinic> policlinics = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (policlinics.size() > 0) {
            return policlinics.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Policlinic entity) {
        return false;
    }

    @Override
    public boolean update(Policlinic entity) {
        return false;
    }

    @Override
    public boolean delete(Policlinic entity) {
        return false;
    }

    @Override
    public List<Policlinic> getAll(String WHERE) {
        List<Policlinic> policlinics = new ArrayList<>();
        String sql = "SELECT * FROM policlinic " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Policlinic policlinic = new Policlinic();
                policlinic.setID(rs.getInt("ID"));
                policlinic.setName(rs.getString("Name"));
                policlinic.setCity(rs.getString("City"));
                policlinic.setStreet(rs.getString("Street"));
                policlinic.setHouse(rs.getInt("House"));


                policlinics.add(policlinic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return policlinics;
    }
}
