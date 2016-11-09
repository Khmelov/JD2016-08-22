package by.it.zaharova.JD03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Patients {


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
                    "insert into patients(First_name,Second_name,Address,Phone_number, FK_doctors)"+
                            " values('Dmitriy','Savchuk','Gicalo 15','375294561223',1);"
            );
            statement.executeUpdate(
                    "insert into patients(First_name,Second_name,Address,Phone_number, FK_doctors)"+
                            " values('Kiril','Schasnuy','snov','375294535487861223',2);"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
