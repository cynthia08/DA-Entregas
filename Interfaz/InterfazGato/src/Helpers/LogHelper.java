/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Conexion.Servicio;

/**
 *
 * @author Cyn
 */
public class LogHelper {

    private static String jugador1;
    private static String jugador2;

    public static String getJugador1() {
        return jugador1;
    }

    public static String getJugador2() {
        return jugador2;
    }

    public static void setJugador(String nombre1, String nombre2) {
        jugador1 = nombre1;
        jugador2 = nombre2;
        //agregaJugador(jugador1, jugador2);
    }

    public static void agregaJugador(String nomJug1, String nomJug2) {
        Servicio s = new Servicio();
        int jug1 = s.nuevoJugador(nomJug1);
        int jug2 = s.nuevoJugador(nomJug2);
        String nom1 = s.getNombre(jug1);
        String nom2 = s.getNombre(jug2);
        System.out.println("nombre jug1: " + nom1);
        System.out.println("nombre jug2: " + nom2);
    }

}
