/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Figuras.Constantes;

/**
 *
 * @author Cyn
 */
public class AnadeTurno {
    private Handler prevHandler;
    private String fig;
    Constantes c = new Constantes();
    
    public AnadeTurno() {
        
        fig= c.equis;
        //fig = "X";
    }
    
    public void addHandler(Handler hand) {
        if(prevHandler != null) prevHandler.siguiente(hand);
        else prevHandler = hand;
    }
    
    public String getTurno() {
        return prevHandler.procesa(fig);
    }
    
    public void cambiaTurno(String figura) {
        if(figura.equals("X")) fig= c.circulo;//fig = "O";
        else fig=c.equis;//fig = "X";
    }
}
