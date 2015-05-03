/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.util.ArrayList;

/**
 *
 * @author Cyn
 */
public class JDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Servicios s = new Servicios();

        String nombre = s.getNombre(2);
        System.out.println("nombre: " + nombre);

        int david = s.nuevoJugador("David");
        System.out.println("david: " + david);
        int muchacho = s.nuevoJugador("Muchacho");
        System.out.println("muchacho: " + muchacho);
        ArrayList<Integer> al = s.buscarJuego();
        System.out.println("buscarJuego1: " + al.toString());
        int cyn = s.insertarJugador(al.get(0), "Cyn");
        System.out.println("cyn: " + cyn);
        ArrayList<Integer> al2 = s.buscarJuego();
        System.out.println("buscarJuego2: " + al2.toString());
        String nombre2 = s.getNombre(al.get(0));
        System.out.println("nombre: " + nombre2);
        s.ganarJuego(al.get(0), cyn);
    }
}
