-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dubatovka_helpDesk
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dubatovka_helpDesk` ;

-- -----------------------------------------------------
-- Schema dubatovka_helpDesk
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dubatovka_helpDesk` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `dubatovka_helpDesk` ;

-- -----------------------------------------------------
-- Table `dubatovka_helpDesk`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dubatovka_helpDesk`.`role` ;

CREATE TABLE IF NOT EXISTS `dubatovka_helpDesk`.`role` (
  `idRole` INT NOT NULL AUTO_INCREMENT,
  `roleName` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idRole`),
  UNIQUE INDEX `idRole_UNIQUE` (`idRole` ASC),
  UNIQUE INDEX `roleName_UNIQUE` (`roleName` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dubatovka_helpDesk`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dubatovka_helpDesk`.`users` ;

CREATE TABLE IF NOT EXISTS `dubatovka_helpDesk`.`users` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NULL,
  `fk_role` INT NOT NULL,
  PRIMARY KEY (`idUser`),
  INDEX `role_idx` (`fk_role` ASC),
  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  CONSTRAINT `fk_role`
    FOREIGN KEY (`fk_role`)
    REFERENCES `dubatovka_helpDesk`.`role` (`idRole`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dubatovka_helpDesk`.`object`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dubatovka_helpDesk`.`object` ;

CREATE TABLE IF NOT EXISTS `dubatovka_helpDesk`.`object` (
  `idObject` INT NOT NULL AUTO_INCREMENT,
  `zia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idObject`),
  UNIQUE INDEX `idObject_UNIQUE` (`idObject` ASC),
  UNIQUE INDEX `zia_UNIQUE` (`zia` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dubatovka_helpDesk`.`status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dubatovka_helpDesk`.`status` ;

CREATE TABLE IF NOT EXISTS `dubatovka_helpDesk`.`status` (
  `idStatus` INT NOT NULL AUTO_INCREMENT,
  `statusName` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idStatus`),
  UNIQUE INDEX `idStatus_UNIQUE` (`idStatus` ASC),
  UNIQUE INDEX `statuscol_UNIQUE` (`statusName` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dubatovka_helpDesk`.`priority`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dubatovka_helpDesk`.`priority` ;

CREATE TABLE IF NOT EXISTS `dubatovka_helpDesk`.`priority` (
  `idPriority` INT NOT NULL AUTO_INCREMENT,
  `priorityName` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idPriority`),
  UNIQUE INDEX `idPriority_UNIQUE` (`idPriority` ASC),
  UNIQUE INDEX `priorityName_UNIQUE` (`priorityName` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dubatovka_helpDesk`.`ad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dubatovka_helpDesk`.`ad` ;

CREATE TABLE IF NOT EXISTS `dubatovka_helpDesk`.`ad` (
  `idAd` INT NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(45) NOT NULL,
  `description` VARCHAR(300) NULL,
  `fk_zia` INT NOT NULL,
  `fk_user` INT NOT NULL,
  `fk_status` INT NOT NULL,
  `fk_priority` INT NOT NULL,
  PRIMARY KEY (`idAd`),
  INDEX `fk_user_idx` (`fk_user` ASC),
  INDEX `fk_zia_idx` (`fk_zia` ASC),
  INDEX `fk_status_idx` (`fk_status` ASC),
  UNIQUE INDEX `idAd_UNIQUE` (`idAd` ASC),
  INDEX `fk_priority_idx` (`fk_priority` ASC),
  CONSTRAINT `fk_user`
    FOREIGN KEY (`fk_user`)
    REFERENCES `dubatovka_helpDesk`.`users` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_zia`
    FOREIGN KEY (`fk_zia`)
    REFERENCES `dubatovka_helpDesk`.`object` (`idObject`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_status`
    FOREIGN KEY (`fk_status`)
    REFERENCES `dubatovka_helpDesk`.`status` (`idStatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_priority`
    FOREIGN KEY (`fk_priority`)
    REFERENCES `dubatovka_helpDesk`.`priority` (`idPriority`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
