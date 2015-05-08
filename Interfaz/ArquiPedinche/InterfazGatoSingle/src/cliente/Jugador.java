/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author Cyn
 */
public class Jugador {

    private String nombre;
    private int id;
    
    private static Jugador instancia;

    public static Jugador getInstance() {
        if (instancia == null) {
            instancia = new Jugador(0, null);
        }
        return instancia;
    }

    public Jugador(int id, String nombre) {
        this.nombre = nombre;
        this.id = id;
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
