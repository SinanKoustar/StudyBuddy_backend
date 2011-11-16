SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';



CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;

USE `mydb` ;



-- -----------------------------------------------------

-- Table `mydb`.`Category`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`Category` (

  `idCategory` INT NOT NULL AUTO_INCREMENT ,

  `Description` VARCHAR(15) NOT NULL ,

  PRIMARY KEY (`idCategory`) ,

  UNIQUE INDEX `Discription_UNIQUE` (`Description` ASC) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`Notes`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`Notes` (

  `idNotes` INT NOT NULL AUTO_INCREMENT ,

  `Subject` VARCHAR(45) NOT NULL ,

  `Message` VARCHAR(161) NOT NULL ,

  `Creation_Date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,

  `Status` TINYINT(1)  NOT NULL DEFAULT TRUE ,

  `UserID` INT NOT NULL ,

  `CategoryID` INT NOT NULL ,

  PRIMARY KEY (`idNotes`) ,

  INDEX `idCategory` (`CategoryID` ASC) ,

  CONSTRAINT `idCategory`

    FOREIGN KEY (`CategoryID` )

    REFERENCES `mydb`.`Category` (`idCategory` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`User`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`User` (

  `idUser` INT NOT NULL AUTO_INCREMENT ,

  `Name` VARCHAR(20) NOT NULL ,

  `Last_Name` VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`idUser`) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`Contact`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`Contact` (

  `idContact` INT NOT NULL AUTO_INCREMENT ,

  `UserID` INT NOT NULL ,

  `Email` VARCHAR(45) NOT NULL ,

  `Phone_Number` VARCHAR(20) NOT NULL ,

  PRIMARY KEY (`idContact`) ,

  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) )

ENGINE = InnoDB;







SET SQL_MODE=@OLD_SQL_MODE;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

