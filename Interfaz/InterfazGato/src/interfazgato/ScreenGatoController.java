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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

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
    /*
    @FXML
    ImageView img, img2, img3, img4, img5, img6, img7, img8, img9;
    
    @FXML
    ImageView img10, img11, img12, img13, img14, img15, img16, img17, img18;
    @FXML
    ImageView img19, img20, img21, img22, img23, img24, img25, img26, img27;
    @FXML
    ImageView img28, img29, img30, img31, img32, img33, img34, img35, img36;
    @FXML
    ImageView img37, img38, img39, img40, img41, img42, img43, img44, img45;
    @FXML
    ImageView img46, img47, img48, img49, img50, img51, img52, img53, img54;
    @FXML
    ImageView img55, img56, img57, img58, img59, img60, img61, img62, img63;
    @FXML
    ImageView img64, img65, img66, img67, img68, img69, img70, img71, img72;
    @FXML
    ImageView img73, img74, img75, img76, img77, img78, img79, img80, img81;
    */

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
        nomJugador1.setText("David");
        nomJugador2.setText("El muchaho");
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
