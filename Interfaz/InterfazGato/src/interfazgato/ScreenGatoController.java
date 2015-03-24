/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgato;

import Helpers.GatoHelper;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Cyn
 */
public class ScreenGatoController implements Initializable, ControlScreen {

    ScreensController controller;
    Image imagenX = new Image("x.png");
    Image imagenO = new Image("o.png");
    int count = 0;
    
    @FXML
    Text nomJugador1;
    @FXML
    Text nomJugador2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        GatoHelper help= new GatoHelper();
        help.procesaJugadores();
       
        nomJugador1.setText(help.getJugador1());
        nomJugador2.setText(help.getJugador2());
        
                
    }

    @FXML
    private void goToHome(ActionEvent event) {
        controller.setScreen(InterfazGato.screenHome);

    }

    @Override
    public void setScreenParent(ScreensController screen) {
        controller = screen;
       
    }

    @FXML
    private void handle(MouseEvent event) {
        ImageView img = (ImageView) event.getSource();
        img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                count++;
                if (count % 2 == 0) {
                    img.setImage(imagenO);
                    nomJugador2.setFont(Font.font(null, FontWeight.NORMAL, 18));
                    nomJugador1.setFont(Font.font(null, FontWeight.BOLD, 18));
                } else {
                    img.setImage(imagenX);
                    nomJugador2.setFont(Font.font(null, FontWeight.BOLD, 18));
                    nomJugador1.setFont(Font.font(null, FontWeight.NORMAL, 18));
                }
                //event.consume();
            }
        });
    }

}
