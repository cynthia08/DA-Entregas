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
public class Procesa {
    
    public Jugador jugador1;

    public String metodo(String m){
        String[] caso=m.split("(\\()|(\\))|(,)");
        String metodo=caso[0];
        
        switch(metodo){
            case "agregaJugador":
                jugador1= new Jugador(caso[1], Integer.parseInt(caso[2]));
                return "ok"; 
            default:
                return null;
        }   
    }    
}
