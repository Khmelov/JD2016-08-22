package by.it.shkantau.jd03.jd03_01;

import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {

    private static final String [] tables = {"flights","users","cmd","roles","crews","airHostesses","airports","pilots","planes"};


    public static void removeTables(Statement statement) throws SQLException {
        for (String tableName: tables) {
            statement.executeUpdate("DROP TABLE IF EXISTS " + tableName);
        }
    }

    public static void clearTables(Statement statement) throws SQLException {
        for (String tableName: tables) {
            statement.executeUpdate("DELETE FROM "+ tableName);
        }
    }

    public static void createTables(Statement statement) throws SQLException {

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `planes` (`plane_id` INT NOT NULL AUTO_INCREMENT," +
                " `planeName` VARCHAR(45) NOT NULL,  PRIMARY KEY (`plane_id`))ENGINE = InnoDB;");

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS airports (`airports_id` INT NOT NULL AUTO_INCREMENT," +
                "  `acronim` VARCHAR(3) NOT NULL, `name` VARCHAR(45) NULL, PRIMARY KEY (`airports_id`))ENGINE = InnoDB;");

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS pilots (`pilot_id` INT NOT NULL AUTO_INCREMENT,`name` VARCHAR(45) NOT NULL," +
                " `birthDay` DATETIME NULL, `phone` VARCHAR(45) NOT NULL,  PRIMARY KEY (`pilot_id`))ENGINE = InnoDB;");

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS airHostesses (`airHostesses_id` INT NOT NULL AUTO_INCREMENT," +
                "  `name` VARCHAR(45) NOT NULL, `birthDay` DATETIME NULL, PRIMARY KEY (`airHostesses_id`))ENGINE = InnoDB;");

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS crews (`crews_id` INT NOT NULL AUTO_INCREMENT," +
                " `name` VARCHAR(45) NULL, `pilot1` INT NOT NULL, `pilot2` INT NULL, `airHostess1` INT NOT NULL," +
                "  `airHostess2` INT NULL,  PRIMARY KEY (`crews_id`), UNIQUE INDEX `pilot1_UNIQUE` (`pilot1` ASC)," +
                "  UNIQUE INDEX `pilot2_UNIQUE` (`pilot2` ASC),  UNIQUE INDEX `airHostess1_UNIQUE` (`airHostess1` ASC)," +
                "  UNIQUE INDEX `airHostess2_UNIQUE` (`airHostess2` ASC),  CONSTRAINT `pilot1_fk` FOREIGN KEY (`pilot1`)" +
                "  REFERENCES pilots (`pilot_id`) ON DELETE CASCADE ON UPDATE CASCADE," +
                "  CONSTRAINT `pilot2_fk` FOREIGN KEY (`pilot2`)  REFERENCES pilots (`pilot_id`)" +
                "  ON DELETE CASCADE ON UPDATE CASCADE,  CONSTRAINT `airHostess1_fk` FOREIGN KEY (`airHostess1`)" +
                "  REFERENCES airHostesses (`airHostesses_id`) ON DELETE CASCADE" +
                "  ON UPDATE CASCADE, CONSTRAINT `airHostess2_fk` FOREIGN KEY (`airHostess2`)" +
                "  REFERENCES airHostesses (`airHostesses_id`)\n" +
                "  ON DELETE CASCADE ON UPDATE CASCADE) ENGINE = InnoDB;");

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS roles (`role_id` INT NOT NULL AUTO_INCREMENT," +
                "  `name` VARCHAR(45) NOT NULL, PRIMARY KEY (`role_id`))ENGINE = InnoDB");

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (  `user_id` INT NOT NULL AUTO_INCREMENT," +
                "  `login` VARCHAR(45) NOT NULL,`pass` VARCHAR(45) NOT NULL, `role` INT NOT NULL," +
                "  `email` VARCHAR(65) NOT NULL, PRIMARY KEY (`user_id`), UNIQUE INDEX `login_UNIQUE` (`login` ASC)," +
                "  INDEX `roleFK_idx` (`role` ASC), UNIQUE INDEX `email_UNIQUE` (`email` ASC), CONSTRAINT `fk_role`" +
                "    FOREIGN KEY (`role`)  REFERENCES roles (`role_id`) ON DELETE NO ACTION" +
                "    ON UPDATE NO ACTION)ENGINE = InnoDB;");



        statement.executeUpdate("CREATE TABLE IF NOT EXISTS flights (`flight_id` INT NOT NULL AUTO_INCREMENT," +
                "  `flightCode` VARCHAR(5) NOT NULL,  `company` VARCHAR(45) NULL, `depatrure_time` DATETIME NOT NULL," +
                "  `arrival_time` DATETIME NOT NULL, `plane` INT NOT NULL, `to` INT NOT NULL," +
                "  `from` INT NOT NULL," +
                "  `crew` INT NOT NULL," +
                "  `admin` INT NOT NULL," +
                "  `dispatcher` INT NOT NULL," +
                "  PRIMARY KEY (`flight_id`)," +
                "  INDEX `planeFK_idx` (`plane` ASC)," +
                "  INDEX `toFK_idx` (`to` ASC)," +
                "  INDEX `fromFK_idx` (`from` ASC)," +
                "  INDEX `crewFK_idx` (`crew` ASC)," +
                "  INDEX `fk_userID_idx` (`admin` ASC)," +
                "  INDEX `fk_dispatcherID_idx` (`dispatcher` ASC)," +
                "  CONSTRAINT `fk_plane`" +
                "    FOREIGN KEY (`plane`)" +
                "    REFERENCES planes (`plane_id`)" +
                "    ON DELETE CASCADE" +
                "    ON UPDATE CASCADE," +
                "  CONSTRAINT `fk_to`" +
                "    FOREIGN KEY (`to`)" +
                "    REFERENCES airports (`airports_id`)" +
                "    ON DELETE CASCADE" +
                "    ON UPDATE CASCADE," +
                "  CONSTRAINT `fk_from`" +
                "    FOREIGN KEY (`from`)" +
                "    REFERENCES airports (`airports_id`)" +
                "    ON DELETE NO ACTION" +
                "    ON UPDATE NO ACTION," +
                "  CONSTRAINT `fk_crew`" +
                "    FOREIGN KEY (`crew`)" +
                "    REFERENCES crews (`crews_id`)" +
                "    ON DELETE NO ACTION" +
                "    ON UPDATE NO ACTION," +
                "  CONSTRAINT `fk_adminID`" +
                "    FOREIGN KEY (`admin`)" +
                "    REFERENCES users (`user_id`)" +
                "    ON DELETE NO ACTION" +
                "    ON UPDATE NO ACTION," +
                "  CONSTRAINT `fk_dispatcherID`" +
                "    FOREIGN KEY (`dispatcher`)" +
                "    REFERENCES users (`user_id`)" +
                "    ON DELETE NO ACTION" +
                "    ON UPDATE NO ACTION)" +
                "ENGINE = InnoDB;");

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS cmd (`cmd_id` INT NOT NULL AUTO_INCREMENT," +
                "  `action` VARCHAR(45) NOT NULL, `permission` TINYINT(1) NOT NULL," +
                "  `role` INT NOT NULL,  PRIMARY KEY (`cmd_id`), INDEX `role_fk_idx` (`role` ASC)," +
                "  CONSTRAINT `role_fk` FOREIGN KEY (`role`) REFERENCES roles (`role_id`)" +
                "    ON DELETE CASCADE ON UPDATE CASCADE) ENGINE = InnoDB;");
    }

    public static void fillTables(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO planes (planeName) VALUES ('Boeing-747'),('Boeing-727'),('Boeing 737-500'),('Airbus A320'),('Gulfstream 650'),('Embraer EMB190');");
        statement.executeUpdate("INSERT INTO airports (acronim, name) VALUES ('MSQ', 'Minsk-2'),('VIE', 'Vienna'),('TGD', 'Golubovichi'),('SVO', 'Sheremetyevo'),('BKA', 'Bukovo');");
        statement.executeUpdate("INSERT INTO roles (name) VALUES ('administrator'),('dispatcher'),('user');");
        statement.executeUpdate("INSERT INTO users (login, pass, role, email)" +
                " VALUES ('admin', 'admin', 1, 'admin@gmail.com')," +
                "('dispatcher', 'dispatcher', 2, 'dispatcher@gmail.com')," +
                "('user', 'user123', 3, 'user123@gmail.com')," +
                "('user1', 'user1', 3, 'blabla@gmail.com')");
    }
}
