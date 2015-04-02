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
public class ValidaAlmacen {
    private ValidaHorizontal vh;
    private ValidaVertical vv;
    private ValidaDiagonal vd;
    private ValidaEmpate ve;
    
    public ValidaAlmacen() {
        vh = new ValidaHorizontal();
        vv = new ValidaVertical();
        vd = new ValidaDiagonal();
        ve = new ValidaEmpate();
        vh.siguiente(vv);
        vv.siguiente(vd);
    }
    
    public ValidaHandler getValida() {
        return vh;
    }
    
    public ValidaHandler getEmpate() {
        return ve;
    }
}
