package by.it.aborisenok.JD03_01.TaskB;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by aborisenok on 24.10.2016.
 */
public class DeleteRoleTable {
    public static void dropRoleTable(Connection connection) {
        try {
            Connection newConnection = connection;
            Statement statement = connection.createStatement();

            statement.executeUpdate("DROP TABLE IF EXISTS `" + CreateConnection.getBdName() + "`.`role`");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
