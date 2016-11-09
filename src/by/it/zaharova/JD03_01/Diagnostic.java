package by.it.zaharova.JD03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Diagnostic {


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
                    "insert into diagnostic(Illness,Drugs,Operations,Procedures,FK_patients, FK_doctors)"+
                            " values('sinusit','kapli','no','klizma',1, 2);"
            );
            statement.executeUpdate(
                    "insert into diagnostic(Illness,Drugs,Operations,Procedures,FK_patients, FK_doctors)"+
                            " values('perelom','drugs','no','warm',2, 2);"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
