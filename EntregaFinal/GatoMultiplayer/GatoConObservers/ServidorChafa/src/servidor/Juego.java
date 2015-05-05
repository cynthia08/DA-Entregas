/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import Conexion.Servicio;

/**
 *
 * @author Cyn
 */
public class Juego {

    private int idJuego;
    private int jugador1;
    private int jugador2;
    private String nombre1;
    private String nombre2;

    private static Juego instancia;

    public static Juego getInstance() {
        if (instancia == null) {
            instancia = new Juego();
        }
        return instancia;
    }

    public Juego() {
        this.idJuego = 0;
        this.jugador1 = 0;
        this.jugador2 = 0;
        this.nombre1 = "";
        this.nombre2 = "";
    }

    public Juego(int jugador1, int jugador2, String nombre1, String nombre2) {
        Servicio s = Servicio.getInstance();
        this.idJuego = s.crearJuego(jugador1, jugador2);
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int jugador1, int jugador2) {
        Servicio s = Servicio.getInstance();
        this.idJuego = s.crearJuego(jugador1, jugador2);

    }

    public int getJugador1() {
        return jugador1;
    }

    public void setJugador1(int jugador1) {
        this.jugador1 = jugador1;
    }

    public int getJugador2() {
        return jugador2;
    }

    public void setJugador2(int jugador2) {
        this.jugador2 = jugador2;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

}
