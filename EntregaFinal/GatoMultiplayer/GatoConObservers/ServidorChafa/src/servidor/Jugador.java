/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import Conexion.Servicio;
import java.net.Socket;

/**
 *
 * @author Cyn
 */
public class Jugador {

    private String nombre;
    private int id;
    private Socket socket;

    private static Jugador instancia1;
    private static Jugador instancia2;

    public static Jugador getInstanceUno() {
        if (instancia1 == null) {
            instancia1 = new Jugador();
        }
        return instancia1;
    }

    public static Jugador getInstanceDos() {
        if (instancia2 == null) {
            instancia2 = new Jugador();
        }
        return instancia2;
    }

    public Jugador() {
        this.id = 0;
        this.nombre = null;
        this.socket = null;
    }

    public Jugador(String nombre, Socket socket) {
        Servicio s = Servicio.getInstance();
        this.id = s.nuevoJugador(nombre);
        this.nombre = nombre;
        this.socket = socket;
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

    public void setId(String nombre) {
        Servicio s = Servicio.getInstance();
        this.id = s.nuevoJugador(nombre);
    }

    public String getJugador() {
        return getId() + "," + getNombre();
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

}
