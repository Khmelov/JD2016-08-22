package by.it.aborisenok.JD03_01.TaskB;

import java.sql.*;

public class CreateUsersTable {

    public static void createTableAndInsertInfo(Connection connection) {
        try {
            Connection newConnection = connection;
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE `" + CreateConnection.getBdName() + "`.`user` ( `ID` INT NULL AUTO_INCREMENT , " +
                    "`Name` VARCHAR(10) NOT NULL , " +
                    "`Surname` VARCHAR(15) NOT NULL , " +
                    "`BirthDay` TIMESTAMP NOT NULL , " +
                    "`City` VARCHAR(10) NOT NULL , " +
                    "`FK_Role` INT NOT NULL , " +
                    "PRIMARY KEY (`ID`)) ENGINE = InnoDB;");

            statement.executeUpdate("INSERT INTO `" + CreateConnection.getBdName() + "`.`user` (`ID`, `Name`, `Surname`, `BirthDay`, `City`, `FK_Role`) " +
                    "VALUES (NULL, 'Pitter', 'Pen', '1992-10-24 01:00:00', 'Minsk', '1');");
            statement.executeUpdate("INSERT INTO `" + CreateConnection.getBdName() + "`.`user` (`ID`, `Name`, `Surname`, `BirthDay`, `City`, `FK_Role`) " +
                    "VALUES (NULL, 'Bred', 'Pit', '1987-10-24 01:00:00', 'London', '2');");

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
