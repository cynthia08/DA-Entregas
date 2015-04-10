package Prototype;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Estados.*;
import java.util.*;

/**
 *
 * @author Cyn
 */
public class Casillas {
    private ArrayList<Casilla> casillas;
    private boolean fin;
    private Estado ganador;
    
    public Casillas() {
        this.casillas = new ArrayList<Casilla>();
        
        for (int i = 1; i <= 9; i++) {
            casillas.add(new Casilla(i));
        }
        
        fin = false;
    }
        
    public ArrayList<Casilla> getCasilla() {
        return casillas;
    }
    
    public String getGanador() {
        return ganador.getGanador();
    }
    
    public void setGanador(String figura) {
        if(!figura.equals("")) ganador = new Ganador(figura);
        else ganador = new Empate();
        
        for (int i = 0; i < 9; i++) {
                casillas.get(i).setContenido(ganador.getGanador());
            }
        
        fin = true;
    }
    
    public boolean getFin() {
        return fin;
    }
}
