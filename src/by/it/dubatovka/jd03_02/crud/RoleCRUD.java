package by.it.dubatovka.jd03_02.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {
    public Role create(Role role) throws SQLException {
        role.setIdRole(0);
        String createRoleSQL = String.format("insert into role(roleName) values ('%s')", role.getRoleName());

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            if (statement.executeUpdate(createRoleSQL) == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    role.setIdRole(resultSet.getInt(1));
                }
            }
        } catch (SQLException sqle) {
            throw sqle;
        }
        return role;
    }

    public Role read(int idRole) throws SQLException {
        Role roleResult = null;
        String readRoleSQL = "SELECT * FROM role WHERE role.idRole=" + idRole;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();) {
            final ResultSet resultSet = statement.executeQuery(readRoleSQL);
            if (resultSet.next()) {
                roleResult = new Role(
                        resultSet.getInt("idRole"),
                        resultSet.getString("roleName"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return roleResult;
    }

    public Role update(Role role) throws SQLException {
        Role roleResult = null;
        String updateRoleSQL = String.format("UPDATE role SET zia = '%s' WHERE role.idRole='%d'",
                role.getRoleName(), role.getIdRole());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()) {
            if (statement.executeUpdate(updateRoleSQL) == 1)
                roleResult = role;
        } catch (SQLException e) {
            throw e;
        }
        return roleResult;
    }

    public boolean delete(Role role) throws SQLException {
        String deleteRoleSQL = String.format("DELETE FROM role Where role.idRole = '%d'", role.getIdRole());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();) {
            return (statement.executeUpdate(deleteRoleSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
