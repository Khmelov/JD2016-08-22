package by.it.filimonchik.jd03_02.crud;

import by.it.filimonchik.jd03_02.Connection.ConnectionCreator;
import by.it.filimonchik.jd03_02.bean.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class ModelRead {
    public Model read(int id) throws SQLException {
        Model modelResult = null;
        String readModelSQL = "SELECT * FROM model where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readModelSQL);
            if (resultSet.next()) {
                modelResult = new Model(
                        resultSet.getInt("ID"),
                        resultSet.getString("Model"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return modelResult;
    }
}
