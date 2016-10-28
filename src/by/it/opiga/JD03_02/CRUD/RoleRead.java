package by.it.opiga.JD03_02.CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * Created by Asus on 24.10.2016.
 */
public class RoleRead {

    public static Role read(String role) throws SQLException {
        Role roleResult = null;
        String readRoleSQL = String.format(Locale.ENGLISH,"SELECT * FROM t01_role where (role='"+role+"');");
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readRoleSQL);
            if (resultSet.next()) {
                roleResult = new Role(
                        resultSet.getInt("ID"),
                        resultSet.getString("role"));
            }
        } catch (SQLException e) {
            throw e;
        }
       // System.out.println(roleResult.toString());
        return roleResult;
    }

}
