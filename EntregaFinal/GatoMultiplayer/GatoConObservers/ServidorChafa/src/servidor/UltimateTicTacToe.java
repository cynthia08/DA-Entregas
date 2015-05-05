/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import Handlers.ManejadorJugadas;
import Prototype.AlmacenTableros;
import Prototype.ValidaAlmacen;
import java.io.IOException;

/**
 *
 * @author DavidPuga
 */
public class UltimateTicTacToe {

    private AlmacenTableros tableros;
    private ValidaAlmacen almacen;
    private ManejadorJugadas jugadas;
    private String turno;

    public UltimateTicTacToe() {
        tableros = new AlmacenTableros();
        almacen = new ValidaAlmacen();
        jugadas = new ManejadorJugadas();
    }

    private static UltimateTicTacToe instancia1;

    public static UltimateTicTacToe getInstanceUno() {
        if (instancia1 == null) {
            instancia1 = new UltimateTicTacToe();
        }
        return instancia1;
    }

    public String turno() {
        return jugadas.getJugadas().getTurno();
    }

    private void otroTurno() {
        jugadas.getJugadas().cambiaTurno(jugadas.getJugadas().getTurno());
    }

    public boolean posicionValida(String tablero, int casilla) {
        boolean valido = tableros.getTableros().get("" + tablero).getCasillas().getFin();

        if (!valido) {
            return valido == tableros.getTableros().get("" + tablero).getCasillas().getCasilla().get(casilla).getFin();
        } else {
            return false;
        }
    }

    private void alteraTablero(boolean empate, String tablero, int casilla) {
        if (empate) {
            tableros.getTableros().get(tablero).getCasillas().getCasilla().get(casilla).setContenido("");
        } else {
            tableros.getTableros().get(tablero).getCasillas().getCasilla().get(casilla).setContenido(jugadas.getJugadas().getTurno());
        }
    }

    private void alteraTableroGeneral(boolean empate, String tablero) {
        if (empate) {
            tableros.getTableroGeneral().getCasillas().getCasilla().get(Integer.parseInt(tablero)).setContenido("");
        } else {
            tableros.getTableroGeneral().getCasillas().getCasilla().get(Integer.parseInt(tablero)).setContenido(jugadas.getJugadas().getTurno());
        }
    }

    private boolean valida(boolean principal, String tablero, int casilla) {
        boolean valido;

        if (principal) {
            valido = almacen.getValida().procesa(tableros.getTableroGeneral().getCasillas(), Integer.parseInt(tablero));
        } else {
            valido = almacen.getValida().procesa(tableros.getTableros().get(tablero).getCasillas(), casilla);
        }

        if (valido) {
            alteraTableroGeneral(false, tablero);
        }

        return valido;
    }

    private boolean empate(boolean principal, String tablero, int casilla) {
        boolean valido;

        if (principal) {
            valido = almacen.getEmpate().procesa(tableros.getTableroGeneral().getCasillas(), Integer.parseInt(tablero));
        } else {
            valido = almacen.getEmpate().procesa(tableros.getTableros().get(tablero).getCasillas(), casilla);
        }

        if (valido) {
            alteraTableroGeneral(true, tablero);
        }

        return valido;
    }

    public void actualiza(String tablero, int casilla) throws IOException {

        alteraTablero(false, tablero, casilla);
        Jugador jugador1 = Jugador.getInstanceUno();
        Jugador jugador2 = Jugador.getInstanceDos();
        boolean juegoGanado = false;

        if (valida(false, tablero, casilla)) {
            juegoGanado = valida(true, tablero, casilla);
            if (turno().equals("X")) {
                String mensaje = "ganarTablerito(" + jugador1.getId() + "," + tablero + ")";
                Servidor.goCliente(jugador1.getSocket(), mensaje);
                Servidor.goCliente(jugador2.getSocket(), mensaje);
            } else {
                String mensaje = "ganarTablerito(" + jugador2.getId() + "," + tablero + ")";
                Servidor.goCliente(jugador1.getSocket(), mensaje);
                Servidor.goCliente(jugador2.getSocket(), mensaje);
            }
        }

        if (juegoGanado) {
            if (turno().equals("X")) {
                Servidor.goCliente(jugador1.getSocket(), "ganarJuego(" + jugador1.getId() + ")");
                Servidor.goCliente(jugador2.getSocket(), "ganarJuego(" + jugador1.getId() + ")");
            } else {
                Servidor.goCliente(jugador1.getSocket(), "ganarJuego(" + jugador2.getId() + ")");
                Servidor.goCliente(jugador2.getSocket(), "ganarJuego(" + jugador2.getId() + ")");
            }
        }

        if (empate(false, tablero, casilla)) {
            Servidor.goCliente(jugador1.getSocket(), "ganarTablerito(0," + tablero + ")");
            Servidor.goCliente(jugador2.getSocket(), "ganarTablerito(0," + tablero + ")");
        }

        if (empate(true, tablero, casilla)) {
            Servidor.goCliente(jugador1.getSocket(), "ganarJuego(0)");
            Servidor.goCliente(jugador2.getSocket(), "ganarJuego(0)");
        }

        otroTurno();

    }

    public AlmacenTableros getTableros() {
        return tableros;
    }

    public void setTableros(AlmacenTableros tableros) {
        this.tableros = tableros;
    }

    public ValidaAlmacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(ValidaAlmacen almacen) {
        this.almacen = almacen;
    }

    public ManejadorJugadas getJugadas() {
        return jugadas;
    }

    public void setJugadas(ManejadorJugadas jugadas) {
        this.jugadas = jugadas;
    }

    public String getTurno() {
        return turno = jugadas.getJugadas().getTurno();
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

}
