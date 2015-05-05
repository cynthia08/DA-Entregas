START TRANSACTION;

DROP SCHEMA IF EXISTS `ultimateGato` ;
CREATE SCHEMA IF NOT EXISTS `ultimateGato`;
USE `ultimateGato`;

CREATE TABLE IF NOT EXISTS Jugador(
JugadorID int auto_increment,
Nombre varchar(255) not null,
constraint pk_JugadorID primary key (JugadorID)
);

CREATE TABLE IF NOT EXISTS Juegos(
JuegoID int auto_increment,
JugadorUno int,
JugadorDos int,
Ganador int,
constraint pk_JuegoID primary key (JuegoID),
constraint fk_JugadorUno foreign key (JugadorUno) references Jugador(JugadorID),
constraint fk_JugadorDos foreign key (JugadorDos) references Jugador(JugadorID)
);

USE `ultimateGato`;

DROP PROCEDURE IF EXISTS nuevoJugador;
DELIMITER $$
CREATE PROCEDURE nuevoJugador(in param1 varchar(255))
BEGIN
START TRANSACTION;
insert into Jugador(Nombre) values(param1);
select LAST_INSERT_ID() as ID;
COMMIT;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS getNombre;
DELIMITER $$
CREATE PROCEDURE getNombre(in param1 int)
BEGIN
select Nombre from Jugador where JugadorID=param1;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS crearJuego;
DELIMITER $$
CREATE PROCEDURE crearJuego(in param1 int, param2 int)
BEGIN
START TRANSACTION;
insert into Juegos(JugadorUno, JugadorDos) values(param1, param2);
select LAST_INSERT_ID() as ID;
COMMIT;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS ganarJuego;
DELIMITER $$
CREATE PROCEDURE ganarJuego(in param1 int, param2 int)
BEGIN
update Juegos SET Ganador=param2 WHERE JuegoID=param1;
END$$
DELIMITER ;

COMMIT;