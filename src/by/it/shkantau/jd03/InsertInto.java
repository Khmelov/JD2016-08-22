package by.it.shkantau.jd03;

import by.it.shkantau.jd03.jd03_01.ConnectionSettings;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class InsertInto {

    public static void main(String[] args) {
        Driver driver ;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection  = DriverManager.getConnection(ConnectionSettings.URL_DB, ConnectionSettings.USER_DB, ConnectionSettings.PASSWORD_DB);
             Statement statement = connection.createStatement()){

                statement.executeUpdate("insert into users(login,pass,role) values('testUser','000',3);");
                statement.executeUpdate("insert into users(login,pass,role) values('tesetUser1', '111', 3);");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
