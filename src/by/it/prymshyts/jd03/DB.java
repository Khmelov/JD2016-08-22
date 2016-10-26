package by.it.prymshyts.jd03;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static Connection connection = null;

    public static final String DB_URL  = "jdbc:mysql://127.0.0.1:2016/infoportal";
    public static final String DB_USR  = "root";
    public static final String DB_PASS = "";

    static {
        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (DB_URL) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(DB_URL, DB_USR, DB_PASS);
                }
            }
        }

        return connection;
    }
}
