package by.it.aborisenok.JD03_01.TaskB;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {

    private static String bdName;

    public static Connection openConection(String project){
         final String URL_DB = "jdbc:mysql://127.0.0.1:2016/"+ getBdName() +"?useUnicode=true&amp;characterEncoding=UTF-8";
         final String USER_DB = "root";
         final String PASSWORD_DB = "";
        Connection connection = null;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection= DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        return connection;
    }

    public static String getBdName() {
        return bdName;
    }

    public static void setBdName(String Name) {
        bdName = Name;
    }

}
