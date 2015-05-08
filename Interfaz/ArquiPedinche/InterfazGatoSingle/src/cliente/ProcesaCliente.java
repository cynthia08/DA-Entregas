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
public class ProcesaCliente extends Clases {

    public String metodo(String m) {
        String[] caso = m.split("(\\()|(\\))|(,)");
        String metodo = caso[0];
        
       
        switch (metodo) {
//            case "agregaJugador":
//                Jugador jugador = Jugador.getInstance();
//                jugador = new Jugador(Integer.parseInt(caso[1]), caso[2]);
//                return "ok," + caso[1];
//            case "name":
//                return caso[1];
            case "creaJuego":
                Juego juego = Juego.getInstance();
                juego = new Juego(Integer.parseInt(caso[1]), Integer.parseInt(caso[2]), Integer.parseInt(caso[3]));
                return caso[1];
            case "ok":
                return "0";
            case "espera":
                return "0";
            case "juega":
                if (caso.length < 2) {
                    return "1";
                } else {
                    movTablero = caso[1];
                    movCasilla = caso[2];
                    return "2";
                }
            default:
                return null;
        }
    }
}
