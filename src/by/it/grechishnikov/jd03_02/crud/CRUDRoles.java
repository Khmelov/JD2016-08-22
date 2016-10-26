package by.it.grechishnikov.jd03_02.crud;

import by.it.grechishnikov.jd03_02.ConnectionToServer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDRoles {
    public static void create(Role role) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            statement.executeUpdate(String.format("insert into roles(name) values('%s')", role.getName()));
            ResultSet set = statement.executeQuery(String.format("select id from roles where name = '%s'", role.getName()));
            if (set.next()) {
                role.setId(set.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
    }

    public static Role read(int id) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            ResultSet set = statement.executeQuery(String.format("select * from roles where id = %d", id));
            set.next();
            return new Role(set.getInt("id"), set.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
        return null;
    }

    public static Role read(String name) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            ResultSet set = statement.executeQuery(String.format("select * from roles where name = '%s'", name));
            set.next();
            return new Role(set.getInt("id"), set.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
        return null;
    }

    public static Role update(Role role) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            statement.executeUpdate(String.format("update roles set name = '%s' where roles.id = %d",
                    role.getName(), role.getId()));
            return role;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
        return null;
    }
}
