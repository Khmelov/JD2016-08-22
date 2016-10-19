package by.it.voronovich.JD03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

import static by.it.voronovich.JD03_01.CN.PASSWORD_DB;
import static by.it.voronovich.JD03_01.CN.URL_DB;
import static by.it.voronovich.JD03_01.CN.USER_DB;

public class CreateTable {

    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
             Statement statement = connection.createStatement();) {

            statement.execute("CREATE TABLE `voronovich_project`.`role`(" +
                    "`idRole` INT(10) NOT NULL AUTO_INCREMENT," +
                    "`Name` VARCHAR(50) NOT NULL," +
                    " PRIMARY KEY (`idRole`)" +
                    ") ENGINE = InnoDB CHARACTER set UTF8 COLLATE UTF8_general_ci;");

            statement.execute("CREATE TABLE `voronovich_project`.`users`(" +
                    "`idUsers` INT(10) NOT NULL AUTO_INCREMENT," +
                    "`Name` VARCHAR(50) NOT NULL," +
                    "`Surname` VARCHAR(50) NOT NULL," +
                    "`Login` VARCHAR(50) NOT NULL," +
                    "`Password` VARCHAR(50) NOT NULL," +
                    "`E-mail` VARCHAR(50) NOT NULL," +
                    "`FK_Role` INT(10) NOT NULL," +
                    " PRIMARY KEY (`idUsers`)," +
                    " FOREIGN KEY (`FK_Role`) REFERENCES `voronovich_project`.`role`(`idRole`)" +
                    ") ENGINE = InnoDB CHARACTER set UTF8 COLLATE UTF8_general_ci;");


            statement.execute("CREATE TABLE `voronovich_project`.`catalog` (" +
                    "`idCatalog` INT(10) NOT NULL AUTO_INCREMENT," +
                    "`Brand` VARCHAR(50) NOT NULL," +
                    "`Model` VARCHAR(50) NOT NULL," +
                    "`Price` DECIMAL(10) NOT NULL," +
                    "`ReleaseDate` VARCHAR(50) NOT NULL," +
                    "`Weight` VARCHAR(50) NOT NULL," +
                    "PRIMARY KEY (`idCatalog`)" +
                    ") ENGINE = InnoDB CHARACTER set UTF8 COLLATE UTF8_general_ci;");

            statement.execute("CREATE TABLE `voronovich_project`.`shoppingcart` (" +
                    "`idShoppingCart` INT(10) NOT NULL AUTO_INCREMENT," +
                    "`FK_Users` INT(10) NOT NULL," +
                    "`FK_Catalog` INT(10) NOT NULL," +
                    "PRIMARY KEY (`idShoppingCart`)," +
                    "FOREIGN KEY (`FK_Users`) REFERENCES `voronovich_project`.`users`(`idUsers`)," +
                    "FOREIGN KEY (`FK_Catalog`) REFERENCES `voronovich_project`.`catalog`(`idCatalog`)" +
                    ") ENGINE = InnoDB CHARACTER set UTF8 COLLATE UTF8_general_ci;");
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
