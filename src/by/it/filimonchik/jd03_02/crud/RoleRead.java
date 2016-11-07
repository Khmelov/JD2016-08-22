package by.it.filimonchik.jd03_02.crud;

import by.it.filimonchik.jd03_02.Connection.ConnectionCreator;
import by.it.filimonchik.jd03_02.bean.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class RoleRead {
    public Role read(int id) throws SQLException {
        Role roleResult = null;
        String readRoleSQL = "SELECT * FROM role where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readRoleSQL);
            if (resultSet.next()) {
                roleResult = new Role(
                        resultSet.getInt("ID"),
                        resultSet.getString("Role"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return roleResult;
    }
}