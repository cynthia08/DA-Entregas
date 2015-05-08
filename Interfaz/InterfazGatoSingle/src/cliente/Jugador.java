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
    
    private static String nombre;
    private static int id;

    public Jugador(int id, String nombre) {
        Jugador.nombre=nombre;
        Jugador.id=id;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Jugador.nombre = nombre;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Jugador.id = id;
    }
    
    public static String getJugador(){
        return getId()+","+getNombre();
    }
    
}
