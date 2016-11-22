package by.it.filimonchik.project.java.dao;

import by.it.filimonchik.project.java.dao.Connection.ConnectionCreator;
import by.it.filimonchik.project.java.bean.Car_body;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raman.Filimonchyk on 08/11/2016.
 */
    public class Car_bodyDAO extends AbstractDAO implements IDAO<Car_body> {
        @Override
        public List<Car_body> getAll(String WHERE) {
            List<Car_body> car_bodys = new ArrayList<>();
            String sql = "SELECT * FROM car_body " + WHERE + " ;";
            try (Connection connection = ConnectionCreator.getConnection();
                 Statement statement = connection.createStatement()
            ) {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    Car_body car_body = new Car_body();
                    car_body.setID(rs.getInt("ID"));
                    car_body.setCar_body(rs.getString("Car_body"));
                    car_bodys.add(car_body);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return car_bodys;
        }

        @Override
        public Car_body read(int id) {
            List<Car_body> car_bodys = getAll("WHERE ID=" + id + " LIMIT 0,1");
            if (car_bodys.size() > 0) {
                return car_bodys.get(0);
            } else
                return null;
        }

        @Override
        public boolean create(Car_body entity) {
            return false;
        }

        @Override
        public boolean update(Car_body entity) {
            return false;
        }

        @Override
        public boolean delete(Car_body entity) {
            return false;
        }
    }
