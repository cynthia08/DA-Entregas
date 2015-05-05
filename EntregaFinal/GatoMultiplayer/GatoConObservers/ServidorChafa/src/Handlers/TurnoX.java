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
public class TurnoX implements Handler {
    private Handler siguiente;
     Constantes c = new Constantes();
    
    @Override
    public void siguiente(Handler siguienteHandler) {
        siguiente = siguienteHandler;
    }

    @Override
    public String getFigura() {
        return c.equis;
        //return "X";
    }

    @Override
    public String procesa(String fig) {
        if(fig.equals("X")) return this.getFigura();
        else return siguiente.getFigura();
    }
}
