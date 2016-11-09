package by.it.shkantau.project.java.dao;


import by.it.shkantau.project.java.beans.Airport;
import by.it.shkantau.project.java.connection.ConnectionCreator;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AirportsDAO extends AbstractDAO implements IDAO<Airport> {
    @Override
    public Airport read(int id) {
        List<Airport> airports =  getAll("WHERE airports_id=" + id + " LIMIT 0,1");
        return (airports.size() > 0) ? airports.get(0) : null;
    }

    @Override
    public int create(Airport entity) {
        String sql = String.format("INSERT INTO airports(acronim, name) VALUES('%s','%s');",
                 entity.getAcronim(), entity.getName());
//        entity.setId(executeUpdate(sql));
        return executeUpdate(sql);
    }

    @Override
    public boolean update(Airport entity) {
        String sql = String.format("UPDATE `airports` SET `acronim`='%s', `name`='%s' WHERE `airports`.`airports_id` = %d;",
                entity.getAcronim(), entity.getName(), entity.getId());
        return (0<executeUpdate(sql));
    }

    @Override
    public boolean delete(Airport entity) {
        String sql = String.format("DELETE FROM `airports` WHERE  `airports`.`airports_id`=%d;", entity.getId());
        executeUpdate(sql);
        return (0<executeUpdate(sql));
    }

    @Override
    public List<Airport> getAll(String WhereAndOrder) {
        List<Airport> airports = new ArrayList<>();
        String sql = "SELECT * FROM airports " + WhereAndOrder + ";";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                airports.add(new Airport(resultSet.getInt("airports_id"),resultSet.getString("acronim"),
                        resultSet.getString("name")));
            }

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return airports;
    }
}
