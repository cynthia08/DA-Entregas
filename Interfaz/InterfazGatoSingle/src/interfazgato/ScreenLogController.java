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
    TextField nombre;
    @FXML
    Label mensaje;
   

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
        String nom = nombre.getText();

        if (nom.trim().isEmpty()) {
            mensaje.setText("**Es necesario introducir nombre");

        } else if (nom.length()>=10){
            mensaje.setText("**No se puede exceder de 10 caracteres.");
        }else {
            LogHelper.setJugador1(nom);
            controller.setScreen(InterfazGato.screenEsperaJuego);
        }
    }
     @FXML
    private void goToMenu(ActionEvent event) {
        controller.setScreen(InterfazGato.screenHome);
    }
    
}
