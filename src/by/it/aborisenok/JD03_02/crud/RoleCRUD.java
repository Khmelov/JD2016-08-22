package by.it.aborisenok.JD03_02.crud;

import by.it.aborisenok.JD03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by aborisenok on 26.10.2016.
 */
public class RoleCRUD {
    public Role create(Role role){
        role.setID(0);
        String createRoleSQL = String.format(
                "INSERT INTO `" + ConnectionCreator.getBdName() + "`.`role` (Role) values('"+ role.getRole() +"');");

        try {

            Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
            Statement statement = connection.createStatement();

            if (statement.executeUpdate(createRoleSQL,Statement.RETURN_GENERATED_KEYS) == 1)
            {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next())
                    role.setID(resultSet.getInt(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return role;
    }

    public Role read(int id){
        Role roleResult = null;
        String readRoleSQL = "SELECT * FROM `" + ConnectionCreator.getBdName() + "`.`role` where ID=" + id;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement())
        {
            final ResultSet resultSet = statement.executeQuery(readRoleSQL);
            if (resultSet.next()) {
                roleResult = new Role(resultSet.getInt("ID"),
                        resultSet.getString("Role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleResult;
    }

    public Role update(Role role){
        Role roleResult = null;
        String updateRoleSQL = String.format(
                "UPDATE `" + ConnectionCreator.getBdName() + "`.`role` SET Role = '%s' WHERE role.ID = %d",
                role.getRole(), role.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateRoleSQL) == 1)
                roleResult = role;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleResult;
    }

    public boolean delete(Role role){
        boolean result = false;
        String deleteRoleSQL = String.format("DELETE FROM `" + ConnectionCreator.getBdName() + "`.`role` WHERE role.ID = %d", role.getID());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(deleteRoleSQL) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
