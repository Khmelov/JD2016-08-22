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
CREATE SCHEMA IF NOT EXISTS `airportDB` DEFAULT CHARACTER SET cp1251 ;
USE `airportDB` ;

-- -----------------------------------------------------
-- Table `airportDB`.`planes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`planes` (
  `planeID` INT NOT NULL AUTO_INCREMENT,
  `planeName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`planeID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airportDB`.`airports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`airports` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `acronim` VARCHAR(3) NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airportDB`.`pilots`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`pilots` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `birthDay` DATETIME NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airportDB`.`airHostesses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`airHostesses` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `birthDay` DATETIME NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airportDB`.`crews`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`crews` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `pilot1` INT NOT NULL,
  `pilot2` INT NULL,
  `airHostess1` INT NOT NULL,
  `airHostess2` INT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `pilot1_UNIQUE` (`pilot1` ASC),
  UNIQUE INDEX `pilot2_UNIQUE` (`pilot2` ASC),
  UNIQUE INDEX `airHostess1_UNIQUE` (`airHostess1` ASC),
  UNIQUE INDEX `airHostess2_UNIQUE` (`airHostess2` ASC),
  CONSTRAINT `pilot1FK`
    FOREIGN KEY (`pilot1`)
    REFERENCES `airportDB`.`pilots` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `pilot2Fk`
    FOREIGN KEY (`pilot2`)
    REFERENCES `airportDB`.`pilots` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `airHostess1FK`
    FOREIGN KEY (`airHostess1`)
    REFERENCES `airportDB`.`airHostesses` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `airHostess2FK`
    FOREIGN KEY (`airHostess2`)
    REFERENCES `airportDB`.`airHostesses` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airportDB`.`flights`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`flights` (
  `flightID` INT NOT NULL AUTO_INCREMENT,
  `flightCode` VARCHAR(5) NOT NULL,
  `company` VARCHAR(45) NULL,
  `depatrure_time` DATETIME NOT NULL,
  `arrival_time` DATETIME NOT NULL,
  `plane` INT NOT NULL,
  `to` INT NOT NULL,
  `from` INT NOT NULL,
  `crew` INT NOT NULL,
  PRIMARY KEY (`flightID`),
  INDEX `planeFK_idx` (`plane` ASC),
  INDEX `toFK_idx` (`to` ASC),
  INDEX `fromFK_idx` (`from` ASC),
  INDEX `crewFK_idx` (`crew` ASC),
  CONSTRAINT `planeFK`
    FOREIGN KEY (`plane`)
    REFERENCES `airportDB`.`planes` (`planeID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `toFK`
    FOREIGN KEY (`to`)
    REFERENCES `airportDB`.`airports` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fromFK`
    FOREIGN KEY (`from`)
    REFERENCES `airportDB`.`airports` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `crewFK`
    FOREIGN KEY (`crew`)
    REFERENCES `airportDB`.`crews` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airportDB`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `roleType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airportDB`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airportDB`.`users` (
  `userID` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NULL,
  `role` INT NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  INDEX `roleFK_idx` (`role` ASC),
  CONSTRAINT `roleFK`
    FOREIGN KEY (`role`)
    REFERENCES `airportDB`.`roles` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
