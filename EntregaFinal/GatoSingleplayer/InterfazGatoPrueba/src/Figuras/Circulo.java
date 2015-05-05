/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Figuras;

/**
 *
 * @author Cyn
 */
public class Circulo extends Figuras {
    @Override
    public String dibujar() {
        Constantes c = new Constantes();
       return c.circulo;
        //return "O";
    }
    
    public Figuras getInstancia() {
        if(this.instancia==null){
            instancia= new Circulo();
        }
        return instancia;
    }
}
