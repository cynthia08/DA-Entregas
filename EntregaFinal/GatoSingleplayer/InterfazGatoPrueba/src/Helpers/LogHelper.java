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
    private static int idJug1;
    private static int idJug2;
    private static int idJuego;

    public static int getIdJuego() {
        return idJuego;
    }

    public static void setIdJuego(int idJuego) {
        LogHelper.idJuego = idJuego;
    }
    

    public static String getJugador1() {
        return jugador1;
    }

    public static String getJugador2() {
        return jugador2;
    }

    public static void setJugador(String nombre1, String nombre2) {
        jugador1 = nombre1;
        jugador2 = nombre2;
        agregaJugador(jugador1, jugador2);
    }

    public static void agregaJugador(String nomJug1, String nomJug2) {
        Servicio s = new Servicio();
        LogHelper.idJug1 = s.nuevoJugador(nomJug1);
        LogHelper.idJug2 = s.nuevoJugador(nomJug2);
        String nom1 = s.getNombre(LogHelper.idJug1);
        String nom2 = s.getNombre(LogHelper.idJug1);
        System.out.println("nombre jug1: " + nom1);
        System.out.println("nombre jug2: " + nom2);   
        int juego= s.crearJuego(LogHelper.idJug1, LogHelper.idJug2);
        LogHelper.idJuego=juego;
        System.out.println("id juego: " + LogHelper.idJuego); 
        
    }

    public static int getIdJug1() {
        return idJug1;
    }

    public static void setIdJug1(int idJug1) {
        LogHelper.idJug1 = idJug1;
    }

    public static int getIdJug2() {
        return idJug2;
    }

    public static void setIdJug2(int idJug2) {
        LogHelper.idJug2 = idJug2;
    }
    
    

}
