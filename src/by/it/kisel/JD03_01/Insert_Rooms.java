package by.it.kisel.JD03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Insert_Rooms {


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

             Statement statement = connection.createStatement()) {

            //вставляем комнаты
            statement.executeUpdate(
                    "INSERT INTO rooms (RoomCount, Quality, PriceForDay, Conditioner, Description)" +
                            "VALUES (3, 8, 180, 'Yes', 'Good room');");
            statement.executeUpdate(
                    "INSERT INTO rooms (RoomCount, Quality, PriceForDay, Conditioner, Description)" +
                            "VALUES (4, 10, 300, 'Yes', 'Elite room');");
            statement.executeUpdate(
                    "INSERT INTO rooms (RoomCount, Quality, PriceForDay, Conditioner, Description)" +
                            "VALUES (3, 7, 100, 'No', 'Normal room');");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
