package by.it.filimonchik.jd03_01.java_Commands;

import by.it.filimonchik.jd03_01.Connection.CN;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Insert_AD {


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
                    "INSERT INTO ad (FK_Model, FK_Car_body, FK_Color, Price, FK_Users) "+
                            "VALUES (3, 2, 1, 2000, 1);"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.print("Данные по машине добавлены в таблицу.");

    }
}
