/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import Conexion.Servicio;

/**
 *
 * @author Cyn
 */
public class Jugador {

    private String nombre;
    private int id;

    public Jugador(String nombre) {
        Servicio s = new Servicio();
        this.nombre = nombre;
        this.id = s.nuevoJugador(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJugador() {
        return getId() + "," + getNombre();
    }

}
