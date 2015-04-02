/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgato;

import Helpers.EsperaHelper;
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
public class ScreenEsperaController implements Initializable, ControlScreen {
    ScreensController controller;
    @FXML
    Text nomContrincante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        EsperaHelper help= new EsperaHelper();
        String contrincante=help.getJugadorNom();
        nomContrincante.setText(contrincante);
        
        
        
    }  
    @Override
    public void setScreenParent(ScreensController screen) {
        controller = screen;

    }

    @FXML
    private void goToEspera(ActionEvent event) {
        controller.setScreen(InterfazGato.screenGato);
    }
    @FXML
    private void goToMenu(ActionEvent event) {
        controller.setScreen(InterfazGato.screenHome);
    }
}
