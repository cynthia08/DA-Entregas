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
JugadorDos int null,
Ganador int,
Fecha datetime default now(),
Activo binary not null,
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
insert into Juegos(JugadorUno, Activo) values(LAST_INSERT_ID(), 0);
select LAST_INSERT_ID() as ID;
COMMIT;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS buscarJuego;
DELIMITER $$
CREATE PROCEDURE buscarJuego()
BEGIN
select JuegoID from Juegos where Activo=0 limit 1;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS getNombre;
DELIMITER $$
CREATE PROCEDURE getNombre(in param1 int)
BEGIN
select Nombre from Jugador where JugadorID=param1;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS insertarJugador;
DELIMITER $$
CREATE PROCEDURE insertarJugador(in param1 int, param2 varchar(255))
BEGIN
START TRANSACTION;
insert into Jugador(Nombre) values(param2);
update Juegos set JugadorDos=LAST_INSERT_ID(), Activo=1 where JuegoID=param1;
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
