package Prototype;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Figuras.Numeros;
import Figuras.EmpateFig;
import Figuras.Circulo;
import Figuras.Figuras;
import Figuras.Equis;

/**
 *
 * @author Cyn
 */
public class Casilla {
    private Figuras contenido;
    private boolean fin;

    public Casilla(int posX) {
        contenido = new Numeros(posX);
        fin = false;
    }
    
    public String getContenido() {
        return contenido.dibujar();
    }
    
    public void setContenido(String con) {
        if(con.equals("X")) {
        contenido = new Equis();
        fin = true;
        }
        else if(con.equals("O")) {
            contenido = new Circulo();
            fin = true;
        }
        else if(con.equals("")) {
            contenido = new EmpateFig();
            fin = true;
        }
        else contenido = new Numeros(Integer.parseInt(con));
    }
    
    public boolean getFin() {
        return fin;
    }
}
