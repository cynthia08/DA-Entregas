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
public class GatoHelper  {
    
    public static void ganador(int idGanador){
        Servicio s = new Servicio();
        s.ganarJuego(LogHelper.getIdJuego(), idGanador);
        System.out.println("nombre jug1: " + idGanador);
    }
}
