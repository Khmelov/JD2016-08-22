package by.it.grechishnikov.jd03_02.crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.it.grechishnikov.jd03_02.Connection.statement;

public class Roles {
    public static String readRoleByid (int id) {
        try {
            ResultSet set = statement.executeQuery(String.format("select name from roles where id = '%d'", id));
            set.next();
            return set.getString("name");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int readRoleByName (String name) {
        try {
            ResultSet set = statement.executeQuery(String.format("select id from roles where name = '%s'", name));
            set.next();
            return set.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
