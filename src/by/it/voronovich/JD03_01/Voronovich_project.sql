-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Voronovich_project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Voronovich_project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Voronovich_project` DEFAULT CHARACTER SET utf8 ;
USE `Voronovich_project` ;

-- -----------------------------------------------------
-- Table `Voronovich_project`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Voronovich_project`.`Role` (
  `idRole` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRole`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Voronovich_project`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Voronovich_project`.`Users` (
  `idUsers` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Surname` VARCHAR(45) NOT NULL,
  `Login` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `E-mail` VARCHAR(45) NOT NULL,
  `Role_idRole` INT NOT NULL,
  PRIMARY KEY (`idUsers`, `Role_idRole`),
  INDEX `fk_Users_Role1_idx` (`Role_idRole` ASC),
  CONSTRAINT `fk_Users_Role1`
    FOREIGN KEY (`Role_idRole`)
    REFERENCES `Voronovich_project`.`Role` (`idRole`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Voronovich_project`.`Catalog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Voronovich_project`.`Catalog` (
  `idCatalog` INT NOT NULL AUTO_INCREMENT,
  `Brand` VARCHAR(45) NOT NULL,
  `Model` VARCHAR(45) NOT NULL,
  `Price` DECIMAL(10) NOT NULL,
  `ReleaseDate` VARCHAR(45) NOT NULL,
  `Weigth` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCatalog`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Voronovich_project`.`ShoppingCart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Voronovich_project`.`ShoppingCart` (
  `idShoppingCart` INT NOT NULL AUTO_INCREMENT,
  `Users_idUsers` INT NOT NULL,
  `Catalog_idCatalog` INT NOT NULL,
  PRIMARY KEY (`idShoppingCart`, `Users_idUsers`, `Catalog_idCatalog`),
  INDEX `fk_ShoppingCart_Catalog_idx` (`Catalog_idCatalog` ASC),
  INDEX `fk_ShoppingCart_Users1_idx` (`Users_idUsers` ASC),
  CONSTRAINT `fk_ShoppingCart_Catalog`
    FOREIGN KEY (`Catalog_idCatalog`)
    REFERENCES `Voronovich_project`.`Catalog` (`idCatalog`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ShoppingCart_Users1`
    FOREIGN KEY (`Users_idUsers`)
    REFERENCES `Voronovich_project`.`Users` (`idUsers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
