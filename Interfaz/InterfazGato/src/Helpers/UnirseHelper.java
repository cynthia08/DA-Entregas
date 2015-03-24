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
public class UnirseHelper {
    private String nomJugador;
    
    public void setJugador(String nombre){
        this.nomJugador=nombre;
        this.agregaJugador(nomJugador);
    }
    
    public void agregaJugador(String nombre){
        //manda a conectar a base de datos y agrega a jugador
    }
    
}
