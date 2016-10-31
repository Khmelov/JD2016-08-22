package by.it.dubatovka.jd03_03;


import by.it.dubatovka.jd03_01.CN;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class CreateDB_dubatovka_helpdesk {
    private static String dropAd = String.format("DROP TABLE IF EXISTS `dubatovka_helpDesk`.`ad`");
    private static String dropRole = String.format("DROP TABLE IF EXISTS `dubatovka_helpDesk`.`role`");
    private static String dropStatus = String.format("DROP TABLE IF EXISTS `dubatovka_helpDesk`.`status`");
    private static String dropPriority = String.format("DROP TABLE IF EXISTS `dubatovka_helpDesk`.`priority`");
    private static String dropObjects = String.format("DROP TABLE IF EXISTS `dubatovka_helpDesk`.`objects`");
    private static String dropUsers = String.format("DROP TABLE IF EXISTS `dubatovka_helpDesk`.`users`");

    private static String createUsers = String.format("CREATE TABLE IF NOT EXISTS `dubatovka_helpDesk`.`users` (" +
            "`ID` INT NOT NULL AUTO_INCREMENT,  `login` VARCHAR(45) NOT NULL,  `password` VARCHAR(20) NOT NULL," +
            "  `email` VARCHAR(45) NULL," +
            "  `fk_role` INT NOT NULL," +
            "  PRIMARY KEY (`ID`)," +
            "  INDEX `role_idx` (`fk_role` ASC)," +
            "  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC)," +
            "  UNIQUE INDEX `login_UNIQUE` (`login` ASC)," +
            "  UNIQUE INDEX `email_UNIQUE` (`email` ASC)," +
            "  CONSTRAINT `fk_role`" +
            "    FOREIGN KEY (`fk_role`)" +
            "    REFERENCES `dubatovka_helpDesk`.`role` (`ID`)" +
            "    ON DELETE NO ACTION" +
            "    ON UPDATE NO ACTION)" +
            "ENGINE = InnoDB;");

    private static String createRole = String.format("CREATE TABLE role ("
            + "ID INT NOT NULL AUTO_INCREMENT,"
            + " roleName VARCHAR(20) NOT NULL,"
            + "PRIMARY KEY (ID));");

    private static String createObjects = String.format("CREATE TABLE IF NOT EXISTS `dubatovka_helpDesk`.`objects` (" +
            "  `ID` INT NOT NULL AUTO_INCREMENT," +
            "  `zia` VARCHAR(45) NOT NULL," +
            "  PRIMARY KEY (`ID`)," +
            "  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC)," +
            "  UNIQUE INDEX `zia_UNIQUE` (`zia` ASC))" +
            "ENGINE = InnoDB;");

    private static String createStatus = String.format("CREATE TABLE IF NOT EXISTS `dubatovka_helpDesk`.`status` (" +
            "  `ID` INT NOT NULL AUTO_INCREMENT," +
            "  `statusName` VARCHAR(20) NOT NULL," +
            "  PRIMARY KEY (`ID`)," +
            "  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC)," +
            "  UNIQUE INDEX `statuscol_UNIQUE` (`statusName` ASC))" +
            "ENGINE = InnoDB;");

    private static String createPriority = String.format("CREATE TABLE IF NOT EXISTS `dubatovka_helpDesk`.`priority` (" +
            "  `ID` INT NOT NULL AUTO_INCREMENT," +
            "  `priorityName` VARCHAR(10) NOT NULL," +
            "  PRIMARY KEY (`ID`)," +
            "  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC)," +
            "  UNIQUE INDEX `priorityName_UNIQUE` (`priorityName` ASC))" +
            "ENGINE = InnoDB;");

    private static String createAd = String.format("CREATE TABLE IF NOT EXISTS `dubatovka_helpDesk`.`ad` (" +
            "  `ID` INT NOT NULL AUTO_INCREMENT," +
            "  `subject` VARCHAR(45) NOT NULL," +
            "  `description` VARCHAR(300) NULL," +
            "  `fk_zia` INT NOT NULL," +
            "  `fk_user` INT NOT NULL," +
            "  `fk_status` INT NOT NULL," +
            "  `fk_priority` INT NOT NULL," +
            "  PRIMARY KEY (`ID`)," +
            "  INDEX `fk_user_idx` (`fk_user` ASC)," +
            "  INDEX `fk_zia_idx` (`fk_zia` ASC)," +
            "  INDEX `fk_status_idx` (`fk_status` ASC)," +
            "  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC)," +
            "  INDEX `fk_priority_idx` (`fk_priority` ASC)," +
            "  CONSTRAINT `fk_user`" +
            "    FOREIGN KEY (`fk_user`)" +
            "    REFERENCES `dubatovka_helpDesk`.`users` (`ID`)" +
            "    ON DELETE NO ACTION" +
            "    ON UPDATE NO ACTION," +
            "  CONSTRAINT `fk_zia`" +
            "    FOREIGN KEY (`fk_zia`)" +
            "    REFERENCES `dubatovka_helpDesk`.`objects` (`ID`)" +
            "    ON DELETE NO ACTION" +
            "    ON UPDATE NO ACTION," +
            "  CONSTRAINT `fk_status`" +
            "    FOREIGN KEY (`fk_status`)" +
            "    REFERENCES `dubatovka_helpDesk`.`status` (`ID`)" +
            "    ON DELETE NO ACTION" +
            "    ON UPDATE NO ACTION," +
            "  CONSTRAINT `fk_priority`" +
            "    FOREIGN KEY (`fk_priority`)" +
            "    REFERENCES `dubatovka_helpDesk`.`priority` (`ID`)" +
            "    ON DELETE NO ACTION" +
            "    ON UPDATE NO ACTION)" +
            "ENGINE = InnoDB;");


    public static void createDB() {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement();
            //удаляем таблицы
            if (!connection.isClosed()) {
                System.out.println("Соединение установлено");
                statement.executeUpdate(dropAd);
                System.out.println("dropAd");
                statement.executeUpdate(dropUsers);
                System.out.println("dropUsers");
                statement.executeUpdate(dropRole);
                System.out.println("dropRole");

                statement.executeUpdate(dropStatus);
                System.out.println("dropStatus");
                statement.executeUpdate(dropPriority);
                System.out.println("dropPriority");
                statement.executeUpdate(dropObjects);
                System.out.println("dropObjects");

//создаем таблицы
                statement.executeUpdate(createPriority);
                System.out.println("CreatePriority");
                statement.executeUpdate(createRole);
                System.out.println("CreateRole");
                statement.executeUpdate(createObjects);
                System.out.println("CreateObjects");
                statement.executeUpdate(createStatus);
                System.out.println("CreateStatus");

                statement.executeUpdate(createUsers);
                System.out.println("CreateUsers");
                statement.executeUpdate(createAd);
                System.out.println("CreateAd");
                statement.close();
            } else System.out.println("отсутствует соединение!");

            //заполнение таблиц
            //    FillTable.filltable();
            connection.close();
            System.out.println("Соединение закрыто");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}