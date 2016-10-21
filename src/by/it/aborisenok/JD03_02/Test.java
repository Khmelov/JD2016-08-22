package by.it.aborisenok.JD03_02;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Лёша on 21.10.2016.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionCreator.getConnection();
        if (!connection.isClosed())
            System.out.println("Open");
        connection.close();
        if (connection.isClosed())
            System.out.println("Close");
    }
}
