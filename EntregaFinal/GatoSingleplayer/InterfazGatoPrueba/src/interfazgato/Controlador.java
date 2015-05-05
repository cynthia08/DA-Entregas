package interfazgato;

import Handlers.ManejadorJugadas;
import Prototype.AlmacenTableros;
import Prototype.ValidaAlmacen;

public class Controlador {
    private ValidaAlmacen almacen;
    private ManejadorJugadas jugadas;
    private AlmacenTableros tableros;
    private ScreenGatoController sc;

    public Controlador(ScreenGatoController s) {
        almacen = new ValidaAlmacen();
        jugadas = new ManejadorJugadas();
        tableros = new AlmacenTableros();
        sc = s;
    }
    
    public String turno() {
        return jugadas.getJugadas().getTurno();
    }
    
    private void otroTurno() {
        jugadas.getJugadas().cambiaTurno(jugadas.getJugadas().getTurno());
    }
    
    public boolean posicionValida(String tablero, int casilla) {
        boolean valido = tableros.getTableros().get("" + tablero).getCasillas().getFin();
        
        if(!valido)
            return valido == tableros.getTableros().get("" + tablero).getCasillas().getCasilla().get(casilla).getFin();
        else
            return false;
    }
    
    private void alteraTablero(boolean empate, String tablero, int casilla) {
        if(empate)
            tableros.getTableros().get(tablero).getCasillas().getCasilla().get(casilla).setContenido("");
        else
            tableros.getTableros().get(tablero).getCasillas().getCasilla().get(casilla).setContenido(jugadas.getJugadas().getTurno());
    }
    
    private void alteraTableroGeneral(boolean empate, String tablero) {
        if(empate)
            tableros.getTableroGeneral().getCasillas().getCasilla().get(Integer.parseInt(tablero)).setContenido("");
        else
            tableros.getTableroGeneral().getCasillas().getCasilla().get(Integer.parseInt(tablero)).setContenido(jugadas.getJugadas().getTurno());
    }
    
    private boolean valida(boolean principal, String tablero, int casilla) {
        boolean valido;
        
        if(principal)
            valido = almacen.getValida().procesa(tableros.getTableroGeneral().getCasillas(), Integer.parseInt(tablero));
        else
            valido = almacen.getValida().procesa(tableros.getTableros().get(tablero).getCasillas(), casilla);
        
        if(valido)
            alteraTableroGeneral(false, tablero);
        
        return valido;
    }
    
    private boolean empate(boolean principal, String tablero, int casilla) {
        boolean valido;
        
        if(principal)
            valido = almacen.getEmpate().procesa(tableros.getTableroGeneral().getCasillas(), Integer.parseInt(tablero));
        else
            valido = almacen.getEmpate().procesa(tableros.getTableros().get(tablero).getCasillas(), casilla);
        
        if(valido)
            alteraTableroGeneral(true, tablero);
        
        return valido;
    }
    
    public void juego(String tablero, int casilla) {
        alteraTablero(false, tablero, casilla);
        
        boolean juegoGanado = false;
                    
        if(valida(false, tablero, casilla)) {
            sc.ganaTablero(Integer.parseInt(tablero), false);
            juegoGanado = valida(true, tablero, casilla);
        }

        if(juegoGanado) {
            sc.ganaJuego(false);
            sc.anunciaGanador(false);
        }

        if(empate(false, tablero, casilla)) {
            sc.ganaTablero(Integer.parseInt(tablero), true);
        }

        if(empate(true, tablero, casilla)) {
            sc.ganaJuego(true);
            sc.anunciaGanador(true);
        }

        otroTurno();
    }
}
