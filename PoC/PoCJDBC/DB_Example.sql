USE `ultimateGato`;

SELECT * FROM ultimateGato.Juegos;
SELECT * FROM ultimateGato.Jugador;

CALL nuevoJugador('David');

CALL nuevoJugador('Muchacho');

CALL buscarJuego();

CALL insertarJugador(1, 'Cyn');

CALL buscarJuego();

CALL getNombre(1);

CALL ganarJuego(1, 2);

SELECT * FROM ultimateGato.Juegos;
SELECT * FROM ultimateGato.Jugador;
