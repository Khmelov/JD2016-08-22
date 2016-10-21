package by.it.voronovich.JD03_01_Check_here;

import java.sql.SQLException;

import static by.it.voronovich.JD03_01_Check_here.CreateConnection.createConnection;
import static by.it.voronovich.JD03_01_Check_here.ExecutorDB.executeDataBase;
import static by.it.voronovich.JD03_01_Check_here.ExtractionFromDB.extractFromDB;

public class RunExecutorDB {

    public static void main(String[] args) {

        try {
            //Выполнянием очистку и заполнение базы данных
            executeDataBase(createConnection());
            //Извлекаем информацию из таблицы
            extractFromDB(createConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}