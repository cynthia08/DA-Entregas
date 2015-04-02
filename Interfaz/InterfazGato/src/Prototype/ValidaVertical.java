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
public class ValidaVertical implements ValidaHandler {
    private ValidaHandler siguiente;
    
    @Override
    public void siguiente(ValidaHandler sig) {
        siguiente = sig;
    }

    @Override
    public boolean procesa(Casillas c, int pos) {
        if(pos>=0 && pos<3) {
            if(c.getCasilla().get(pos+3).getContenido().equals(c.getCasilla().get(pos+6).getContenido()))
                return c.getCasilla().get(pos).getContenido().equals(c.getCasilla().get(pos+6).getContenido());
        }
        if(pos>=3 && pos<6) {
            if(c.getCasilla().get(pos-3).getContenido().equals(c.getCasilla().get(pos+3).getContenido()))
                return c.getCasilla().get(pos).getContenido().equals(c.getCasilla().get(pos+3).getContenido());
        }
        if(pos>=6 && pos<9) {
            if(c.getCasilla().get(pos-3).getContenido().equals(c.getCasilla().get(pos-6).getContenido()))
                return c.getCasilla().get(pos).getContenido().equals(c.getCasilla().get(pos-6).getContenido());
        }
        return siguiente.procesa(c, pos);
    }
    
}
