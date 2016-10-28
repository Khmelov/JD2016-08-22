package by.it.grechishnikov.project.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionToServer {
    private static Connection connection;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Semaphore semaphore = new Semaphore(5);

    private ConnectionToServer() {
    }

    public static Connection getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (connection == null || connection.isClosed()) {
                semaphore.acquire();
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GeneratedStore" +
                                "?useUnicode=true&amp;characterEncoding=UTF-8",
                        "root", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            lock.lock();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
