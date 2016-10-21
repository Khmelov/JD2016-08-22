package by.it.voronovich.JD03_02.crud;

import by.it.voronovich.JD03_02.ConnectionCreator;
import by.it.voronovich.JD03_02.bean.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {

    public Role create(Role role) throws SQLException {
        role.setIdRole(0);
        //формирование строки createUserSQL по данным bean user
        String createRoleSQL = String.format(
                "insert into role(Name) values('%s');",
                role.getName()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (statement.executeUpdate(createRoleSQL) == 1)
            {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    role.setIdRole(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return role;
    }

    public Role read(int idRole) throws SQLException {
        Role roleResult = null;
        String readRoleSQL = "SELECT * FROM role where idRole=" + idRole;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readRoleSQL);
            if (resultSet.next()) {
                roleResult = new Role(
                        resultSet.getInt("idRole"),
                        resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return roleResult;
    }

    public Role update(Role role) throws SQLException {
        Role roleResult = null;
        String updateRoleSQL = String.format(
                "UPDATE role SET Name = '%s' WHERE role.idRole = %d",
                role.getName(), role.getIdRole()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateRoleSQL) == 1)
                roleResult = role;
        } catch (SQLException e) {
            throw e;
        }
        return roleResult;
    }

    public boolean delete(Role role) throws SQLException {
        String deleteRoleSQL = String.format("DELETE FROM role WHERE role.idRole = %d", role.getIdRole());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate (deleteRoleSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
