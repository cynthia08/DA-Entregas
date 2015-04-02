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
public class ValidaHorizontal implements ValidaHandler {
    private ValidaHandler siguiente;
    
    @Override
    public void siguiente(ValidaHandler sig) {
        siguiente = sig;
    }

    @Override
    public boolean procesa(Casillas c, int pos) {
        int p = pos%3;
        
        if(p==0) {
            if(c.getCasilla().get(pos+1).getContenido().equals(c.getCasilla().get(pos+2).getContenido()))
                return c.getCasilla().get(pos).getContenido().equals(c.getCasilla().get(pos+2).getContenido());
        }
        if(p==1) {
            if(c.getCasilla().get(pos-1).getContenido().equals(c.getCasilla().get(pos+1).getContenido()))
                return c.getCasilla().get(pos).getContenido().equals(c.getCasilla().get(pos+1).getContenido());
        }
        if(p==2) {
            if(c.getCasilla().get(pos-1).getContenido().equals(c.getCasilla().get(pos-2).getContenido()))
                return c.getCasilla().get(pos).getContenido().equals(c.getCasilla().get(pos-2).getContenido());
        }
        return siguiente.procesa(c, pos);
    }
    
}
