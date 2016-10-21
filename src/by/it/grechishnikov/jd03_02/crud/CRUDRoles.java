package by.it.grechishnikov.jd03_02.crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.it.grechishnikov.jd03_02.Connection.statement;

public class CRUDRoles {
    public static void create(Role role) {
        try {
            statement.executeUpdate(String.format("insert into roles(name) values('%s')", role.getName()));
            ResultSet set = statement.executeQuery(String.format("select id from roles where name = '%s'", role.getName()));
            if (set.next()) {
                role.setId(set.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Role read(int id) {
        try {
            ResultSet set = statement.executeQuery(String.format("select * from roles where id = %d", id));
            set.next();
            return new Role(set.getInt("id"), set.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Role read(String name) {
        try {
            ResultSet set = statement.executeQuery(String.format("select * from roles where name = '%s'", name));
            set.next();
            return new Role(set.getInt("id"), set.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Role update(Role role) {
        try {
            statement.executeUpdate(String.format("update roles set name = '%s' where roles.id = %d",
                    role.getName(), role.getId()));
            return role;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean delete(int id) {
        try {
            return statement.executeUpdate(String.format("delete from roles where id = %d", id)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
