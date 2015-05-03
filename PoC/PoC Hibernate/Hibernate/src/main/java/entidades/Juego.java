/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Cyn
 */
public class Juego {
    private int id;
    private int idJugador1;
    private int idJugador2;
    private int ganador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdJugador1() {
        return idJugador1;
    }

    public void setIdJugador1(int idJugador1) {
        this.idJugador1 = idJugador1;
    }

    public int getIdJugador2() {
        return idJugador2;
    }

    public void setIdJugador2(int idJugador2) {
        this.idJugador2 = idJugador2;
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }
    
    
}
