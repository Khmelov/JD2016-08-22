package by.it.grechishnikov.jd03_02;


import java.sql.SQLException;
import static by.it.grechishnikov.jd03_01.TaskC.*;
import static by.it.grechishnikov.jd03_02.Connection.statement;

public class TaskC {

    public static void main(String[] args) {
        reset();
    }

    public static void reset() {
        deleteAllTables();
        createAllTables();
//        initializeTables();
    }

    private static void deleteAllTables() {
        dropOldDB();
        createNewDB();
    }

    private static void createAllTables() {
        createTables();
    }

    private static void initializeTables() {
        try {
            statement.executeUpdate("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
