/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

/**
 *
 * @author Cyn
 */
public class ManejadorJugadas {
    private AnadeTurno jugadas;
    
    public ManejadorJugadas() {
        jugadas = new AnadeTurno();
        jugadas.addHandler(new TurnoX());
        jugadas.addHandler(new TurnoY());
    }
    
    public AnadeTurno getJugadas() {
        return jugadas;
    }
}
