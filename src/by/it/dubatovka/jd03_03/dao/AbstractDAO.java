package by.it.dubatovka.jd03_03.dao;

import by.it.dubatovka.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
    protected int executeUpdate(String sql) {
        int result = -1;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql);
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    result = resultSet.getInt(1);
                }
            }
        } catch (SQLException sqle) {
          sqle.printStackTrace();
        }
        return result;
    }


}
