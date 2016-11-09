package by.it.kisel.JD03_02.crud;


import by.it.kisel.JD03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoomsCRUD {

    public Rooms create(Rooms rooms) throws SQLException {
        rooms.setID(0);
        //формирование строки
        // createRoomsSQL по данным bean rooms
        String createRoomsSQL = String.format(
                "insert into rooms(RoomCount,Quality,PriceForDay,Conditioner,Description) values('%d','%d','%d','%s',%s);",
                rooms.getRoomCount(), rooms.getQuality(), rooms.getPriceForDay(), rooms.getConditioner(), rooms.getDescription()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (statement.executeUpdate(createRoomsSQL) == 1) {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    rooms.setID(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return rooms;
    }

    public Rooms read(int id) throws SQLException {
        Rooms roomsResult = null;
        String readRoomsSQL = "SELECT * FROM rooms where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readRoomsSQL);
            if (resultSet.next()) {
                roomsResult = new Rooms(
                        resultSet.getInt("ID"),
                        resultSet.getInt("RoomCount"),
                        resultSet.getInt("Quality"),
                        resultSet.getInt("PriceForDay"),
                        resultSet.getString("Conditioner"),
                        resultSet.getString("Description"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return roomsResult;
    }

    public Rooms update(Rooms rooms) throws SQLException {
        Rooms roomsResult = null;
        String updateRoomsSQL = String.format(
                "UPDATE rooms SET RoomCount = '%d', Quality = '%d', PriceForDay = '%d', Conditioner = '%s', Description=%s WHERE rooms.ID = %d",
                rooms.getRoomCount(), rooms.getQuality(), rooms.getPriceForDay(), rooms.getConditioner(), rooms.getDescription(), rooms.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateRoomsSQL) == 1)
                roomsResult = rooms;
        } catch (SQLException e) {
            throw e;
        }
        return roomsResult;
    }

    public boolean delete(Rooms rooms) throws SQLException {
        String deleteRoomsSQL = String.format("DELETE FROM rooms WHERE rooms.ID = %d", rooms.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteRoomsSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }


}
