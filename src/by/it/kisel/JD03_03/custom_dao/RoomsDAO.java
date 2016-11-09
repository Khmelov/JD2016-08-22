package by.it.kisel.JD03_03.custom_dao;

import by.it.kisel.JD03_03.beans.Rooms;
import by.it.kisel.JD03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RoomsDAO extends AbstractDAO implements InterfaceDAO<Rooms> {
    
    @Override
    public Rooms read(int id) {
        List<Rooms> rooms = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (rooms.size() > 0) {
            return rooms.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Rooms rooms) {
        //локаль нужна,т.к. есть дробные числа. Их нужно указывать через точку
        String sql = String.format(Locale.ENGLISH,
                "insert INTO rooms(RoomCount,Quality,PriceForDay,Conditioner,Description)" +
                        "\n values('%d', '%d', '%d', '%s', '%s');",
                rooms.getRoomCount(),
                rooms.getQuality(),
                rooms.getPriceForDay(),
                rooms.getConditioner(),
                rooms.getDescription()
        );
        rooms.setID(executeUpdate(sql));
        return (rooms.getID() > 0);
    }

    @Override
    public boolean update(Rooms rooms) {
        //локаль нужна,т.к. есть дробные числа. Их нужно указывать через точку
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `rooms` SET " +
                        "`RoomCount`=%d " +
                        ",`Quality`='%d'" +
                        ",`PriceForDay`='%d'" +
                        ",`Conditioner`='%s'" +
                        ",`Description`='%s'" +
                        " WHERE `rooms`.`ID` = %d",
                rooms.getRoomCount(),
                rooms.getQuality(),
                rooms.getPriceForDay(),
                rooms.getConditioner(),
                rooms.getDescription(),
                rooms.getID()
        );

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Rooms rooms) {
        String sql = String.format(
                "DELETE FROM `rooms` WHERE `rooms`.`ID`=%d;", rooms.getID()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Rooms> getAll(String WHERE) {
        List<Rooms> roomss = new ArrayList<>();
        String sql = "SELECT * FROM rooms " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Rooms rooms = new Rooms();
                rooms.setID(rs.getInt("ID"));
                rooms.setConditioner(rs.getString("Conditioner"));
                rooms.setPriceForDay(rs.getInt("PriceForDay"));
                rooms.setDescription(rs.getString("Description"));
                rooms.setQuality(rs.getInt("Quality"));
                rooms.setRoomCount(rs.getInt("RoomCount"));
                roomss.add(rooms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomss;
    }
}
