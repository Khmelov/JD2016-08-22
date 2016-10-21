package by.it.grechishnikov.jd03_02;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    private static java.sql.Connection connection;
    private static Statement statement;

    public static Statement startConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GeneratedStore" +
                            "?useUnicode=true&amp;characterEncoding=UTF-8",
                    "root", "");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
