package by.it.filimonchik.jd03_02.crud;

import by.it.filimonchik.jd03_02.Connection.ConnectionCreator;
import by.it.filimonchik.jd03_02.bean.Car_body;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class Car_bodyRead {
    public Car_body read(int id) throws SQLException {
        Car_body car_bodyResult = null;
        String readCar_bodySQL = "SELECT * FROM car_body where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readCar_bodySQL);
            if (resultSet.next()) {
                car_bodyResult = new Car_body(
                        resultSet.getInt("ID"),
                        resultSet.getString("Car_body"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return car_bodyResult;
    }
}
