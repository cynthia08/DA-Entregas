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
public class ValidaEmpate implements ValidaHandler {
    @Override
    public void siguiente(ValidaHandler sig) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean procesa(Casillas c, int pos) {
        for (int i = 0; i < 9; i++) {
            if(c.getCasilla().get(i).getContenido().matches("[1-9]")) {
                return false;
            }
        }
        return true;
    }
}
