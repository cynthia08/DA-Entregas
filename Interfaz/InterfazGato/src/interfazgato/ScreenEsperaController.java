/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgato;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Cyn
 */
public class ScreenEsperaController implements Initializable, ControlScreen {
    ScreensController controller;

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
        controller.setScreen(InterfazGato.screenGato);

    }
    
}
