package by.it.zaharova.JD03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Doctors {


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
                    "insert into doctors(Name_surname,Speciality,Phone_number, Cabinet)"+
                            " values('Vlada Zaharova','surgeon','375293027568',23);"
            );
            statement.executeUpdate(
                    "insert into doctors(Name_surname,Speciality,Phone_number, Cabinet)"+
                            " values('Evgeny Kisel','therapist','375291149845',333);"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
