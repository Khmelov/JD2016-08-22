package by.it.shkantau.project.java.dao;


import by.it.shkantau.project.java.beans.Crew;
import by.it.shkantau.project.java.connection.ConnectionCreator;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CrewDAO extends AbstractDAO implements IDAO<Crew> {


    @Override
    public Crew read(int id) {
        List<Crew> crews =  getAll("WHERE crew_id=" + id + " LIMIT 0,1");
        return (crews.size() > 0) ? crews.get(0) : null;
    }

    @Override
    public int create(Crew entity) {
        String sql = String.format("INSERT INTO crews(pilot1, pilot2, airHostess1, airHostess2) VALUES('%d','%d','%d','%d');",
                entity.getPilot1(), entity.getPilot2(), entity.getAirhostess1(), entity.getAirhostess2());
//        entity.setId(executeUpdate(sql));
        return executeUpdate(sql);
    }

    @Override
    public boolean update(Crew entity) {
        String sql = String.format("UPDATE `crews` SET `pilot1`='%d', `pilot2`='%d', `airHostess1`='%d', `airHostess1`='%d' WHERE `crews`.`crew_id` = %d;",
                entity.getPilot1(), entity.getPilot2(), entity.getAirhostess1(), entity.getAirhostess2(), entity.getId());
        return (0<executeUpdate(sql));
    }

    @Override
    public boolean delete(Crew entity) {
        String sql = String.format("DELETE FROM `crews` WHERE  `crews`.`crew_id`=%d;", entity.getId());
        executeUpdate(sql);
        return (0<executeUpdate(sql));
    }

    @Override
    public List<Crew> getAll(String WhereAndOrder) {
        List<Crew> crews = new ArrayList<>();
        String sql = "SELECT * FROM crews " + WhereAndOrder + ";";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                crews.add(new Crew(resultSet.getInt("crew_id"),resultSet.getInt("pilot1"),resultSet.getInt("pilot2"),
                        resultSet.getInt("airHostess1"),resultSet.getInt("airHostess1")));
            }

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return crews;
    }
}
