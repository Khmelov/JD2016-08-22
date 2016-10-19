package by.it.prymshyts.jd03.jd03_02.CRUD;

import by.it.prymshyts.jd03.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RoleCRUD {

    public boolean create(Role role) throws SQLException {
        String createRoleSQL = String.format(
                "INSERT INTO Role(ID, Role)" +
                        " VALUES(%d, '%s');",
                role.getID(),
                role.getRole());

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(createRoleSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }

    public Role read(int id) throws SQLException {
        Role roleResult = null;
        String readRoleSQL = String.format(
                "SELECT * FROM Role WHERE ID=%d", id);

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(readRoleSQL);
            if (resultSet.next()) {
                roleResult = new Role(
                        resultSet.getInt("ID"),
                        resultSet.getString("Role")
                );
            }
        } catch (SQLException e) {
            throw e;
        }

        return roleResult;
    }

    public boolean update(Role role) throws SQLException {
        String updateRoleSQL = String.format(
                "UPDATE Role SET Role='%s' WHERE Role.ID=%d;",
                role.getRole(), role.getID());

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(updateRoleSQL) == 1);
        } catch (SQLException e) {
            throw  e;
        }
    }

    public boolean delete(Role role) throws SQLException {
        String deleteRoleSQL = String.format(
                "DELETE FROM Role WHERE Role.ID=%d", role.getID());

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteRoleSQL) == 1);
        } catch (SQLException e) {
            throw  e;
        }
    }

    public ArrayList<Role> getAll() throws SQLException {
        ArrayList<Role> roleArrayList = new ArrayList<>();
        String getAllSQL = "SELECT * FROM Role;";

        try (Connection connection = DB.getConnection();
             Statement statement   = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(getAllSQL);
            while (resultSet.next()) {
                roleArrayList.add(new Role(
                        resultSet.getInt("ID"),
                        resultSet.getString("Role")
                ));
            }
        } catch (SQLException e) {
            throw e;
        }

        return roleArrayList;
    }
}
