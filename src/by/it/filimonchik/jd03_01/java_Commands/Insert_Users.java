package by.it.filimonchik.jd03_01.java_Commands;

import by.it.filimonchik.jd03_01.Connection.CN;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Insert_Users {


    public static void main(String[ ] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {e.printStackTrace();}
        try (Connection connection=
                     DriverManager.getConnection
                             ( CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement();) {

            statement.executeUpdate(
                    "insert into users(Login,Password,Email,FK_Role)"+
                            " values('admin','admin','admin@tut.by',1);"
            );
            statement.executeUpdate(
                    "insert into users(Login,Password,Email,FK_ROLE)"+
                            " values('user','user','user@tut.by',2);"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.print("Пользователи добавлены в таблицу.");

    }
}
