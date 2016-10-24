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
                    "INSERT INTO rooms (ArrivalDate, DepartureDate, RoomCount, Quality,Price, Conditioner, FK_persons, Description)" +
                            "VALUES ('19.10', '25.11', 3, 8, 2500, 'Yes', 10, 'Good room');");
            statement.executeUpdate(
                    "INSERT INTO rooms (ArrivalDate, DepartureDate, RoomCount, Quality,Price, Conditioner, FK_persons, Description)" +
                            "VALUES ('01.11', '13.11', 4, 10, 2000, 'Yes', 11, 'Elite room');");
            statement.executeUpdate(
                    "INSERT INTO rooms (ArrivalDate, DepartureDate, RoomCount, Quality,Price, Conditioner, FK_persons, Description)" +
                            "VALUES ('27.10', '01.12', 3, 7, 3800, 'No', 12, 'Normal room');");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
