package by.it.akhmelev.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Ex_02__Users {


    public static void main(String[ ] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {e.printStackTrace();}
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement();) {
            //вставляем пользователей
            statement.executeUpdate(
                    "insert into users(Login,Password,Email,FK_ROLE)"+
                            " values('admin2','admin2','admin2@tut.by',1);"
            );
            statement.executeUpdate(
                    "insert into users(Login,Password,Email,FK_ROLE)"+
                            " values('avkhmeleva','pavkhmeleva','avkhmeleva@tut.by',2);"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
