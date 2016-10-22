package by.it.voronovich.JD03_02.reset;

import by.it.voronovich.JD03_02.ConnectionCreator;
import by.it.voronovich.JD03_02.bean.CatalogGood;
import by.it.voronovich.JD03_02.bean.Order;
import by.it.voronovich.JD03_02.bean.Role;
import by.it.voronovich.JD03_02.bean.User;
import by.it.voronovich.JD03_02.crud.CatalogGoodCRUD;
import by.it.voronovich.JD03_02.crud.OrderCRUD;
import by.it.voronovich.JD03_02.crud.RoleCRUD;
import by.it.voronovich.JD03_02.crud.UserCRUD;

import java.sql.*;

public class ResetDB {

    public static void reset() {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {
            if (!connection.isClosed())
                System.out.println("Соединение установлено");
            statement.execute(" DROP TABLE IF EXISTS " + "shoppingcart");
            statement.execute(" DROP TABLE IF EXISTS " + "users");
            statement.execute(" DROP TABLE IF EXISTS " + "role");
            statement.execute(" DROP TABLE IF EXISTS " + "catalog");
            System.out.println("База данных очищена!");
            System.out.println("Идет процесс заполнения базы данных");
            System.out.println("Идет процесс создания таблиц");
            //Create table role
            statement.execute("CREATE TABLE `voronovich_project`.`role`(" +
                    "`idRole` INT(10) NOT NULL AUTO_INCREMENT," +
                    "`Name` VARCHAR(50) NOT NULL," +
                    " PRIMARY KEY (`idRole`)" +
                    ") ENGINE = InnoDB CHARACTER set UTF8 COLLATE UTF8_general_ci;");
            //Create table users
            statement.execute("CREATE TABLE `voronovich_project`.`users`(" +
                    "`idUsers` INT(10) NOT NULL AUTO_INCREMENT," +
                    "`Name` VARCHAR(50) NOT NULL," +
                    "`Surname` VARCHAR(50) NOT NULL," +
                    "`Login` VARCHAR(50) NOT NULL," +
                    "`Password` VARCHAR(50) NOT NULL," +
                    "`Email` VARCHAR(50) NOT NULL," +
                    "`FK_Role` INT(10) NOT NULL," +
                    " PRIMARY KEY (`idUsers`)," +
                    " FOREIGN KEY (`FK_Role`) REFERENCES `voronovich_project`.`role`(`idRole`)" +
                    ") ENGINE = InnoDB CHARACTER set UTF8 COLLATE UTF8_general_ci;");
            //Create table catalog
            statement.execute("CREATE TABLE `voronovich_project`.`catalog` (" +
                    "`idCatalog` INT(10) NOT NULL AUTO_INCREMENT," +
                    "`Brand` VARCHAR(50) NOT NULL," +
                    "`Model` VARCHAR(50) NOT NULL," +
                    "`Price` DECIMAL(10) NOT NULL," +
                    "`ReleaseDate` VARCHAR(50) NOT NULL," +
                    "`Weight` VARCHAR(50) NOT NULL," +
                    "PRIMARY KEY (`idCatalog`)" +
                    ") ENGINE = InnoDB CHARACTER set UTF8 COLLATE UTF8_general_ci;");
            //Create table shoppingcart
            statement.execute("CREATE TABLE `voronovich_project`.`shoppingcart` (" +
                    "`idShoppingCart` INT(10) NOT NULL AUTO_INCREMENT," +
                    "`FK_Users` INT(10) NOT NULL," +
                    "`FK_Catalog` INT(10) NOT NULL," +
                    "PRIMARY KEY (`idShoppingCart`)," +
                    "FOREIGN KEY (`FK_Users`) REFERENCES `voronovich_project`.`users`(`idUsers`)," +
                    "FOREIGN KEY (`FK_Catalog`) REFERENCES `voronovich_project`.`catalog`(`idCatalog`)" +
                    ") ENGINE = InnoDB CHARACTER set UTF8 COLLATE UTF8_general_ci;");
            System.out.println("Процесс создания таблиц завершен");
            System.out.println("Идет процесс заполнения таблиц");
            //Fill table role
            Role role = new Role(0, "Administrator");
            RoleCRUD roleCRUD = new RoleCRUD();
            roleCRUD.create(role);
            role = new Role(0, "User");
            roleCRUD.create(role);
            //Fill table users
            User user = new User(0, "Derek", "Nicolson", "der", "der111" , "der@gmail.com", 1);
            UserCRUD userCRUD = new UserCRUD();
            userCRUD.create(user);
            user = new User(0, "Emmy", "Toren", "emm", "emm111" , "emm@gmail.com", 1);
            userCRUD.create(user);
            user = new User(0, "Tony", "Demico", "ton", "ton111" , "ton@gmail.com", 2);
            userCRUD.create(user);
            user = new User(0, "Tony", "Demico", "ton", "ton111" , "ton@gmail.com", 2);
            userCRUD.create(user);
            user = new User(0, "Piter", "Griffin", "pit", "pit111" , "pit@gmail.com", 2);
            userCRUD.create(user);
            //Fill table catalog
            CatalogGood cg = new CatalogGood(0, "Atlant", "GR122114EE", 530.0, "2016 year", "70 kg");
            CatalogGoodCRUD cgCRUD = new CatalogGoodCRUD();
            cgCRUD.create(cg);
            cg = new CatalogGood(0, "Atlant", "DY411114EE", 735.0, "2015 year", "71 kg");
            cgCRUD.create(cg);
            cg = new CatalogGood(0, "Samsung", "ED12", 931.0, "2016 year", "75 kg");
            cgCRUD.create(cg);
            cg = new CatalogGood(0, "LG", "LG7241", 1031.0, "2015 year", "81 kg");
            cgCRUD.create(cg);
            //Fill table shoppingcart
            Order order = new Order(0, 2, 3);
            OrderCRUD orderCRUD = new OrderCRUD();
            orderCRUD.create(order);
            order = new Order(0, 3, 1);
            orderCRUD.create(order);
            order = new Order(0, 4, 2);
            orderCRUD.create(order);
           /* //Fill table role
            statement.execute("INSERT INTO role (Name) VALUES ('Administrator');");
            statement.execute("INSERT INTO role (Name) VALUES ('User');");
            //Fill table users
            statement.execute("INSERT INTO users (`Name`, `Surname`, `Login`, `Password`, `Email`, `FK_Role`) " +
                    " VALUES ('Derek', 'Nicolson', 'der', 'der111' , 'der@gmail.com', 1);");
            statement.execute("INSERT INTO users (`Name`, `Surname`, `Login`, `Password`, `Email`, `FK_Role`) " +
                    " VALUES  ('Emmy', 'Toren', 'emm', 'emm111' , 'emm@gmail.com', 2);");
            statement.execute("INSERT INTO users (`Name`, `Surname`, `Login`, `Password`, `Email`, `FK_Role`) " +
                    " VALUES ('Tony', 'Demico', 'ton', 'ton111' , 'ton@gmail.com', 2);");
            statement.execute("INSERT INTO users (`Name`, `Surname`, `Login`, `Password`, `Email`, `FK_Role`) " +
                    " VALUES ('Piter', 'Griffin', 'pit', 'pit111' , 'pit@gmail.com', 2);");
            //Fill table catalog
            statement.execute("INSERT INTO catalog (`Brand`, `Model`, `Price`, `ReleaseDate`, `Weight`) " +
                    " VALUES ('Atlant', 'GR122114EE', '530.0', '2016 year' , '70 kg');");
            statement.execute("INSERT INTO catalog (`Brand`, `Model`, `Price`, `ReleaseDate`, `Weight`) " +
                    " VALUES ('Atlant', 'DY411114EE', '735.0', '2015 year' , '71 kg');");
            statement.execute("INSERT INTO catalog (`Brand`, `Model`, `Price`, `ReleaseDate`, `Weight`) " +
                    " VALUES ('Samsung', 'ED12', '931.0', '2016 year' , '75 kg');");
            statement.execute("INSERT INTO catalog (`Brand`, `Model`, `Price`, `ReleaseDate`, `Weight`) " +
                    " VALUES ('LG', 'LG7241', '1031.0', '2015 year' , '81 kg');");
            //Fill table shoppingcart
            statement.execute("INSERT INTO shoppingcart (`FK_Users`,`FK_Catalog`) " +
                    " VALUES (2, 3);");
            statement.execute("INSERT INTO shoppingcart (`FK_Users`,`FK_Catalog`) " +
                    " VALUES (3, 1);");
            statement.execute("INSERT INTO shoppingcart (`FK_Users`,`FK_Catalog`) " +
                    " VALUES (4, 2);");*/
            System.out.println("Процесс заполнения таблиц завершен");
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}