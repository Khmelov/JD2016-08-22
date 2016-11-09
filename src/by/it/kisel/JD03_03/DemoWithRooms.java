package by.it.kisel.JD03_03;

import by.it.kisel.JD03_03.beans.Rooms;
import by.it.kisel.JD03_03.custom_dao.DAO;

import java.sql.SQLException;

public class DemoWithRooms {
    public static void main(String[] args) throws SQLException {
        DAO dao= DAO.getDAO();
        Rooms rooms=new Rooms(0,4,5,60,"No","50-50");
        System.out.println("All-------------------------");
        System.out.println(dao.rooms.getAll(""));

        dao.rooms.create(rooms);
        System.out.println("-------- Create ------------");
        System.out.println(dao.rooms.getAll(""));

        rooms.setConditioner("Yes");
        dao.rooms.update(rooms);
        System.out.println("-------- Update ------------");
        System.out.println(dao.rooms.getAll(""));

        dao.rooms.delete(rooms);
        System.out.println("-------- Delete ------------");
        System.out.println(dao.rooms.getAll(""));

    }
}
