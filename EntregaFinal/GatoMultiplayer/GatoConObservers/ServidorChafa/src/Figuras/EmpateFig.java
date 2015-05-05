/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Figuras;

public class EmpateFig extends Figuras {
    @Override
    public String dibujar() {
        return " ";
    }
    
    public Figuras getInstancia() {
        if(this.instancia==null){
            instancia= new EmpateFig();
        }
        return instancia;
    }
}