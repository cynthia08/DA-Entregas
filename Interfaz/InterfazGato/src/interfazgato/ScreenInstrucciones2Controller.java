/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgato;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Cyn
 */
public class ScreenInstrucciones2Controller implements Initializable, ControlScreen {
    ScreensController controller;
    @FXML
    ImageView imaPrev;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @Override
    public void setScreenParent(ScreensController screen) {
        controller= screen;
        
    }
    
    @FXML
    private void goToHome(ActionEvent event) {
        controller.setScreen(InterfazGato.screenHome);   
    }  
    
    @FXML
    private void handle(MouseEvent event) {
        imaPrev.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                controller.setScreen(InterfazGato.screenInstrucciones);
                //event.consume();
            }
        });
    }
    
}
