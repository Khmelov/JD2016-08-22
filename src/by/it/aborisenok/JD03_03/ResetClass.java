package by.it.aborisenok.JD03_03;


import by.it.aborisenok.JD03_02.ConnectionCreator;
import by.it.aborisenok.JD03_02.crud.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;


/**
 * Created by Лёша on 21.10.2016.
 */
public class ResetClass {
    public static void main(String[] args) throws SQLException {
        ConnectionCreator.setBdName("");
        Connection connection = ConnectionCreator.getConnection();

        BDDelete(connection);
        BDCreating(connection);
        tablesCreation(connection);
        tablesInsertbyCRUD(connection);


        connection.close();

    }

    public static void BDCreating(Connection connection){

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE aborisenok");
            ConnectionCreator.setBdName("aborisenok");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void BDDelete(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP DATABASE IF EXISTS aborisenok");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void tablesCreation(Connection connection){
        try {
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE `" + ConnectionCreator.getBdName() + "`.`user` " +
                    "( `ID` INT NULL AUTO_INCREMENT , `Login` VARCHAR(12) NOT NULL , " +
                    "`Password` VARCHAR(10) NOT NULL , `Name` VARCHAR(10) NOT NULL , " +
                    "`Surname` VARCHAR(15) NOT NULL , `BirthDay` TIMESTAMP NOT NULL , " +
                    "`City` VARCHAR(10) NOT NULL , `Street` VARCHAR(20) NOT NULL , " +
                    "`House` INT NOT NULL , `Flat` INT NOT NULL , `FK_Role` INT NOT NULL , " +
                    "PRIMARY KEY (`ID`)) ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE `" + ConnectionCreator.getBdName() + "`.`role` " +
                    "( `ID` INT NULL AUTO_INCREMENT , `Role` VARCHAR(10) NOT NULL , PRIMARY KEY (`ID`)) " +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE `" + ConnectionCreator.getBdName() + "`.`visitdate` " +
                    "( `ID` INT NULL AUTO_INCREMENT , `Time` TIMESTAMP NOT NULL , " +
                    "`FK_Doctor` INT NOT NULL , PRIMARY KEY (`ID`)) ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE `" + ConnectionCreator.getBdName() + "`.`doctor` " +
                    "( `ID` INT NULL AUTO_INCREMENT , `Name` VARCHAR(10) NOT NULL , " +
                    "`Surname` VARCHAR(15) NOT NULL , `Specialization` VARCHAR(20) NOT NULL , " +
                    "`Category` VARCHAR(10) NOT NULL , `Cabinet` INT NOT NULL , " +
                    "`FK_Policlinic` INT NOT NULL , PRIMARY KEY (`ID`)) ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE `" + ConnectionCreator.getBdName() + "`.`policlinic` " +
                    "( `ID` INT NULL AUTO_INCREMENT , `Name` VARCHAR(30) NOT NULL , " +
                    "`City` VARCHAR(10) NOT NULL , `Street` VARCHAR(15) NOT NULL , " +
                    "`House` INT NOT NULL , PRIMARY KEY (`ID`)) ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE `" + ConnectionCreator.getBdName() + "`.`talon` " +
                    "( `ID` INT NULL AUTO_INCREMENT , `FK_Policlinic` INT NOT NULL , " +
                    "`FK_User` INT NOT NULL , `FK_Doctor` INT NOT NULL , " +
                    "`FK_VisitDate` INT NOT NULL , PRIMARY KEY (`ID`)) ENGINE = InnoDB;");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void tablesDelete(Connection connection){
        try {
            Statement statement = connection.createStatement();

            statement.executeUpdate("DROP TABLE IF EXISTS `" + ConnectionCreator.getBdName() + "`.`user`");
            statement.executeUpdate("DROP TABLE IF EXISTS `" + ConnectionCreator.getBdName() + "`.`role`");
            statement.executeUpdate("DROP TABLE IF EXISTS `" + ConnectionCreator.getBdName() + "`.`visitdate`");
            statement.executeUpdate("DROP TABLE IF EXISTS `" + ConnectionCreator.getBdName() + "`.`doctor`");
            statement.executeUpdate("DROP TABLE IF EXISTS `" + ConnectionCreator.getBdName() + "`.`policlinic`");
            statement.executeUpdate("DROP TABLE IF EXISTS `" + ConnectionCreator.getBdName() + "`.`talon`");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void tablesInsertbySQL(Connection connection){
        try {
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO `" + ConnectionCreator.getBdName() + "`.`user` " +
                    "(`ID`, `Login`, `Password`, `Name`, `Surname`, `BirthDay`, `City`, `Street`, " +
                    "`House`, `Flat`, `FK_Role`) VALUES (NULL, 'alex', 'alex1', 'Valera', 'Petrov', " +
                    "'1992-10-06 00:00:00', 'Minsk', 'Lenina', '12', '32', '1')");
            statement.executeUpdate("INSERT INTO `" + ConnectionCreator.getBdName() + "`.`user` " +
                    "(`ID`, `Login`, `Password`, `Name`, `Surname`, `BirthDay`, `City`, `Street`, " +
                    "`House`, `Flat`, `FK_Role`) VALUES (NULL, 'hello', 'hello1', 'Petya', 'Pavlov', " +
                    "'1989-11-23 00:00:00', 'Minsk', 'Gikala', '10', '2', '2')");

            statement.executeUpdate("INSERT INTO `" + ConnectionCreator.getBdName() + "`.`visitdate` " +
                    "(`ID`, `Time`, `FK_Doctor`) VALUES (NULL, '2016-10-21 09:00:00', '1')");
            statement.executeUpdate("INSERT INTO `" + ConnectionCreator.getBdName() + "`.`visitdate` " +
                    "(`ID`, `Time`, `FK_Doctor`) VALUES (NULL, '2016-11-12 13:34:00', '2')");

            statement.executeUpdate("INSERT INTO `" + ConnectionCreator.getBdName() + "`.`doctor` " +
                    "(`ID`, `Name`, `Surname`, `Specialization`, `Category`, `Cabinet`, `FK_Policlinic`) " +
                    "VALUES (NULL, 'Jonny', 'Nickon', 'Terapevt', 'Hight', '23', '1')");
            statement.executeUpdate("INSERT INTO `" + ConnectionCreator.getBdName() + "`.`doctor` " +
                    "(`ID`, `Name`, `Surname`, `Specialization`, `Category`, `Cabinet`, `FK_Policlinic`) " +
                    "VALUES (NULL, 'Willy', 'Anderson', 'Hirurg', 'first', '212', '2')");

            statement.executeUpdate("INSERT INTO `" + ConnectionCreator.getBdName() + "`.`policlinic` " +
                    "(`ID`, `Name`, `City`, `Street`, `House`) VALUES (NULL, '3rd Minsk Policlinic', " +
                    "'Minsk', 'Nezavisimosti', '16')");
            statement.executeUpdate("INSERT INTO `" + ConnectionCreator.getBdName() + "`.`policlinic` " +
                    "(`ID`, `Name`, `City`, `Street`, `House`) VALUES (NULL, '5rd Minsk Policlinic', " +
                    "'Minsk', 'Macherova', '123')");

            statement.executeUpdate("INSERT INTO `" + ConnectionCreator.getBdName() + "`.`talon` " +
                    "(`ID`, `FK_Policlinic`, `FK_User`, `FK_Doctor`, `FK_VisitDate`)" +
                    " VALUES (NULL, '1', '1', '1', '1')");
            statement.executeUpdate("INSERT INTO `" + ConnectionCreator.getBdName() + "`.`talon` " +
                    "(`ID`, `FK_Policlinic`, `FK_User`, `FK_Doctor`, `FK_VisitDate`)" +
                    " VALUES (NULL, '2', '2', '2', '2')");

            statement.executeUpdate("INSERT INTO `" + ConnectionCreator.getBdName() + "`.`role` " +
                    "(`ID`, `Role`) VALUES (NULL, 'User');");
            statement.executeUpdate("INSERT INTO `" + ConnectionCreator.getBdName() + "`.`role` " +
                    "(`ID`, `Role`) VALUES (NULL, 'Admin');");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void tablesInsertbyCRUD(Connection connection){
        try {
            Statement statement = connection.createStatement();

            UserCRUD userCRUD = new UserCRUD();
            userCRUD.create(new User(0, "alex", "alex1", "Valera", "Petrov", Timestamp.valueOf("1992-10-06 00:00:00"), "Minsk", "Lenina", 12, 32, 1));
            userCRUD.create(new User(0, "hello1", "alex1", "Petya", "Pavlov", Timestamp.valueOf("1989-11-23 00:00:00"), "Minsk", "Gikala", 10, 2, 1));
            userCRUD.create(new User(0, "hello2", "alex2", "Vana", "Ivanov", Timestamp.valueOf("1987-11-23 00:00:00"), "Minsk", "Bedy", 16, 25, 1));
            userCRUD.create(new User(0, "hell3", "alex3", "Ura", "Sidorov", Timestamp.valueOf("1979-11-23 00:00:00"), "Minsk", "Partizansky", 56, 7, 2));
            userCRUD.create(new User(0, "hel45", "alex4", "Jeka", "Dopka", Timestamp.valueOf("1995-11-23 00:00:00"), "Minsk", "Altayskay", 10, 7, 2));

            VisitDateCRUD visitDateCRUD = new VisitDateCRUD();
            visitDateCRUD.create(new VisitDate(0, Timestamp.valueOf("2016-10-21 09:00:00"), 1));
            visitDateCRUD.create(new VisitDate(0, Timestamp.valueOf("2016-11-12 13:34:00"), 2));

            DoctorCRUD doctorCRUD = new DoctorCRUD();
            doctorCRUD.create(new Doctor(0, "Jonny", "Nickon", "Terapevt", "Hight", 23, 1));
            doctorCRUD.create(new Doctor(0, "Willy", "Anderson", "Hirurg", "first", 212, 2));

            PoliclinicCRUD policlinicCRUD = new PoliclinicCRUD();
            policlinicCRUD.create(new Policlinic(0, "3rd Minsk Policlinic", "Minsk", "Nezavisimosti", 16));
            policlinicCRUD.create(new Policlinic(0, "5rd Minsk Policlinic", "Minsk", "Macherova", 123));

            TalonCRUD talonCRUD = new TalonCRUD();
            talonCRUD.create(new Talon(0, 1, 1, 1, 1));
            talonCRUD.create(new Talon(0, 2, 2, 2, 2));

            RoleCRUD roleCRUD = new RoleCRUD();
            roleCRUD.create(new Role(0, "User"));
            roleCRUD.create(new Role(0, "Admin"));

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
