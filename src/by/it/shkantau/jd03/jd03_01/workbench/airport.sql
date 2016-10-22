-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema airportDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema airportDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `airportDB` DEFAULT CHARACTER SET utf8 ;
USE `airportDB` ;

-- -----------------------------------------------------
-- Table `airportDB`.`planes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`planes` (
  `plane_id` INT NOT NULL AUTO_INCREMENT,
  `planeName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`plane_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airportDB`.`airports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`airports` (
  `airports_id` INT NOT NULL AUTO_INCREMENT,
  `acronim` VARCHAR(3) NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`airports_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airportDB`.`pilots`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`pilots` (
  `pilot_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `birthDay` DATETIME NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`pilot_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airportDB`.`airHostesses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`airHostesses` (
  `airHostesses_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `birthDay` DATETIME NULL,
  PRIMARY KEY (`airHostesses_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airportDB`.`crews`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`crews` (
  `crews_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `pilot1` INT NOT NULL,
  `pilot2` INT NULL,
  `airHostess1` INT NOT NULL,
  `airHostess2` INT NULL,
  PRIMARY KEY (`crews_id`),
  UNIQUE INDEX `pilot1_UNIQUE` (`pilot1` ASC),
  UNIQUE INDEX `pilot2_UNIQUE` (`pilot2` ASC),
  UNIQUE INDEX `airHostess1_UNIQUE` (`airHostess1` ASC),
  UNIQUE INDEX `airHostess2_UNIQUE` (`airHostess2` ASC),
  CONSTRAINT `pilot1_fk`
    FOREIGN KEY (`pilot1`)
    REFERENCES `airportDB`.`pilots` (`pilot_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `pilot2_fk`
    FOREIGN KEY (`pilot2`)
    REFERENCES `airportDB`.`pilots` (`pilot_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `airHostess1_fk`
    FOREIGN KEY (`airHostess1`)
    REFERENCES `airportDB`.`airHostesses` (`airHostesses_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `airHostess2_fk`
    FOREIGN KEY (`airHostess2`)
    REFERENCES `airportDB`.`airHostesses` (`airHostesses_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airportDB`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`roles` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airportDB`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  `role` INT NOT NULL,
  `email` VARCHAR(65) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  INDEX `roleFK_idx` (`role` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  CONSTRAINT `fk_role`
    FOREIGN KEY (`role`)
    REFERENCES `airportDB`.`roles` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airportDB`.`flights`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`flights` (
  `flight_id` INT NOT NULL AUTO_INCREMENT,
  `flightCode` VARCHAR(5) NOT NULL,
  `company` VARCHAR(45) NULL,
  `depatrure_time` DATETIME NOT NULL,
  `arrival_time` DATETIME NOT NULL,
  `plane` INT NOT NULL,
  `to` INT NOT NULL,
  `from` INT NOT NULL,
  `crew` INT NOT NULL,
  `admin` INT NOT NULL,
  `dispatcher` INT NOT NULL,
  PRIMARY KEY (`flight_id`),
  INDEX `planeFK_idx` (`plane` ASC),
  INDEX `toFK_idx` (`to` ASC),
  INDEX `fromFK_idx` (`from` ASC),
  INDEX `crewFK_idx` (`crew` ASC),
  INDEX `fk_userID_idx` (`admin` ASC),
  INDEX `fk_dispatcherID_idx` (`dispatcher` ASC),
  CONSTRAINT `fk_plane`
    FOREIGN KEY (`plane`)
    REFERENCES `airportDB`.`planes` (`plane_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_to`
    FOREIGN KEY (`to`)
    REFERENCES `airportDB`.`airports` (`airports_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_from`
    FOREIGN KEY (`from`)
    REFERENCES `airportDB`.`airports` (`airports_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_crew`
    FOREIGN KEY (`crew`)
    REFERENCES `airportDB`.`crews` (`crews_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_adminID`
    FOREIGN KEY (`admin`)
    REFERENCES `airportDB`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dispatcherID`
    FOREIGN KEY (`dispatcher`)
    REFERENCES `airportDB`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airportDB`.`cmd`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`cmd` (
  `cmd_id` INT NOT NULL AUTO_INCREMENT,
  `action` VARCHAR(45) NOT NULL,
  `permission` TINYINT(1) NOT NULL,
  `role` INT NOT NULL,
  PRIMARY KEY (`cmd_id`),
  INDEX `role_fk_idx` (`role` ASC),
  CONSTRAINT `role_fk`
    FOREIGN KEY (`role`)
    REFERENCES `airportDB`.`roles` (`role_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
