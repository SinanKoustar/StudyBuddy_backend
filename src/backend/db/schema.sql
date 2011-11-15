SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Notes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Notes` (
  `idNotes` INT NOT NULL AUTO_INCREMENT ,
  `Betreff` VARCHAR(45) NOT NULL ,
  `Nachricht` VARCHAR(161) NOT NULL ,
  `Eintragsdatum` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `UserID` INT NOT NULL ,
  PRIMARY KEY (`idNotes`) ,
  UNIQUE INDEX `idNotes_UNIQUE` (`idNotes` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT ,
  `Benutzername` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`idUser`) ,
  UNIQUE INDEX `Benutzername_UNIQUE` (`Benutzername` ASC) ,
  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Kontakdaten`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Kontakdaten` (
  `idKontakdaten` INT NOT NULL AUTO_INCREMENT ,
  `UserID` INT NOT NULL ,
  `Email` VARCHAR(45) NOT NULL ,
  `Telefonnummer` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`idKontakdaten`) ,
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) )
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
