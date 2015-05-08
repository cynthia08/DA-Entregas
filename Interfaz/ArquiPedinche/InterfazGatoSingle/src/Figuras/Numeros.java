/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Figuras;

import Figuras.Figuras;

/**
 *
 * @author Cyn
 */
public class Numeros extends Figuras {
    private int digito;
    public Numeros(int num) {
        digito = num;
    }
    
    @Override
    public String dibujar() {
        return ""+digito;
    }
}
