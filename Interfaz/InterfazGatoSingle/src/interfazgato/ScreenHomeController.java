/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgato;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Cyn
 */
public class ScreenHomeController implements Initializable, ControlScreen {
    ScreensController controller;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }  
    
    @Override
    public void setScreenParent(ScreensController screen) {
        controller= screen;
        
    }
    
    @FXML
    private void goToInicio(ActionEvent event) {
        controller.setScreen(InterfazGato.screenInicioJuego);
        
        
    }    
    @FXML
    private void goToBuscar(ActionEvent event) {
        controller.setScreen(InterfazGato.screenUnirse); 
    } 
    
    @FXML
    private void goToInstruccions(ActionEvent event) {
        controller.setScreen(InterfazGato.screenInstrucciones); 
    } 
    
}
