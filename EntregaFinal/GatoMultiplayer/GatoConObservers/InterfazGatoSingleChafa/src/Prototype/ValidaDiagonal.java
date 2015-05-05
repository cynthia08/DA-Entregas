/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototype;

/**
 *
 * @author Cyn
 */
public class ValidaDiagonal implements ValidaHandler {
    private ValidaHandler siguiente;
    
    @Override
    public void siguiente(ValidaHandler sig) {
        siguiente = sig;
    }

    @Override
    public boolean procesa(Casillas c, int pos) {
        if(pos == 1 || pos == 3 || pos == 5 || pos == 7) return false;
         
        if(c.getCasilla().get(0).getContenido().equals(c.getCasilla().get(4).getContenido()))
            if(c.getCasilla().get(4).getContenido().equals(c.getCasilla().get(8).getContenido())) return true;

        if(c.getCasilla().get(2).getContenido().equals(c.getCasilla().get(4).getContenido()))
            if(c.getCasilla().get(4).getContenido().equals(c.getCasilla().get(6).getContenido())) return true;

        return false;
    }
    
}
