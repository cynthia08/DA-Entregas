/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Cyn
 */
@Entity
@Table(name = "Juego",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"ID"})})
public class Juego1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "JUGADORUNO")
    private int idJugador1;
    
    @Column(name = "JUGADORDOS" , nullable = true)
    private int idJugador2;
    
    @Column(name = "GANADOR")
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
