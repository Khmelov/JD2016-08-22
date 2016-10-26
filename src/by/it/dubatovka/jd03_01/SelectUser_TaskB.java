package by.it.dubatovka.jd03_01;

import java.sql.*;

public class SelectUser_TaskB {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS INNER JOIN role ON users.fk_role=role.idRole");
            while (resultSet.next()) {
                //  System.out.println(resultSet.getString("idUser") + ". " + resultSet.getString("login") + ", role: " + resultSet.getString("fk_role"));
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                for (int i = 1; i < columnCount + 1; i++) {
                    System.out.print(resultSetMetaData.getColumnLabel(i) + "=" + resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

