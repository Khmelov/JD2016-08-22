package by.it.aborisenok.JD03_01.TaskB;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by aborisenok on 24.10.2016.
 */
public class DeleteUserTable {
    public static void dropUserTable(Connection connection) {
        try {
            Connection newConnection = connection;
            Statement statement = connection.createStatement();

            statement.executeUpdate("DROP TABLE IF EXISTS `" + CreateConnection.getBdName() + "`.`user`");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
