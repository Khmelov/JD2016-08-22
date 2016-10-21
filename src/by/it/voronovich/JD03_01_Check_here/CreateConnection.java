package by.it.voronovich.JD03_01_Check_here;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

import static by.it.voronovich.JD03_01_Check_here.CN.PASSWORD_DB;
import static by.it.voronovich.JD03_01_Check_here.CN.URL_DB;
import static by.it.voronovich.JD03_01_Check_here.CN.USER_DB;

public class CreateConnection {

    public static Connection createConnection() throws SQLException{
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
        return connection;
    }
}

