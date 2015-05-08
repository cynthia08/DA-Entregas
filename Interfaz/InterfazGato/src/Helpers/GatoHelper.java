/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

/**
 *
 * @author Cyn
 */
public class GatoHelper  {
    private String jugador1;
    private String jugador2;
    
    public void procesaJugadores(){
        //inicia sesion juego y manda a conectar a base de datos
        System.out.println("desde gato: "+this.jugador1);
        jugador1=this.getJugador1();
        jugador2=this.getJugador2();
        
        /*
        jugador1="David";
        jugador2="El muchacho";
                */
    }

    public String getJugador1() {
        return jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }
    
    
    
}
