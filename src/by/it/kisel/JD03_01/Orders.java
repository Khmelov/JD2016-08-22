package by.it.kisel.JD03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
//import java.util.*;
//import java.util.Date;

public class Orders {
    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement();) {
            //вставляем людей
            statement.executeUpdate(
                    "insert into orders(ArrivalDate,DepartureDate,TotalPrice,FK_rooms,FK_persons)" +
                            "values(12,25,'2340',5, 16);"
            );
            statement.executeUpdate(
                    "insert into orders(ArrivalDate,DepartureDate,TotalPrice,FK_rooms,FK_persons)\n" +
                            "values(20,28,'2400',6, 17);"
            );
            statement.executeUpdate(
                    "insert into orders(ArrivalDate,DepartureDate,TotalPrice,FK_rooms,FK_persons)\n" +
                            "values(1,16,'1000',7, 18);"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

//        java.util.Date d=new Date(1);
//        d.getTime(); //выдаст в секундах
//        d.setTime(); //записать в sql

    }


}
