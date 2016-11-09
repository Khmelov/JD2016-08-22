package by.it.shkantau.jd03.jd03_03.dao;


import by.it.shkantau.jd03.jd03_03.beans.Pilot;
import by.it.shkantau.jd03.jd03_03.connection.ConnectionCreator;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PilotDAO extends AbstractDAO implements IDAO <Pilot>{

    @Override
    public Pilot read(int id) {
        List<Pilot> pilots =  getAll("WHERE pilot_id=" + id + " LIMIT 0,1");
        return (pilots.size() > 0) ? pilots.get(0) : null;
    }

    @Override
    public int create(Pilot entity) {
        String sql = String.format("INSERT INTO pilots(name, birthDay, phone) VALUES('%s','%s','%s');",
                entity.getName(), entity.getPhoneNumber(), entity.getBirthDay());
//        entity.setId(executeUpdate(sql));
        return executeUpdate(sql);
    }

    @Override
    public boolean update(Pilot entity) {
        String sql = String.format("UPDATE `pilots` SET `name`='%s', `birthDay`='%s', `phone`='%s' WHERE `pilots`.`pilot_id` = %d;",
                entity.getName(), entity.getBirthDay(), entity.getPhoneNumber(),  entity.getId());
        return (0<executeUpdate(sql));
    }

    @Override
    public boolean delete(Pilot entity) {
        String sql = String.format("DELETE FROM `pilots` WHERE  `pilots`.`pilot_id`=%d;", entity.getId());
        executeUpdate(sql);
        return (0<executeUpdate(sql));
    }

    @Override
    public List<Pilot> getAll(String WhereAndOrder) {
        List<Pilot> pilots = new ArrayList<>();
        String sql = "SELECT * FROM pilots " + WhereAndOrder + ";";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                pilots.add(new Pilot(resultSet.getInt("pilot_id"),resultSet.getString("name"),
                        resultSet.getString("phone"), resultSet.getDate("birthDay")));
            }

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return pilots;
    }
}
