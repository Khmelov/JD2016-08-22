package by.it.prymshyts.jd03.project.java.dao;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static final String DB_URL  = "jdbc:mysql://127.0.0.1:2016/infoportal";
    private static final String DB_USR  = "root";
    private static final String DB_PASS = "";

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (connection == null || connection.isClosed()) {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            synchronized (DB_URL) {
                if (connection == null || connection.isClosed())
                    connection = DriverManager.getConnection(DB_URL, DB_USR, DB_PASS);
            }
        }
        return connection;
    }
}
