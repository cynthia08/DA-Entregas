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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Cyn
 */
public class ScreenGatoController implements Initializable, ControlScreen {

    ScreensController controller;
    Image imagenX= new Image("x.png");
    Image imagenO= new Image("o.png");
    int count=0;
    @FXML
    Label nombreJugador;
    @FXML
    ImageView img, img2, img3;
    @FXML
    Button prueba;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        prueba.setText("  ");
       
        prueba.setLayoutX(73);
        prueba.setLayoutY(78);
        prueba.setMaxHeight(50.0);
        prueba.setMaxWidth(50.0);
        prueba.setStyle("-fx-base: white; -fx-border-color:white;");
        //prueba.setMaxHeight(10);
        //prueba= new Button("este", new ImageView(imagenX));
        /*
        imaP.setImage(imagenX);
        imaP.setLayoutX(150);
        imaP.setLayoutY(150);
                */
    }

    @FXML
    private void goToHome(ActionEvent event) {
        controller.setScreen(InterfazGato.screenHome);

    }

    public void setNombre(String nombre) {
        nombreJugador.setText(nombre);

    }

    @Override
    public void setScreenParent(ScreensController screen) {
        controller = screen;
    }
    
    @FXML
    private void showIma(ActionEvent event) {
        ImageView imaP= new ImageView(imagenX);
        imaP.setFitHeight(23);
        imaP.setFitWidth(17);
        prueba.setGraphic(imaP);

    }

    @FXML
    private void handle(MouseEvent event) {
        img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                count++;
                if(count%2==0){
                    img.setImage(imagenO);
                }else{
                    img.setImage(imagenX);
                }
                //event.consume();
            }
        });
    }
    @FXML
    private void handle2(MouseEvent event) {
        img2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                count++;
                if(count%2==0){
                    img2.setImage(imagenO);
                }else{
                    img2.setImage(imagenX);
                }
                
                //event.consume();
            }
        });
    }
    @FXML
    private void handle3(MouseEvent event) {
        img3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                count++;
                if(count%2==0){
                    img3.setImage(imagenO);
                }else{
                    img3.setImage(imagenX); 
                }               
                //event.consume();
            }
        });
    }

}
