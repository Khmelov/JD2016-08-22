package by.it.aborisenok.JD03_01.TaskB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by aborisenok on 24.10.2016.
 */
public class SelectUserAndRole {

    public static void printUserAndRole(Connection connection) {
        try {
            Connection newConnection = connection;
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM `" + CreateConnection.getBdName() + "`.`user` " +
                    "INNER JOIN `" + CreateConnection.getBdName() + "`.`role` ON user.FK_Role=role.ID");
            while (resultSet.next()) {
                String out = resultSet.getString("Name") + ", "
                        + resultSet.getString("Surname") + ", "
                        + resultSet.getTimestamp("Birthday") + ", "
                        + resultSet.getString("City") + ", "
                        + resultSet.getString("Role");
                System.out.println(out);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
