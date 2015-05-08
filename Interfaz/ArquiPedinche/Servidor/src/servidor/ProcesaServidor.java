/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.net.Socket;

/**
 *
 * @author Cyn
 */
public class ProcesaServidor extends Clases {

    public String metodo(String m, Socket c) {
        String[] caso = m.split("(\\()|(\\))|(,)");
        String metodo = caso[0];

        switch (metodo) {
            case "agregaJugador": {
                Jugador jugador1 = Jugador.getInstanceUno();
                String ip = c.getRemoteSocketAddress().toString().split("((/)|(:\\d+))")[1];
                jugador1 = new Jugador(caso[1], "", c.getPort());
                return "agregaJugador(" + jugador1.getJugador() + ")";
            }
            case "buscaJugador": {
                Jugador jugador2 = Jugador.getInstanceDos();
                String ip = c.getRemoteSocketAddress().toString().split("((/)|(:\\d+))")[1];
                jugador2 = new Jugador(caso[1], ip, c.getPort());
                return "buscaJugador(" + jugador2.getJugador() + ")";
            }
            case "getName": {
                Jugador jugador1 = Jugador.getInstanceUno();
                Jugador jugador2 = Jugador.getInstanceDos();
                if (caso[1].equals(Integer.toString(jugador1.getId()))) {
                    return "name(" + jugador1.getNombre() + ")";
                } else {
                    return "name(" + jugador2.getNombre() + ")";
                }
            }
            case "OK": {
                String id = caso[1];
                Jugador jugador1 = Jugador.getInstanceUno();
                Jugador jugador2 = Jugador.getInstanceDos();
                Juego juego = Juego.getInstance();
                if (al.size() == 2 && juego.getIdJuego() == 0) {
                    juego = new Juego(jugador1.getId(), jugador2.getId());
                    turno = Integer.toString(jugador1.getId());
                    return "creaJuego(" + juego.getIdJuego() + "," + jugador1.getId() + "," + jugador2.getId() + ")";
                } else if (al.size() == 2 && juego.getIdJuego() != 0) {
                    return "creaJuego(" + juego.getIdJuego() + "," + jugador1.getId() + "," + jugador2.getId() + ")";
                } else if (al.contains(id)) {
                    return "OK";
                } else {
                    al.add(id);
//                    if (al.size() == 2) {
//                        Juego juego = Juego.getInstance();
//                        Jugador jugador1 = Jugador.getInstanceUno();
//                        Jugador jugador2 = Jugador.getInstanceDos();
//                        //hablale a ambos clientes y mandale 
//                        juego = new Juego(jugador1.getId(), jugador2.getId());
//                        turno = Integer.toString(jugador1.getId());
//                        String msgJuego = "creaJuego(" + juego.getIdJuego() + "," + jugador1.getId() + "," + jugador2.getId() + ")";
//                    }
                    return "OK";
                }
            }
//            case "movimiento":
//                String idPlayer = caso[1];
//                String tablero = caso[2];
//                String casilla = caso[3];
//                movTablero = tablero;
//                movCasilla = casilla;
//                if (idPlayer.equals(Integer.toString(jugador1.getId()))) {
//                    turno = Integer.toString(jugador2.getId());
//                } else {
//                    turno = Integer.toString(jugador1.getId());
//                }
//                return "espera";
//            case "turno":
//                String idTurno = caso[1];
//                if (idTurno.equals(turno)) {
//                    if (turno.equals(Integer.toString(jugador1.getId()))) {
//                        turno = Integer.toString(jugador2.getId());
//                    } else {
//                        turno = Integer.toString(jugador1.getId());
//                    }
//                    if (movTablero.equals("-1") && movCasilla.equals("-1")) {
//                        return "juega()";
//                    } else {
//                        return "juega(" + movTablero + "," + movCasilla + ")";
//                    }
//                } else {
//                    return "espera";
//                }
            default:
                return null;
        }
    }
}
