/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgato;

import Helpers.BuscarHelper;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Cyn
 */
public class ScreenJuegosDispController implements Initializable, ControlScreen {

    ScreensController controller;
    @FXML
    Text contrincante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        BuscarHelper help= new BuscarHelper();
        String nomJugador= help.getJugador();
        contrincante.setText(nomJugador);
                
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
        controller.setScreen(InterfazGato.screenUnirse);

    }

}
