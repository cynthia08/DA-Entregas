create database hibernate;

use hibernate;

CREATE TABLE IF NOT EXISTS JUGADOR(
id int auto_increment,
nombre varchar(255) not null,
primary key (id)
);

CREATE TABLE IF NOT EXISTS JUEGO(
id int auto_increment,
JugadorUno int,
JugadorDos int null,
Ganador int,
primary key (id)
);

select * from jugador;
select * from juego;

drop table juego;
drop table jugador;