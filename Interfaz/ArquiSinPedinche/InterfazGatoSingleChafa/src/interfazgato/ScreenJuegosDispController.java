/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgato;

import cliente.Cliente;
import cliente.Juego;
import cliente.Jugador;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Cyn
 */
public class ScreenJuegosDispController implements Initializable, ControlScreen, Observer {

    ScreensController controller;
    @FXML
    Text contrincante;
    @FXML
    Button joinGame;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contrincante.setText("Buscando contrincante ...");
    }

    @Override
    public void setScreenParent(ScreensController screen) {
        controller = screen;
    }

    @FXML
    private void goToHome(ActionEvent event) {
        controller.setScreen(InterfazGato.screenHome);

    }

    @FXML
    private void goToUnirse(ActionEvent event) {
        controller.setScreen(InterfazGato.screenGato);

    }

    @Override
    public void update(Observable o, Object arg) {
        String dato = (String) arg;
        String[] caso = dato.split("(\\()|(\\))|(,)");
        String metodo = caso[0];
        if (metodo.equals("buscaJugador")) {
            Jugador jugador = Jugador.getInstance();
            jugador.setId(Integer.parseInt(caso[1]));
            jugador.setNombre(caso[2]);
            try {
                Cliente c = Cliente.getInstance();
                c.goServer("OK(" + caso[1] + ")");
            } catch (IOException ex) {
            }
        }
        if (metodo.equals("creaJuego")) {
            Juego juego = Juego.getInstance();
            if (juego.getIdJuego() == 0) {
                System.out.println("creaJuego JOINGAME");
                juego.setIdJuego(Integer.parseInt(caso[1]));
                juego.setJugador1(Integer.parseInt(caso[2]));
                juego.setJugador2(Integer.parseInt(caso[3]));
                //joinGame.setVisible(true);
            }
        }
        if (metodo.equals("creaJuegoR")) {
            Juego juego = Juego.getInstance();
            if (juego.getIdJuego() == 0) {
                System.out.println("creaJuego JOINGAME");
                juego.setIdJuego(Integer.parseInt(caso[1]));
                juego.setJugador1(Integer.parseInt(caso[2]));
                juego.setJugador2(Integer.parseInt(caso[3]));
                //startGame.setVisible(true);
                try {
                    Cliente c = Cliente.getInstance();
                    c.goServer("ACK");
                } catch (IOException ex) {
                }
            }
        }
//        if (metodo.equals("creaJuegoResp")) {
//            Juego juego = Juego.getInstance();
//            if (juego.getIdJuego() == 0) {
//                System.out.println("creaJuegoResp JOINGAME");
//                juego.setIdJuego(Integer.parseInt(caso[1]));
//                juego.setJugador1(Integer.parseInt(caso[2]));
//                juego.setJugador2(Integer.parseInt(caso[3]));
//                joinGame.setVisible(true);
//                try {
//                    Cliente c = Cliente.getInstance();
//                    c.ansServer("ACK");
//                } catch (IOException ex) {
//                }
//            }
//        }
    }

}
