/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Cyn
 */
public class ProcesaServidor {

    public static ArrayList<String> al = new ArrayList<>();
    public static int turno;

    public String metodo(String m, Socket c) throws IOException {
        String[] caso = m.split("(\\()|(\\))|(,)");
        String metodo = caso[0];
        switch (metodo) {
            case "agregaJugador": {
                Jugador jugador1 = Jugador.getInstanceUno();
                Jugador jugador2 = Jugador.getInstanceDos();
                jugador1.setId(caso[1]);
                jugador1.setSocket(c);
                jugador1.setNombre(caso[1]);
                return "agregaJugador(" + jugador1.getJugador() + ")";
            }
            case "buscaJugador": {
                Jugador jugador1 = Jugador.getInstanceUno();
                Jugador jugador2 = Jugador.getInstanceDos();
                jugador2.setId(caso[1]);
                jugador2.setSocket(c);
                jugador2.setNombre(caso[1]);
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
                if (al.contains(id)) {
                    return "OK";
                } else {
                    al.add(id);
                    if (al.size() == 2) {
                        Jugador jugador1 = Jugador.getInstanceUno();
                        Jugador jugador2 = Jugador.getInstanceDos();
                        Juego juego = Juego.getInstance();
                        juego.setIdJuego(jugador1.getId(), jugador2.getId());
                        juego.setJugador1(jugador1.getId());
                        juego.setJugador2(jugador2.getId());
                        juego.setNombre1(jugador1.getNombre());
                        juego.setNombre2(jugador2.getNombre());
                        turno = jugador1.getId();
                        String msgJuego = "creaJuego(" + juego.getIdJuego() + "," + jugador1.getId() + "," + jugador2.getId() + "," + jugador1.getNombre() + "," + jugador2.getNombre() + ")";
                        if (Integer.parseInt(id) == jugador1.getId()) {
                            Servidor.goCliente(jugador2.getSocket(), msgJuego);
                            return msgJuego;
                        } else {
                            Servidor.goCliente(jugador1.getSocket(), msgJuego);
                            return msgJuego;
                        }
                    }
                    return "OK";
                }
            }
            case "ACK": {
                return "ACK";
            }
            case "movimiento": {
                int jugadorActual = Integer.parseInt(caso[1]);
                String tablero = caso[2];
                int casilla = Integer.parseInt(caso[3]);
                Juego juego = Juego.getInstance();
                UltimateTicTacToe ultimateGatito = UltimateTicTacToe.getInstanceUno();
                Jugador jugador2 = Jugador.getInstanceDos();
                Jugador jugador1 = Jugador.getInstanceUno();
                String msgRespuesta = "espera(" + jugadorActual + ")";
                String figJugAct;
                boolean flag;
                if (jugadorActual == juego.getJugador1()) {
                    figJugAct = "X";
                    flag = true;
                } else {
                    figJugAct = "O";
                    flag = false;
                }
                if (ultimateGatito.turno().equals(figJugAct)) {
                    if (ultimateGatito.posicionValida(tablero, casilla)) {
                        String msgMovimiento = "pintar(" + jugadorActual + "," + tablero + "," + casilla + ")";
                        Servidor.goCliente(jugador1.getSocket(), msgMovimiento);
                        Servidor.goCliente(jugador2.getSocket(), msgMovimiento);
                        ultimateGatito.actualiza(tablero, casilla);
                    }
                }
                return msgRespuesta;
            }
            case "newGame": {
                int jugador = Integer.parseInt(caso[1]);
                Jugador jugador1 = Jugador.getInstanceUno();
                Jugador jugador2 = Jugador.getInstanceDos();
                if (jugador1.getId() == jugador) {
                    Servidor.goCliente(jugador2.getSocket(), "reiniciar");
                } else {
                    Servidor.goCliente(jugador1.getSocket(), "reiniciar");
                }
                return "reiniciar";
            }
            default:
                return null;
        }
    }

}
