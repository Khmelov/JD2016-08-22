package by.it.aborisenok.JD03_01;

import by.it.aborisenok.JD03_01.TaskB.*;

import java.sql.*;

/**
 * Created by aborisenok on 24.10.2016.
 */
public class TaskC_AutoCreate {

    public static void main(String[ ] args) {
       CreateConnection.setBdName("");
        Connection connection = CreateConnection.openConection(CreateConnection.getBdName());
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE aborisenokTask01");

            CreateConnection.setBdName("aborisenokTask01");

            CreateRoleTable.createTableAndInsertInfo(connection);

            CreateUsersTable.createTableAndInsertInfo(connection);

            SelectUserAndRole.printUserAndRole(connection);

              DeleteUserTable.dropUserTable(connection);

              DeleteRoleTable.dropRoleTable(connection);

              statement.executeUpdate("DROP DATABASE IF EXISTS aborisenokTask01");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
