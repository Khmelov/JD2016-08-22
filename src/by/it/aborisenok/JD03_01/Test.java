package by.it.aborisenok.JD03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by aborisenok on 24.10.2016.
 */
public class Test {
    public static void main(String[] args) {

        final String URL_DB = "jdbc:mysql://127.0.0.1:2016/?useUnicode=true&amp;characterEncoding=UTF-8";
        final String USER_DB = "root";
        final String PASSWORD_DB = "";
        Connection connection = null;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection= DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            Statement statement = connection.createStatement();
           // statement.executeUpdate("CREATE DATABASE JD03");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
