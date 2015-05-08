/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgato;

import Helpers.LogHelper;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Cyn
 */
public class ScreenLogController implements Initializable, ControlScreen {

    ScreensController controller;
    @FXML
    TextField nombre1, nombre2;
    @FXML
    Label mensaje, mensaje2;
    //LogHelper help = new LogHelper();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @Override
    public void setScreenParent(ScreensController screen) {
        controller = screen;
        
    }

    @FXML
    private void goToEspera(ActionEvent event) {
        String nom1 = nombre1.getText();
        String nom2 = nombre2.getText();

        if (nom1.trim().isEmpty() || nom2.trim().isEmpty()) {
            mensaje.setText("**Falta introducir datos.");
        }else if (nom1.length()>=10 || nom2.length()>=10) {
            mensaje.setText("**No se puede exceder de 10 caracteres.");
        }else if (nom1.trim().equals(nom2.trim())) {
            mensaje.setText("**No pueden llamarse de la misma forma.");
        }else {
            LogHelper.setJugador(nom1, nom2);
            System.out.println(nom1 + " " + nom2);
            controller.setScreen(InterfazGato.screenGato);
        }
    }

    @FXML
    private void goToMenu(ActionEvent event) {
        controller.setScreen(InterfazGato.screenHome);
    }

}
