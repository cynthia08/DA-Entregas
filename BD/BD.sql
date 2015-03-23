DROP SCHEMA IF EXISTS `ultimateGato` ;
CREATE SCHEMA IF NOT EXISTS `ultimateGato`;
USE `ultimateGato`;

CREATE TABLE IF NOT EXISTS Jugador(
JugadorID int,
Nombre varchar(255) not null,
constraint pk_JugadorID primary key (JugadorID)
);

CREATE TABLE IF NOT EXISTS Juegos(
JuegoID int,
JugadorUno int,
JugadorDos int null,
Activo binary not null,
constraint pk_JuegoID primary key (JuegoID),
constraint fk_JugadorUno foreign key (JugadorUno) references Jugador(JugadorID),
constraint fk_JugadorDos foreign key (JugadorDos) references Jugador(JugadorID)
);

CREATE TABLE IF NOT EXISTS Ganadores(
GanadorID int,
JuegoID int not null,
JugadorID int,
Fecha datetime default now(),
Puntos double not null,
constraint pk_GanadorID primary key (GanadorID),
constraint fk_JugadorID foreign key (JugadorID) references Jugador(JugadorID)
);
