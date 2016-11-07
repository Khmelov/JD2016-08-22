package by.it.filimonchik.jd03_02.crud;

import by.it.filimonchik.jd03_02.Connection.ConnectionCreator;
import by.it.filimonchik.jd03_02.bean.Color;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class ColorRead {
    public Color read(int id) throws SQLException {
        Color colorResult = null;
        String readColorSQL = "SELECT * FROM color where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readColorSQL);
            if (resultSet.next()) {
                colorResult = new Color(
                        resultSet.getInt("ID"),
                        resultSet.getString("Color"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return colorResult;
    }
}
