-- MySQL Script generated by MySQL Workbench
-- Wed Oct 14 12:48:54 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema laboratorio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema laboratorio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `laboratorio` DEFAULT CHARACTER SET utf8 ;
USE `laboratorio` ;

-- -----------------------------------------------------
-- Table `laboratorio`.`cat_categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`cat_categoria` (
  `CATEGORIA_ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `ORDEN` INT NOT NULL DEFAULT 0,
  `ESTADO` TINYINT(1) NOT NULL DEFAULT 1,
  `FECHA_CREACION` DATETIME NOT NULL,
  `FECHA_ACTUALIZACION` DATETIME NOT NULL,
  PRIMARY KEY (`CATEGORIA_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`examen_general`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`examen_general` (
  `EXAMEN_ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(150) NOT NULL,
  `ALIAS` VARCHAR(205) NULL,
  `TITULO_EXAMEN_IZQUIERDO` VARCHAR(200) NULL,
  `TITULO_EXAMEN_CENTRO` VARCHAR(200) NULL,
  `TITULO_EXAMEN_DERECHO` VARCHAR(200) NULL,
  `ESTADO` TINYINT NOT NULL DEFAULT 1,
  `PRECIO` DECIMAL(15,2) NOT NULL DEFAULT 0.0,
  `CLAVE` VARCHAR(50) NULL,
  `LAYOUT` TINYINT NOT NULL,
  `CATEGORIA_ID` INT NOT NULL,
  `METODO` JSON NULL,
  `FECHA_CREACION` DATETIME NOT NULL,
  `FECHA_ACTUALIZACION` DATETIME NOT NULL,
  PRIMARY KEY (`EXAMEN_ID`, `CATEGORIA_ID`),
  UNIQUE INDEX `general_id_UNIQUE` (`EXAMEN_ID` ASC) VISIBLE,
  INDEX `fk_examen_general_cat_categoria1_idx` (`CATEGORIA_ID` ASC) VISIBLE,
  CONSTRAINT `fk_examen_general_cat_categoria1`
    FOREIGN KEY (`CATEGORIA_ID`)
    REFERENCES `laboratorio`.`cat_categoria` (`CATEGORIA_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`cat_paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`cat_paciente` (
  `PACIENTE_ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(65) NOT NULL,
  `APELLIDO_PATERNO` VARCHAR(65) NOT NULL,
  `APELLIDO_MATERNO` VARCHAR(65) NULL,
  `FECHA_NACIMIENTO` DATE NOT NULL,
  `SEXO` TINYINT NOT NULL DEFAULT 0,
  `EMAIL` VARCHAR(100) NULL,
  `ESTADO` TINYINT NOT NULL DEFAULT 1,
  `TELEFONO` VARCHAR(10) NULL,
  `FECHA_CREACION` DATETIME NOT NULL,
  `FECHA_ACTUALIZACION` DATETIME NOT NULL,
  PRIMARY KEY (`PACIENTE_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`cat_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`cat_usuario` (
  `USUARIO_ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(65) NOT NULL,
  `APELLIDO_PATERNO` VARCHAR(65) NOT NULL,
  `APELLIDO_MATERNO` VARCHAR(65) NULL,
  `NOMBRE_USUARIO` VARCHAR(45) NOT NULL,
  `CEDULA` VARCHAR(8) NULL,
  `EMAIL` VARCHAR(100) NULL,
  `MOVIL` VARCHAR(20) NULL,
  `DIRECCION` VARCHAR(250) NULL,
  `FOTO_PERFIL` VARCHAR(100) NULL,
  `PASSWORD` VARCHAR(45) NOT NULL,
  `ESTADO` TINYINT NOT NULL DEFAULT 1,
  `FECHA_CREACION` DATETIME NOT NULL,
  `FECHA_ACTUALIZACION` DATETIME NOT NULL,
  PRIMARY KEY (`USUARIO_ID`),
  UNIQUE INDEX `USUARIO_ID_UNIQUE` (`USUARIO_ID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`cat_seccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`cat_seccion` (
  `SECCION_ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(150) NOT NULL,
  `TITULO` VARCHAR(200) NULL,
  `TEXTO_CENTRO` VARCHAR(200) NULL,
  `TEXTO_DERECHO` VARCHAR(2000) NULL,
  `ESTADO` TINYINT NOT NULL DEFAULT 1,
  `FECHA_CREACION` DATETIME NOT NULL,
  `FECHA_ACTUALIZACION` DATETIME NOT NULL,
  PRIMARY KEY (`SECCION_ID`),
  UNIQUE INDEX `SECCION_ID_UNIQUE` (`SECCION_ID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`cat_metodo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`cat_metodo` (
  `METODO_ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(150) NOT NULL,
  `ESTADO` TINYINT NOT NULL DEFAULT 1,
  `FECHA_CREACION` DATETIME NOT NULL,
  `FECHA_ACTUALIZACION` DATETIME NOT NULL,
  PRIMARY KEY (`METODO_ID`),
  UNIQUE INDEX `METODO_ID_UNIQUE` (`METODO_ID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`rol` (
  `ID_ROL` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(50) NOT NULL,
  `ESTADO` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID_ROL`),
  UNIQUE INDEX `ID_ROL_UNIQUE` (`ID_ROL` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`cat_estudio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`cat_estudio` (
  `ESTUDIO_ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NULL,
  `RESULTADO` VARCHAR(50),
  `RESULTADO_SELECT` JSON NULL,
  `MOSTRAR_INPUT` TINYINT NULL,
  `COMODIN` TINYINT NULL DEFAULT 0,
  `ESTADO` TINYINT NOT NULL DEFAULT 1,
  `FECHA_CREACION` DATETIME NOT NULL,
  `FECHA_ACTUALIZACION` DATETIME NOT NULL,
  PRIMARY KEY (`ESTUDIO_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`cat_medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`cat_medico` (
  `MEDICO_ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(65) NOT NULL,
  `APELLIDO_PATERNO` VARCHAR(65) NOT NULL,
  `APELLIDO_MATERNO` VARCHAR(65) NULL,
  `ESTADO` TINYINT(1) NULL DEFAULT 1,
  `FECHA_CREACION` DATETIME NOT NULL,
  `FECHA_ACTUALIZACION` DATETIME NULL,
  PRIMARY KEY (`MEDICO_ID`),
  UNIQUE INDEX `ATENCION_ID_UNIQUE` (`MEDICO_ID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`recepcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`recepcion` (
  `RECEPCION_ID` CHAR(12) NOT NULL,
  `FECHA_INGRESO` DATE NOT NULL,
  `HORA_INGRESO` TIME NOT NULL,
  `FICHA` INT NOT NULL,
  `TOTAL` DECIMAL(10,2) NULL DEFAULT 0,
  `SUB_TOTAL` DECIMAL(10,2) NULL DEFAULT 0,
  `DESCUENTO` DECIMAL(10,2) NULL DEFAULT 0,
  `ANTICIPO` DECIMAL(10,2) NULL DEFAULT 0,
  `RESTANTE` DECIMAL(10,2) NULL DEFAULT 0,
  `IMPORTE` DECIMAL(10,2) NULL DEFAULT 0,
  `PAGADO` TINYINT(1) NULL DEFAULT false,
  `FINALIZADO` TINYINT(1) NULL DEFAULT false,
  `IMPRESO` TINYINT(1) NULL DEFAULT false,
  `ENTREGADO` TINYINT(1) NULL DEFAULT false,
  `MUESTRAS` VARCHAR(250),
  `NOTAS` VARCHAR(250),
  `USUARIO_ID` INT NOT NULL,
  `MEDICO_ID` INT NOT NULL,
  `PACIENTE_ID` INT NOT NULL,
  PRIMARY KEY (`RECEPCION_ID`, `USUARIO_ID`),
  INDEX `fk_recepcion_cat_usuario1_idx` (`USUARIO_ID` ASC) VISIBLE,
  INDEX `fk_recepcion_cat_medico1_idx` (`MEDICO_ID` ASC) VISIBLE,
  INDEX `fk_recepcion_cat_paciente1_idx` (`PACIENTE_ID` ASC) VISIBLE,
  CONSTRAINT `fk_recepcion_cat_usuario1`
    FOREIGN KEY (`USUARIO_ID`)
    REFERENCES `laboratorio`.`cat_usuario` (`USUARIO_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recepcion_cat_medico1`
    FOREIGN KEY (`MEDICO_ID`)
    REFERENCES `laboratorio`.`cat_medico` (`MEDICO_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recepcion_cat_paciente1`
    FOREIGN KEY (`PACIENTE_ID`)
    REFERENCES `laboratorio`.`cat_paciente` (`PACIENTE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`menu` (
  `MENU_ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `RUTA` VARCHAR(45) NOT NULL,
  `DROPDOWN` TINYINT(1) NOT NULL DEFAULT 0,
  `ICONO` VARCHAR(50) NULL,
  `ESTADO` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`MENU_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`sub_menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`sub_menu` (
  `SUB_MENU_ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `RUTA` VARCHAR(45) NOT NULL,
  `DROPDOWN` TINYINT(1) NOT NULL DEFAULT 0,
  `ICONO` VARCHAR(50) NULL,
  `ESTADO` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`SUB_MENU_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`menu_sub_menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`menu_sub_menu` (
  `MENU_SUBMENU_ID` BINARY(16) NOT NULL PRIMARY KEY,
  `MENU_ID` INT NOT NULL,
  `SUB_MENU_ID` INT NOT NULL,
  -- PRIMARY KEY (`MENU_ID`, `SUB_MENU_ID`),
  INDEX `fk_menu_has_sub_menu_sub_menu1_idx` (`SUB_MENU_ID` ASC) VISIBLE,
  INDEX `fk_menu_has_sub_menu_menu1_idx` (`MENU_ID` ASC) VISIBLE,
  CONSTRAINT `fk_menu_has_sub_menu_menu1`
    FOREIGN KEY (`MENU_ID`)
    REFERENCES `laboratorio`.`menu` (`MENU_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_menu_has_sub_menu_sub_menu1`
    FOREIGN KEY (`SUB_MENU_ID`)
    REFERENCES `laboratorio`.`sub_menu` (`SUB_MENU_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`cat_descuento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`cat_descuento` (
  `DESCUENTO_ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(50) NOT NULL,
  `DESCRIPCION` VARCHAR(100) NULL,
  `FECHA_INICIO` DATETIME NOT NULL,
  `FECHA_FIN` DATETIME NOT NULL,
  `DIAS` VARCHAR(45) NOT NULL,
  `ESTADO` TINYINT(1) NOT NULL DEFAULT 1,
  `FECHA_CREACION` DATETIME NOT NULL,
  `FECHA_ACTUALIZACION` DATETIME NOT NULL,
  PRIMARY KEY (`DESCUENTO_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`examen_general_descuento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`examen_general_descuento` (
  `EXAMEN_DESCUENTO_ID` BINARY(16) NOT NULL PRIMARY KEY,
  `DESCUENTO_ID` INT NOT NULL,
  `EXAMEN_ID` INT NOT NULL,
  `PORCENTAJE_DESCUENTO` INT NULL,
  `PORCENTAJE_DESCUENTO_TEXTO` VARCHAR(50) NULL,
  `DESCUENTO` DECIMAL(10,2) NULL,
  -- PRIMARY KEY (`DESCUENTO_ID`, `EXAMEN_ID`),
  INDEX `fk_cat_descuento_has_cat_examen_general_cat_examen_general1_idx` (`EXAMEN_ID` ASC) VISIBLE,
  INDEX `fk_cat_descuento_has_cat_examen_general_cat_descuento1_idx` (`DESCUENTO_ID` ASC) VISIBLE,
  CONSTRAINT `fk_cat_descuento_has_cat_examen_general_cat_descuento1`
    FOREIGN KEY (`DESCUENTO_ID`)
    REFERENCES `laboratorio`.`cat_descuento` (`DESCUENTO_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cat_descuento_has_cat_examen_general_cat_examen_general1`
    FOREIGN KEY (`EXAMEN_ID`)
    REFERENCES `laboratorio`.`examen_general` (`EXAMEN_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`metodo_seccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`metodo_seccion` (
  `METODO_SECCION` BINARY(16) NOT NULL PRIMARY KEY,
  `METODO_ID` INT NOT NULL,
  `SECCION_ID` INT NOT NULL,
  -- PRIMARY KEY (`METODO_ID`, `SECCION_ID`),
  INDEX `fk_metodo_cat_has_seccion_cat_seccion_cat1_idx` (`SECCION_ID` ASC) VISIBLE,
  INDEX `fk_metodo_cat_has_seccion_cat_metodo_cat1_idx` (`METODO_ID` ASC) VISIBLE,
  CONSTRAINT `fk_metodo_cat_has_seccion_cat_metodo_cat1`
    FOREIGN KEY (`METODO_ID`)
    REFERENCES `laboratorio`.`cat_metodo` (`METODO_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_metodo_cat_has_seccion_cat_seccion_cat1`
    FOREIGN KEY (`SECCION_ID`)
    REFERENCES `laboratorio`.`cat_seccion` (`SECCION_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`estudio_seccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`estudio_seccion` (
  `ESTUDIO_SECCION_ID` BINARY(16) NOT NULL PRIMARY KEY,
  `ESTUDIO_ID` INT NOT NULL,
  `SECCION_ID` INT NOT NULL,
  `ORDEN` INT NOT NULL DEFAULT 0,
  -- PRIMARY KEY (`ESTUDIO_ID`, `SECCION_ID`),
  INDEX `fk_estudio_has_seccion_cat_seccion_cat1_idx` (`SECCION_ID` ASC) VISIBLE,
  INDEX `fk_estudio_has_seccion_cat_estudio1_idx` (`ESTUDIO_ID` ASC) VISIBLE,
  CONSTRAINT `fk_estudio_has_seccion_cat_estudio1`
    FOREIGN KEY (`ESTUDIO_ID`)
    REFERENCES `laboratorio`.`cat_estudio` (`ESTUDIO_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_estudio_has_seccion_cat_seccion_cat1`
    FOREIGN KEY (`SECCION_ID`)
    REFERENCES `laboratorio`.`cat_seccion` (`SECCION_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`estudio_metodo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`estudio_metodo` (
  `ESTUDIO_METODO_ID` BINARY(16) NOT NULL PRIMARY KEY,
  `ESTUDIO_ID` INT NOT NULL,
  `METODO_ID` INT NOT NULL,
  -- PRIMARY KEY (`ESTUDIO_ID`, `METODO_ID`),
  INDEX `fk_estudio_has_metodo_cat_metodo_cat1_idx` (`METODO_ID` ASC) VISIBLE,
  INDEX `fk_estudio_has_metodo_cat_estudio1_idx` (`ESTUDIO_ID` ASC) VISIBLE,
  CONSTRAINT `fk_estudio_has_metodo_cat_estudio1`
    FOREIGN KEY (`ESTUDIO_ID`)
    REFERENCES `laboratorio`.`cat_estudio` (`ESTUDIO_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_estudio_has_metodo_cat_metodo_cat1`
    FOREIGN KEY (`METODO_ID`)
    REFERENCES `laboratorio`.`cat_metodo` (`METODO_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`cat_clasificacion_paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`cat_clasificacion_paciente` (
  `CLASIFICACION_ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NULL,
  `EDAD_MINIMA` VARCHAR(3) NULL,
  `EDAD_MAXIMA` VARCHAR(3) NULL,
  `ESTADO` TINYINT NOT NULL DEFAULT 1,
  `FECHA_CREACION` DATETIME NOT NULL,
  `FECHA_ACTUALIZACION` DATETIME NOT NULL,
  PRIMARY KEY (`CLASIFICACION_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`referencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`referencia` (
  `REFERENCIA_ID` BINARY(16) NOT NULL PRIMARY KEY,
  `CLASIFICACION_ID` INT NOT NULL,
  `ESTUDIO_ID` INT NOT NULL,
  `SUFIJO` VARCHAR(50) NOT NULL DEFAULT "",
  `PREFIJO` VARCHAR(50) NOT NULL DEFAULT "",
  `MASCULINO` VARCHAR(150) NULL,
  `FEMENINO` VARCHAR(150) NULL,
  `GENERAL` VARCHAR(150) NULL,
  `ORDEN` INT NOT NULL DEFAULT 0,
  `NOTA` VARCHAR(250) NULL,
  `FECHA_CREACION` DATETIME NOT NULL,
  `FECHA_ACTUALIZACION` DATETIME NOT NULL,
  -- PRIMARY KEY (`CLASIFICACION_ID`, `ESTUDIO_ID`),
  INDEX `fk_cat_clasificacion_paciente_has_cat_estudio_cat_estudio1_idx` (`ESTUDIO_ID` ASC) VISIBLE,
  INDEX `fk_cat_clasificacion_paciente_has_cat_estudio_cat_clasifica_idx` (`CLASIFICACION_ID` ASC) VISIBLE,
  CONSTRAINT `fk_cat_clasificacion_paciente_has_cat_estudio_cat_clasificaci1`
    FOREIGN KEY (`CLASIFICACION_ID`)
    REFERENCES `laboratorio`.`cat_clasificacion_paciente` (`CLASIFICACION_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cat_clasificacion_paciente_has_cat_estudio_cat_estudio1`
    FOREIGN KEY (`ESTUDIO_ID`)
    REFERENCES `laboratorio`.`cat_estudio` (`ESTUDIO_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`usuario_rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`usuario_rol` (
  `USUARIO_ROL_ID` BINARY(16) NOT NULL PRIMARY KEY,
  `USUARIO_ID` INT NOT NULL,
  `ID_ROL` INT NOT NULL,
  -- PRIMARY KEY (`USUARIO_ID`, `ID_ROL`),
  INDEX `fk_cat_usuario_has_rol_rol1_idx` (`ID_ROL` ASC) VISIBLE,
  INDEX `fk_cat_usuario_has_rol_cat_usuario1_idx` (`USUARIO_ID` ASC) VISIBLE,
  CONSTRAINT `fk_cat_usuario_has_rol_cat_usuario1`
    FOREIGN KEY (`USUARIO_ID`)
    REFERENCES `laboratorio`.`cat_usuario` (`USUARIO_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cat_usuario_has_rol_rol1`
    FOREIGN KEY (`ID_ROL`)
    REFERENCES `laboratorio`.`rol` (`ID_ROL`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`rol_sub_menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`rol_sub_menu` (
  `ROL_SUB_MENU_ID` BINARY(16) NOT NULL PRIMARY KEY,
  `ID_ROL` INT NOT NULL,
  `SUB_MENU_ID` INT NOT NULL,
  `LEER` TINYINT(1) NOT NULL DEFAULT 1,
  `CREAR` TINYINT(1) NOT NULL DEFAULT 1,
  `ACTUALIZAR` TINYINT(1) NOT NULL DEFAULT 1,
  `BORRAR` TINYINT(1) NOT NULL DEFAULT 1,
  -- PRIMARY KEY (`ID_ROL`, `SUB_MENU_ID`),
  INDEX `fk_rol_has_sub_menu_sub_menu1_idx` (`SUB_MENU_ID` ASC) VISIBLE,
  INDEX `fk_rol_has_sub_menu_rol1_idx` (`ID_ROL` ASC) VISIBLE,
  CONSTRAINT `fk_rol_has_sub_menu_rol1`
    FOREIGN KEY (`ID_ROL`)
    REFERENCES `laboratorio`.`rol` (`ID_ROL`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rol_has_sub_menu_sub_menu1`
    FOREIGN KEY (`SUB_MENU_ID`)
    REFERENCES `laboratorio`.`sub_menu` (`SUB_MENU_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`rol_menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`rol_menu` (
  `ROL_MENU_ID` BINARY(16) NOT NULL PRIMARY KEY,
  `ID_ROL` INT NOT NULL,
  `MENU_ID` INT NOT NULL,
  `LEER` TINYINT(1) NOT NULL DEFAULT 1,
  `CREAR` TINYINT(1) NOT NULL DEFAULT 1,
  `ACTUALIZAR` TINYINT(1) NOT NULL DEFAULT 1,
  `BORRAR` TINYINT(1) NOT NULL DEFAULT 1,
  -- PRIMARY KEY (`ID_ROL`, `MENU_ID`),
  INDEX `fk_rol_has_menu_menu1_idx` (`MENU_ID` ASC) VISIBLE,
  INDEX `fk_rol_has_menu_rol1_idx` (`ID_ROL` ASC) VISIBLE,
  CONSTRAINT `fk_rol_has_menu_rol1`
    FOREIGN KEY (`ID_ROL`)
    REFERENCES `laboratorio`.`rol` (`ID_ROL`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rol_has_menu_menu1`
    FOREIGN KEY (`MENU_ID`)
    REFERENCES `laboratorio`.`menu` (`MENU_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`cotizacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`cotizacion` (
  `COTIZACION_ID` CHAR(12) NOT NULL,
  `FECHA_COTIZACION` DATE NOT NULL,
  `HORA_COTIZACION` TIME NOT NULL,
  PRIMARY KEY (`COTIZACION_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`seccion_examen_general`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`seccion_examen_general` (
  `SECCION_EXAMEN_ID` BINARY(16) NOT NULL PRIMARY KEY,
  `SECCION_ID` INT NOT NULL,
  `EXAMEN_ID` INT NOT NULL,
  `ORDEN` INT NOT NULL DEFAULT 0,
  -- PRIMARY KEY (`SECCION_ID`, `EXAMEN_ID`),
  INDEX `fk_cat_seccion_has_examen_general_examen_general1_idx` (`EXAMEN_ID` ASC) VISIBLE,
  INDEX `fk_cat_seccion_has_examen_general_cat_seccion1_idx` (`SECCION_ID` ASC) VISIBLE,
  CONSTRAINT `fk_cat_seccion_has_examen_general_cat_seccion1`
    FOREIGN KEY (`SECCION_ID`)
    REFERENCES `laboratorio`.`cat_seccion` (`SECCION_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cat_seccion_has_examen_general_examen_general1`
    FOREIGN KEY (`EXAMEN_ID`)
    REFERENCES `laboratorio`.`examen_general` (`EXAMEN_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`estudio_examen_general`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`estudio_examen_general` (
  `ESTUDIO_EXAMEN_ID` BINARY(16) NOT NULL PRIMARY KEY,
  `ESTUDIO_ID` INT NOT NULL,
  `EXAMEN_ID` INT NOT NULL,
  `ORDEN` INT NOT NULL DEFAULT 0,
  -- PRIMARY KEY (`ESTUDIO_ID`, `EXAMEN_ID`),
  INDEX `fk_cat_estudio_has_examen_general_examen_general1_idx` (`EXAMEN_ID` ASC) VISIBLE,
  INDEX `fk_cat_estudio_has_examen_general_cat_estudio1_idx` (`ESTUDIO_ID` ASC) VISIBLE,
  CONSTRAINT `fk_cat_estudio_has_examen_general_cat_estudio1`
    FOREIGN KEY (`ESTUDIO_ID`)
    REFERENCES `laboratorio`.`cat_estudio` (`ESTUDIO_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cat_estudio_has_examen_general_examen_general1`
    FOREIGN KEY (`EXAMEN_ID`)
    REFERENCES `laboratorio`.`examen_general` (`EXAMEN_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`examen_general_recepcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`examen_general_recepcion` (
  `EXAMEN_RECEPCION_ID` BINARY(16) NOT NULL PRIMARY KEY,
  `EXAMEN_ID` INT NOT NULL,
  `RECEPCION_ID` CHAR(12) NOT NULL,
  `USUARIO_ID` INT NOT NULL,
  `RESULTADO` LONGTEXT NULL,
  -- PRIMARY KEY (`EXAMEN_ID`, `RECEPCION_ID`, `USUARIO_ID`),
  INDEX `fk_examen_general_has_recepcion_recepcion1_idx` (`RECEPCION_ID` ASC, `USUARIO_ID` ASC) VISIBLE,
  INDEX `fk_examen_general_has_recepcion_examen_general1_idx` (`EXAMEN_ID` ASC) VISIBLE,
  CONSTRAINT `fk_examen_general_has_recepcion_examen_general1`
    FOREIGN KEY (`EXAMEN_ID`)
    REFERENCES `laboratorio`.`examen_general` (`EXAMEN_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_examen_general_has_recepcion_recepcion1`
    FOREIGN KEY (`RECEPCION_ID` , `USUARIO_ID`)
    REFERENCES `laboratorio`.`recepcion` (`RECEPCION_ID` , `USUARIO_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`examen_general_cotizacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`examen_general_cotizacion` (
  `EXAMEN_COTIZACION_ID` BINARY(16) NOT NULL PRIMARY KEY,
  `EXAMEN_ID` INT NOT NULL,
  `COTIZACION_ID` CHAR(12) NOT NULL,
  -- PRIMARY KEY (`EXAMEN_ID`, `COTIZACION_ID`),
  INDEX `fk_examen_general_has_cotizacion_cotizacion1_idx` (`COTIZACION_ID` ASC) VISIBLE,
  INDEX `fk_examen_general_has_cotizacion_examen_general1_idx` (`EXAMEN_ID` ASC) VISIBLE,
  CONSTRAINT `fk_examen_general_has_cotizacion_examen_general1`
    FOREIGN KEY (`EXAMEN_ID`)
    REFERENCES `laboratorio`.`examen_general` (`EXAMEN_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_examen_general_has_cotizacion_cotizacion1`
    FOREIGN KEY (`COTIZACION_ID`)
    REFERENCES `laboratorio`.`cotizacion` (`COTIZACION_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `laboratorio`.`cat_paquete`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`cat_paquete` (
  `PAQUETE_ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(50) NOT NULL,
  `DESCRIPCION` VARCHAR(100) NULL,
  `FECHA_INICIO` DATETIME NOT NULL,
  `FECHA_FIN` DATETIME NOT NULL,
  `DIAS` VARCHAR(45) NOT NULL,
  `PRECIO` DECIMAL(10,2) NOT NULL,
  `PORCENTAJE_DESCUENTO` INT NULL,
  `PORCENTAJE_DESCUENTO_TEXTO` VARCHAR(50) NULL,
  `DESCUENTO` DECIMAL(10,2) NULL,
  `ESTADO` TINYINT(1) NOT NULL DEFAULT 1,
  `FECHA_CREACION` DATETIME NOT NULL,
  `FECHA_ACTUALIZACION` DATETIME NOT NULL,
  PRIMARY KEY (`PAQUETE_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratorio`.`cat_paquete_examen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`cat_paquete_examen` (
  `PAQUETE_EXAMEN_ID` BINARY(16) NOT NULL PRIMARY KEY,
  `PAQUETE_ID` INT NOT NULL,
  `EXAMEN_ID` INT NOT NULL,
  -- PRIMARY KEY (`PAQUETE_ID`, `EXAMEN_ID`),
  INDEX `fk_cat_paquete_has_examen_general_examen_general1_idx` (`EXAMEN_ID` ASC) VISIBLE,
  INDEX `fk_cat_paquete_has_examen_general_cat_paquete1_idx` (`PAQUETE_ID` ASC) VISIBLE,
  CONSTRAINT `fk_cat_paquete_has_examen_general_cat_paquete1`
    FOREIGN KEY (`PAQUETE_ID`)
    REFERENCES `laboratorio`.`cat_paquete` (`PAQUETE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cat_paquete_has_examen_general_examen_general1`
    FOREIGN KEY (`EXAMEN_ID`)
    REFERENCES `laboratorio`.`examen_general` (`EXAMEN_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
