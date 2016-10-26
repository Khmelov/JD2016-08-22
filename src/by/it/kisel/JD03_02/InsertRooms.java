package by.it.kisel.JD03_02;

import java.sql.Connection;
import java.sql.Statement;

public class InsertRooms {


    public static void main(String[ ] args) {
        try (Connection connection= ConnectionCreator.getConnection();
             Statement statement=connection.createStatement();) {

            //вставляем объявления
            statement.executeUpdate(
                    "INSERT INTO rooms (RoomCount, Quality, PriceForDay, Conditioner, Description)" +
                            "VALUES (3, 8, 180, 'Yes', 'Good room');");
            statement.executeUpdate(
                    "INSERT INTO rooms (RoomCount, Quality, PriceForDay, Conditioner, Description)" +
                            "VALUES (4, 10, 300, 'Yes', 'Elite room');");
            statement.executeUpdate(
                    "INSERT INTO rooms (RoomCount, Quality, PriceForDay, Conditioner, Description)" +
                            "VALUES (3, 7, 100, 'No', 'Normal room');");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
