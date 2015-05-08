/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgato;

import cliente.Clases;
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
        joinGame.setVisible(false);
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
            jugador = new Jugador(Integer.parseInt(caso[1]), caso[2]);
            try {
                Cliente c = Cliente.getInstance();
                c.goServer("OK(" + caso[1] + ")");
            } catch (IOException ex) {
            }
        }
        if (metodo.equals("OK")) {
            Jugador jugador = Jugador.getInstance();
            if (jugador.getId() != 0) {
                try {
                    Cliente c = Cliente.getInstance();
                    c.goServer("OK(" + jugador.getId() + ")");
                } catch (IOException ex) {
                }
            }
        }
        if (metodo.equals("creaJuego")) {
            Juego juego = Juego.getInstance();
            juego = new Juego(Integer.parseInt(caso[0]), Integer.parseInt(caso[1]), Integer.parseInt(caso[2]));
            joinGame.setVisible(true);
        }
        if (metodo.equals("name")) {
            contrincante.setText(caso[1]);
            System.out.println("DISPO, EL NOMBRE DE=" + caso[1]);
        }
    }

}
