package by.it.kisel.JD03_02;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTables {


    public static void main(String[] args) {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {
            //удаляем таблицы
            statement.executeUpdate("DROP TABLE IF EXISTS role ");
            statement.executeUpdate("DROP TABLE IF EXISTS status ");
            statement.executeUpdate("DROP TABLE IF EXISTS persons ");
            statement.executeUpdate("DROP TABLE IF EXISTS rooms ");
            statement.executeUpdate("DROP TABLE IF EXISTS orders ");

            //вставляем таблицы
            String createTableSQL1 =
                    String.format(  "CREATE TABLE role"+
                                    "(ID INT(11) NOT NULL AUTO_INCREMENT, "+
                                    "Role VARCHAR(50) NOT NULL, "+
                                    "PRIMARY KEY (ID) )");
            statement.executeUpdate(createTableSQL1);

            String createTableSQL2 =
                    String.format(  "CREATE TABLE status"+
                            "(ID INT(11) NOT NULL AUTO_INCREMENT, "+
                            "OrderStatus VARCHAR(50) NOT NULL, "+
                            "FK_orders INT(11) NOT NULL, "+
                            "PRIMARY KEY (ID) )");
            statement.executeUpdate(createTableSQL2);

            String createTableSQL3 =
                    String.format(  "CREATE TABLE persons"+
                            "(ID INT(11) NOT NULL AUTO_INCREMENT, "+
                            "FirstName VARCHAR(50) NOT NULL, "+
                            "SecondName VARCHAR(50) NOT NULL, "+
                            "PhoneNumber VARCHAR(50) NOT NULL, "+
                            "Email VARCHAR(50) NOT NULL, "+
                            "FK_role INT(11) NOT NULL, "+
                            "PRIMARY KEY (ID) )");
            statement.executeUpdate(createTableSQL3);

            String createTableSQL4 =
                    String.format(  "CREATE TABLE rooms"+
                            "(ID INT(11) NOT NULL AUTO_INCREMENT, "+
                            "RoomCount INT(11) NOT NULL, "+
                            "Quality INT(11) NOT NULL, "+
                            "PriceForDay INT(11) NOT NULL, "+
                            "Conditioner VARCHAR(50) NOT NULL, "+
                            "Description VARCHAR(50) NOT NULL, "+
                            "PRIMARY KEY (ID) )");
            statement.executeUpdate(createTableSQL4);

            String createTableSQL5 =
                    String.format(  "CREATE TABLE orders"+
                            "(ID INT(11) NOT NULL AUTO_INCREMENT, "+
                            "ArrivalDate INT(11) NOT NULL, "+
                            "DepartureDate INT(11) NOT NULL, "+
                            "TotalPrice INT(11) NOT NULL, "+
                            "FK_rooms INT(11) NOT NULL, "+
                            "FK_persons INT(11) NOT NULL, "+
                            "PRIMARY KEY (ID) )");
            statement.executeUpdate(createTableSQL5);

//            //ПРИМЕР. добавим запись
//            statement.executeUpdate(
//                    "INSERT INTO DB_USER (USERNAME) VALUES ('Test+Проверка');"
//            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
