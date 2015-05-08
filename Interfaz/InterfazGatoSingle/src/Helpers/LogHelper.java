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

    public static void setJugador1(String nombre) {
        jugador1 = nombre;
        //agregaJugador(jugador1);
    }
    
    public static void setJugador2(String nombre) {
        jugador2 = nombre;
        //agregaJugador(jugador2);
    }
    
    public static void agregaJugador(String nombre){
        Servicio s = new Servicio();
        int jug = s.nuevoJugador(nombre);
        String nom = s.getNombre(jug);
        System.out.println("nombre jug: " + nom);
    }
    
    
}
