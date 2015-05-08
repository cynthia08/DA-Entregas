/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Cyn
 */
public class ProcesaServidor extends Clases {

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
                        turno = Integer.toString(jugador1.getId());
                        String msgJuego = "creaJuego(" + juego.getIdJuego() + "," + jugador1.getId() + "," + jugador2.getId() + ")";
                        String msgRJuego = "creaJuegoR(" + juego.getIdJuego() + "," + jugador1.getId() + "," + jugador2.getId() + ")";
                        if (Integer.parseInt(id) == jugador1.getId()) {
                            Servidor.goCliente(jugador2.getSocket(), msgRJuego);
//                            Thread.sleep(10);
                            return msgJuego;
                        } else {
                            Servidor.goCliente(jugador1.getSocket(), msgRJuego);
                            return msgJuego;
                        }
                    }
                    return "OK";
                }
            }
            case "ACK":{
                return "ACK";
            }
                
            /*
             if (al.size() == 2 && juego.getIdJuego() == 0) {
             juego = new Juego(jugador1.getId(), jugador2.getId());
             turno = Integer.toString(jugador1.getId());
             return "creaJuego(" + juego.getIdJuego() + "," + jugador1.getId() + "," + jugador2.getId() + ")";
             } else if (al.size() == 2 && juego.getIdJuego() != 0) {
             return "creaJuego(" + juego.getIdJuego() + "," + jugador1.getId() + "," + jugador2.getId() + ")";
             } else 
             */
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

    public void analiza(String m, Socket c) throws IOException {
        String[] caso = m.split("(\\()|(\\))|(,)");
        String metodo = caso[0];

        switch (metodo) {
            case "agregaJugador": {
                Jugador jugador1 = Jugador.getInstanceUno();
//                String ip = c.getRemoteSocketAddress().toString().split("((/)|(:\\d+))")[1];
//                jugador1 = new Jugador(caso[1], "", c.getPort());
                jugador1 = new Jugador(caso[1], c);
                String msg = "agregaJugador(" + jugador1.getJugador() + ")";
                break;
            }
            case "buscaJugador": {
                Jugador jugador2 = Jugador.getInstanceDos();
//                String ip = c.getRemoteSocketAddress().toString().split("((/)|(:\\d+))")[1];
//                jugador2 = new Jugador(caso[1], ip, c.getPort());
                jugador2 = new Jugador(caso[1], c);
                String msg = "buscaJugador(" + jugador2.getJugador() + ")";
                break;
            }
            case "getName": {
                Jugador jugador1 = Jugador.getInstanceUno();
                Jugador jugador2 = Jugador.getInstanceDos();
                String msg;
                if (caso[1].equals(Integer.toString(jugador1.getId()))) {
                    msg = "name(" + jugador1.getNombre() + ")";
                } else {
                    msg = "name(" + jugador2.getNombre() + ")";
                }
                break;
            }
            case "OK": {
                System.out.println("ENTRO A OK SERVER = " + m);
                String id = caso[1];
                String msg;
                if (al.contains(id)) {
                    msg = "OK";
                } else {
                    al.add(id);
                    if (al.size() == 2) {
                        Juego juego = Juego.getInstance();
                        Jugador jugador1 = Jugador.getInstanceUno();
                        Jugador jugador2 = Jugador.getInstanceDos();
                        //hablale a ambos clientes y mandale 
                        juego = new Juego(jugador1.getId(), jugador2.getId());
                        turno = Integer.toString(jugador1.getId());
                        String msgJuego = "creaJuego(" + juego.getIdJuego() + "," + jugador1.getId() + "," + jugador2.getId() + ")";
                        Servidor.goCliente(jugador1.getSocket(), msgJuego);
                        Servidor.goCliente(jugador2.getSocket(), msgJuego);
                    }
                    msg = "OK";
                }
                break;
            }
            default:
                break;
        }
    }

}
