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
    private String ip;
    private int puerto;

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
        this.ip = null;
        this.puerto = 0;
    }

    public Jugador(String nombre, String ip, int puerto) {
        Servicio s = Servicio.getInstance();
        this.id = s.nuevoJugador(nombre);
        this.nombre = nombre;
        this.ip = ip;
        this.puerto = puerto;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

}
