package by.it.prymshyts.jd03.jd03_01;

import by.it.prymshyts.jd03.DB;

import java.sql.Connection;
import java.sql.DriverManager;

class ConnectionTest {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB.DB_URL, DB.DB_USR, DB.DB_PASS)) {
            if (!connection.isClosed()) {
                System.out.println("Connection established");
            }
            connection.close();
            if (connection.isClosed()) {
                System.out.println("Connection closed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
