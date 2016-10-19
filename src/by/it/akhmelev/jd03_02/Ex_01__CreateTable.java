package by.it.akhmelev.jd03_02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex_01__CreateTable {


    public static void main(String[] args) {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {
            //ПРИМЕР. удаляем таблицу
            statement.executeUpdate("DROP TABLE IF EXISTS DB_USER ");

            //ПРИМЕР. вставляем таблицу
            String createTableSQL =
                    String.format(  "CREATE TABLE DB_USER"+
                                    "(USER_ID INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key!!!', "+
                                    "USERNAME VARCHAR(20) NOT NULL, "+
                                    "PRIMARY KEY (USER_ID) )");
            statement.executeUpdate(createTableSQL);

            //ПРИМЕР. добавим запись
            statement.executeUpdate(
                    "INSERT INTO DB_USER (USERNAME) VALUES ('Test+Проверка');"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
