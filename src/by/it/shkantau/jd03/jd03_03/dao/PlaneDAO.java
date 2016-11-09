package by.it.shkantau.jd03.jd03_03.dao;

import by.it.shkantau.jd03.jd03_03.beans.Plane;
import by.it.shkantau.jd03.jd03_03.connection.ConnectionCreator;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaneDAO extends AbstractDAO implements IDAO<Plane>{


    @Override
    public Plane read(int id) {
        List<Plane> planes =  getAll("WHERE plane_id=" + id + " LIMIT 0,1");
        return (planes.size() > 0) ? planes.get(0) : null;
    }

    @Override
    public int create(Plane entity) {
        String sql = String.format("INSERT INTO planes(planeName) VALUES('%s');",
                entity.getPlaneName());
        entity.setId(executeUpdate(sql));
        return executeUpdate(sql);
    }

    @Override
    public boolean update(Plane entity) {
        String sql = String.format("UPDATE `planes` SET `planeName`='%s' WHERE `planes`.`plane_id` = %d;",
                entity.getPlaneName(), entity.getId());
        return (0<executeUpdate(sql));
    }

    @Override
    public boolean delete(Plane entity) {
        String sql = String.format("DELETE FROM `planes` WHERE  `planes`.`plane_id`=%d;", entity.getId());
        executeUpdate(sql);
        return (0<executeUpdate(sql));
    }

    @Override
    public List<Plane> getAll(String WhereAndOrder) {
        List<Plane> users = new ArrayList<>();
        String sql = "SELECT * FROM planes " + WhereAndOrder + ";";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                users.add(new Plane(resultSet.getInt("plane_id"),resultSet.getString("planeName")));
            }
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
