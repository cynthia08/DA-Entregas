/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import Handlers.ManejadorJugadas;
import Prototype.AlmacenTableros;
import Prototype.ValidaAlmacen;
import java.util.ArrayList;

/**
 *
 * @author Cyn
 */
public class ProcesaServidor {

    private Jugador jugador1;
    private Jugador jugador2;
    private Juego juego;
    public ArrayList<String> al = new ArrayList<String>();
    ValidaAlmacen almacen = new ValidaAlmacen();
    ManejadorJugadas jugadas = new ManejadorJugadas(); //Crea maneja jugadas
    AlmacenTableros tableros = new AlmacenTableros(); //Crea tablero logico

    public String metodo(String m) {

        String[] caso = m.split("(\\()|(\\))|(,)");
        String metodo = caso[0];

        switch (metodo) {
            case "agregaJugador":
                jugador1 = new Jugador(caso[1]);
                return "agregaJugador(" + jugador1.getJugador() + ")";
            case "buscaJugador":
                jugador2 = new Jugador(caso[1]);
                return "agregaJugador(" + jugador2.getJugador() + ")";
            case "getName":
                if (caso[1].equals(jugador1.getId())) {
                    return "name(" + jugador1.getNombre() + ")";
                } else {
                    return "name(" + jugador2.getNombre() + ")";
                }
            case "ok":
                String id = caso[1];
                if (al.size() == 2) {
                    juego = new Juego(jugador1.getId(), jugador2.getId());
                    return "creaJuego(" + juego.getIdJuego() + "," + jugador1.getId() + "," + jugador2.getId() + ")";
                } else if (al.contains(id)) {
                    return "ok";
                } else {
                    al.add(id);
                    return "ok";
                }
            default:
                return null;
        }
    }
}
