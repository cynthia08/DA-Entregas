/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author Cyn
 */
public class Juego {

    private static int idJuego;
    private static int jugador1;
    private static int jugador2;

    public Juego(int idJuego, int jugador1, int jugador2) {
        Juego.idJuego = idJuego;
        Juego.jugador1 = jugador1;
        Juego.jugador2 = jugador2;
    }

    public static int getIdJuego() {
        return idJuego;
    }

    public static void setIdJuego(int idJuego) {
        Juego.idJuego = idJuego;
    }

    public static int getJugador1() {
        return jugador1;
    }

    public static void setJugador1(int jugador1) {
        Juego.jugador1 = jugador1;
    }

    public static int getJugador2() {
        return jugador2;
    }

    public static void setJugador2(int jugador2) {
        Juego.jugador2 = jugador2;
    }

}
