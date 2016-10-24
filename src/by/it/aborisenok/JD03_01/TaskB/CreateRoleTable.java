package by.it.aborisenok.JD03_01.TaskB;



import java.sql.*;

public class CreateRoleTable {

    public static void createTableAndInsertInfo(Connection connection) {
        try {
           Connection newConnection = connection;
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE `" + CreateConnection.getBdName() + "`.`role` " +
                    "( `ID` INT NULL AUTO_INCREMENT , `Role` VARCHAR(10) NOT NULL , PRIMARY KEY (`ID`)) " +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("INSERT INTO `" + CreateConnection.getBdName() + "`.`role` (`ID`, `Role`) VALUES (NULL, 'User');");
            statement.executeUpdate("INSERT INTO `" + CreateConnection.getBdName() + "`.`role` (`ID`, `Role`) VALUES (NULL, 'Admin');");

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
