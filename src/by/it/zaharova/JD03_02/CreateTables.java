package by.it.zaharova.JD03_02;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTables {


    public static void main(String[] args) {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {
            //удаляем таблицы
            statement.executeUpdate("DROP TABLE IF EXISTS patients ");
            statement.executeUpdate("DROP TABLE IF EXISTS doctors ");
            statement.executeUpdate("DROP TABLE IF EXISTS diagnostic ");
            statement.executeUpdate("DROP TABLE IF EXISTS status ");


            //вставляем таблицы
            String createTableSQL1 =
                    String.format(  "CREATE TABLE patients"+
                                    "(ID INT(11) NOT NULL AUTO_INCREMENT, "+
                                    "First_name VARCHAR(50) NOT NULL, "+
                                    "Second_name VARCHAR(50) NOT NULL, "+
                                    "Address VARCHAR(50) NOT NULL, "+
                                    "Phone_number VARCHAR(50) NOT NULL, "+
                                    "FK_doctors INT(11) NOT NULL, "+
                                    "PRIMARY KEY (ID) )");
            statement.executeUpdate(createTableSQL1);

            String createTableSQL2 =
                    String.format(  "CREATE TABLE doctors"+
                            "(ID INT(11) NOT NULL AUTO_INCREMENT, "+
                            "Name_surname VARCHAR(50) NOT NULL, "+
                            "Speciality VARCHAR(50) NOT NULL, "+
                            "Phone_number VARCHAR(50) NOT NULL, "+
                            "Cabinet VARCHAR(50) NOT NULL, "+
                            "PRIMARY KEY (ID) )");
            statement.executeUpdate(createTableSQL2);

            String createTableSQL3 =
                    String.format(  "CREATE TABLE diagnostic"+
                            "(ID INT(11) NOT NULL AUTO_INCREMENT, "+
                            "Illness VARCHAR(50) NOT NULL, "+
                            "Drugs VARCHAR(50) NOT NULL, "+
                            "Operations VARCHAR(50) NOT NULL, "+
                            "Procedures VARCHAR(50) NOT NULL, "+
                            "FK_patients INT(11) NOT NULL, "+
                            "FK_doctors INT(11) NOT NULL, "+
                            "PRIMARY KEY (ID) )");
            statement.executeUpdate(createTableSQL3);

            String createTableSQL4 =
                    String.format(  "CREATE TABLE status"+
                            "(ID INT(11) NOT NULL AUTO_INCREMENT, "+
                            "Patient_status VARCHAR(50) NOT NULL, "+
                            "FK_diagnostic VARCHAR(50) NOT NULL, "+
                            "PRIMARY KEY (ID) )");
            statement.executeUpdate(createTableSQL4);



//            //ПРИМЕР. добавим запись
//            statement.executeUpdate(
//                    "INSERT INTO DB_USER (USERNAME) VALUES ('Test+Проверка');"
//            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
