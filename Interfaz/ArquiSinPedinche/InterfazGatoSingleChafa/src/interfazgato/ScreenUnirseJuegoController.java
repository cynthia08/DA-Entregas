/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgato;

import cliente.Cliente;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Cyn
 */
public class ScreenUnirseJuegoController implements Initializable, ControlScreen, Observer {

    ScreensController controller;
    @FXML
    TextField nombre;
    @FXML
    Label mensaje;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @Override
    public void setScreenParent(ScreensController screen) {
        controller = screen;
    }

    @FXML
    private void goToJuego(ActionEvent event) throws IOException {
        String nom = nombre.getText();
        if (nom.trim().isEmpty()) {
            mensaje.setText("**Es necesario introducir nombre");
        } else if (nom.length() >= 10) {
            mensaje.setText("**No se puede exceder de 10 caracteres.");
        } else {
            Cliente c = Cliente.getInstance();
            c.goServer("buscaJugador(" + nom + ")");
            controller.setScreen(InterfazGato.screenBuscar);
        }
    }

    @FXML
    private void goToMenu(ActionEvent event) {
        controller.setScreen(InterfazGato.screenHome);
    }

    @Override
    public void update(Observable o, Object arg) {
    }

}
