package by.it.shkantau.project.java.dao;

import by.it.shkantau.project.java.beans.Airhostess;
import by.it.shkantau.project.java.connection.ConnectionCreator;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AirhostessDAO extends AbstractDAO implements IDAO <Airhostess> {
    @Override
    public Airhostess read(int id) {
        List<Airhostess> airhostesses =  getAll("WHERE airhostesses_id=" + id + " LIMIT 0,1");
        return (airhostesses.size() > 0) ? airhostesses.get(0) : null;
    }

    @Override
    public int create(Airhostess entity) {
        String sql = String.format("INSERT INTO airhostesses(name, birthDay) VALUES('%s','%s');",
                entity.getName(), entity.getBirthDay());
//        entity.setId(executeUpdate(sql));
        return executeUpdate(sql);
    }

    @Override
    public boolean update(Airhostess entity) {
        String sql = String.format("UPDATE `airhostesses` SET `name`='%s', `birthDay`='%s' WHERE `airhostesses`.`airhostesses_id` = %d;",
                entity.getName(), entity.getBirthDay(), entity.getId());
        return (0<executeUpdate(sql));
    }

    @Override
    public boolean delete(Airhostess entity) {
        String sql = String.format("DELETE FROM `airhostesses` WHERE  `airhostesses`.`airhostesses_id`=%d;", entity.getId());
        executeUpdate(sql);
        return (0<executeUpdate(sql));
    }

    @Override
    public List<Airhostess> getAll(String WhereAndOrder) {
        List<Airhostess> airhostesses = new ArrayList<>();
        String sql = "SELECT * FROM airhostesses " + WhereAndOrder + ";";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                airhostesses.add(new Airhostess(resultSet.getInt("airhostesses_id"),resultSet.getString("name"), resultSet.getDate("birthDay")));
            }

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return airhostesses;
    }
}
