DROP SCHEMA IF EXISTS lab10prog3;
CREATE SCHEMA lab10prog3;
USE lab10prog3;
CREATE TABLE genero(
	id_genero INT AUTO_INCREMENT,
    descripcion_genero VARCHAR(100),
    PRIMARY KEY(id_genero)
)ENGINE=InnoDB;
CREATE TABLE categoria(
	id_categoria CHAR,
    descripcion_categoria VARCHAR(100),
    PRIMARY KEY(id_categoria)
)ENGINE=InnoDB;
CREATE TABLE videojuego(
	id_videojuego INT AUTO_INCREMENT,
    fid_genero INT,
    fid_categoria CHAR,
    nombre_videojuego VARCHAR(100),
    fecha_lanzamiento DATE,
    precio_aprox_mercado DECIMAL(10,2),
    num_jugadores_mc INT,
    PRIMARY KEY(id_videojuego),
    FOREIGN KEY(fid_genero) REFERENCES genero(id_genero),
    FOREIGN KEY(fid_categoria) REFERENCES categoria(id_categoria)
)ENGINE=InnoDB;

DROP PROCEDURE IF EXISTS LISTAR_GENEROS;
DROP PROCEDURE IF EXISTS LISTAR_CATEGORIAS;
DROP PROCEDURE IF EXISTS INSERTAR_VIDEOJUEGO;
DELIMITER $
CREATE PROCEDURE LISTAR_GENEROS()
BEGIN
	SELECT id_genero, descripcion_genero FROM genero;
END$
CREATE PROCEDURE INSERTAR_VIDEOJUEGO(
	OUT _id_videojuego INT,
    IN _fid_genero INT,
    IN _fid_categoria CHAR,
    IN _nombre_videojuego VARCHAR(100),
    IN _fecha_lanzamiento DATE,
    IN _precio_aprox_mercado DECIMAL(10,2),
    IN _num_jugadores_mc INT
)BEGIN
	INSERT INTO videojuego(fid_genero,fid_categoria,nombre_videojuego,fecha_lanzamiento,precio_aprox_mercado,num_jugadores_mc) VALUES(_fid_genero,_fid_categoria,_nombre_videojuego,_fecha_lanzamiento,_precio_aprox_mercado,_num_jugadores_mc);
    SET _id_videojuego = @@last_insert_id;
END$
DELIMITER ;
-- Inserciones de Genero
INSERT INTO genero(descripcion_genero) VALUES("AVENTURA");
INSERT INTO genero(descripcion_genero) VALUES("CARRERAS");
INSERT INTO genero(descripcion_genero) VALUES("SHOOTER");
INSERT INTO genero(descripcion_genero) VALUES("CARRERAS");
INSERT INTO genero(descripcion_genero) VALUES("DEPORTES");
INSERT INTO genero(descripcion_genero) VALUES("ESTRATEGIA");
INSERT INTO genero(descripcion_genero) VALUES("ROL");
INSERT INTO genero(descripcion_genero) VALUES("MUNDO ABIERTO");
INSERT INTO genero(descripcion_genero) VALUES("TERROR");
-- Inserciones de Categorias
INSERT INTO categoria(id_categoria,descripcion_categoria) VALUES('M',"MATURE");
INSERT INTO categoria(id_categoria,descripcion_categoria) VALUES('T',"TEEN");
INSERT INTO categoria(id_categoria,descripcion_categoria) VALUES('E',"EVERYONE");
INSERT INTO categoria(id_categoria,descripcion_categoria) VALUES('A',"ADULTS");
-- Insertando un videojuego
CALL INSERTAR_VIDEOJUEGO(@id_videojuego1,1,'M',"DOOM: THE DARK AGES","2025-05-13",250.00,4);
CALL INSERTAR_VIDEOJUEGO(@id_videojuego2,1,'T',"DEATH STRANDING 2","2025-06-24",300.00,1);