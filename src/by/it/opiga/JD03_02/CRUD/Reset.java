package by.it.opiga.JD03_02.CRUD;

import by.it.opiga.JD03_01.CN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * Created by Asus on 27.10.2016.
 */
public class Reset {
    private static String dropTable = String.format(Locale.ENGLISH, "DROP TABLE IF EXISTS ");

    public static void Reset(String table) {
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement();) {
             statement.execute(dropTable+table+";");
             statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
