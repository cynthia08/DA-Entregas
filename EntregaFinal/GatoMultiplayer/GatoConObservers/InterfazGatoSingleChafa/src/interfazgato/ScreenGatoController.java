/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgato;

import cliente.Cliente;
import cliente.Juego;
import cliente.Jugador;
import java.awt.Font;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Cyn
 */
public class ScreenGatoController implements Initializable, ControlScreen, Observer {

    ScreensController controller;
    static Image pinta1;
    static Image pinta2;
    Image imagenX = new Image("x.png");
    Image imagenO = new Image("o.png");
    Image imagenE = new Image("e.png");
    static String pictureMe, pictureOther, ganadorNombre = "";
    static String nombreJugadorOne = "", nombreJugadorTwo = "";

    @FXML
    Button jugarButton;
    @FXML
    Pane saludo;
    @FXML
    Text labelGanador;
    @FXML
    Text nomJugador1;
    @FXML
    Text nomJugador2;

    @FXML
    ImageView ima00, ima01, ima02, ima03, ima04, ima05, ima06, ima07, ima08,
            ima10, ima11, ima12, ima13, ima14, ima15, ima16, ima17, ima18,
            ima20, ima21, ima22, ima23, ima24, ima25, ima26, ima27, ima28,
            ima30, ima31, ima32, ima33, ima34, ima35, ima36, ima37, ima38,
            ima40, ima41, ima42, ima43, ima44, ima45, ima46, ima47, ima48,
            ima50, ima51, ima52, ima53, ima54, ima55, ima56, ima57, ima58,
            ima60, ima61, ima62, ima63, ima64, ima65, ima66, ima67, ima68,
            ima70, ima71, ima72, ima73, ima74, ima75, ima76, ima77, ima78,
            ima80, ima81, ima82, ima83, ima84, ima85, ima86, ima87, ima88;
    static List<List<ImageView>> contenedor = new ArrayList<List<ImageView>>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<ImageView> cero = new ArrayList<ImageView>() {
            {
                add(ima00);
                add(ima01);
                add(ima02);
                add(ima03);
                add(ima04);
                add(ima05);
                add(ima06);
                add(ima07);
                add(ima08);
            }
        };
        List<ImageView> uno = new ArrayList<ImageView>() {
            {
                add(ima10);
                add(ima11);
                add(ima12);
                add(ima13);
                add(ima14);
                add(ima15);
                add(ima16);
                add(ima17);
                add(ima18);
            }
        };
        List<ImageView> dos = new ArrayList<ImageView>() {
            {
                add(ima20);
                add(ima21);
                add(ima22);
                add(ima23);
                add(ima24);
                add(ima25);
                add(ima26);
                add(ima27);
                add(ima28);
            }
        };
        List<ImageView> tres = new ArrayList<ImageView>() {
            {
                add(ima30);
                add(ima31);
                add(ima32);
                add(ima33);
                add(ima34);
                add(ima35);
                add(ima36);
                add(ima37);
                add(ima38);
            }
        };
        List<ImageView> cuatro = new ArrayList<ImageView>() {
            {
                add(ima40);
                add(ima41);
                add(ima42);
                add(ima43);
                add(ima44);
                add(ima45);
                add(ima46);
                add(ima47);
                add(ima48);
            }
        };
        List<ImageView> cinco = new ArrayList<ImageView>() {
            {
                add(ima50);
                add(ima51);
                add(ima52);
                add(ima53);
                add(ima54);
                add(ima55);
                add(ima56);
                add(ima57);
                add(ima58);
            }
        };
        List<ImageView> seis = new ArrayList<ImageView>() {
            {
                add(ima60);
                add(ima61);
                add(ima62);
                add(ima63);
                add(ima64);
                add(ima65);
                add(ima66);
                add(ima67);
                add(ima68);
            }
        };
        List<ImageView> siete = new ArrayList<ImageView>() {
            {
                add(ima70);
                add(ima71);
                add(ima72);
                add(ima73);
                add(ima74);
                add(ima75);
                add(ima76);
                add(ima77);
                add(ima78);
            }
        };
        List<ImageView> ocho = new ArrayList<ImageView>() {
            {
                add(ima80);
                add(ima81);
                add(ima82);
                add(ima83);
                add(ima84);
                add(ima85);
                add(ima86);
                add(ima87);
                add(ima88);
            }
        };
        contenedor.add(cero);
        contenedor.add(uno);
        contenedor.add(dos);
        contenedor.add(tres);
        contenedor.add(cuatro);
        contenedor.add(cinco);
        contenedor.add(seis);
        contenedor.add(siete);
        contenedor.add(ocho);
    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void volverJuego(ActionEvent event) throws IOException {
        Jugador jugador = Jugador.getInstance();
        Cliente c = Cliente.getInstance();
        c.goServer("newGame(" + jugador.getId() + ")");
        controller.setScreen(InterfazGato.screenInicioJuego);
        saludo.setVisible(true);
        jugarButton.setDisable(false);

    }

    @FXML
    private void empiezaJuego(ActionEvent event) throws IOException {
        Juego juego = Juego.getInstance();
        Jugador jugador = Jugador.getInstance();
        if (jugador.getId() == juego.getJugador1()) {
            nomJugador1.setFont(javafx.scene.text.Font.font(null, FontWeight.BOLD, 18));
            nomJugador1.setText(juego.getNombre1());
            nomJugador2.setText(juego.getNombre2());
        } else {
            nomJugador2.setFont(javafx.scene.text.Font.font(null, FontWeight.BOLD, 18));
            nomJugador1.setText(juego.getNombre1());
            nomJugador2.setText(juego.getNombre2());
        }

        saludo.setVisible(false);
        jugarButton.setDisable(true);

        if (jugador.getId() == juego.getJugador1()) {
            pictureMe = "X";
            pictureOther = "O";
            pinta1 = imagenX;
            pinta2 = imagenO;
        } else {
            pictureMe = "O";
            pictureOther = "X";
            pinta1 = imagenO;
            pinta2 = imagenX;
        }
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
                Jugador jugador = Jugador.getInstance();
                String tablero = img.getId().charAt(3) + "";
                int casilla = Integer.parseInt(img.getId().charAt(4) + "");
                try {
                    Cliente c = Cliente.getInstance();
                    c.goServer("movimiento(" + jugador.getId() + "," + tablero + "," + casilla + ")");
                } catch (IOException ex) {
                }
            }
        });
    }

    public void ganaTablero(int id, String fig) {
        Image imagen;
        if (fig.equals("E")) {
            imagen = imagenE;
        } else if (fig.equals("X")) {
            imagen = imagenX;
        } else {
            imagen = imagenO;
        }
        for (int i = 0; i < 9; i++) {
            contenedor.get(id).get(i).setImage(imagen);
        }
    }

    public void ganaJuego(String fig) {
        for (int i = 0; i < 9; i++) {
            ganaTablero(i, fig);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        String dato = (String) arg;
        String[] caso = dato.split("(\\()|(\\))|(,)");
        String metodo = caso[0];
        if (metodo.equals("espera")) {
            Jugador jugador = Jugador.getInstance();
            if (jugador.getId() == Integer.parseInt(caso[1])) {
                System.out.println("BARRITA GRIS");
            } else {
                System.out.println("FUERA BARRITA GRIS");
            }
        }
        if (metodo.equals("pintar")) {
            Jugador jugador = Jugador.getInstance();
            if (jugador.getId() == Integer.parseInt(caso[1])) {
                contenedor.get(Integer.parseInt(caso[2])).get(Integer.parseInt(caso[3])).setImage(pinta1);
            } else {
                contenedor.get(Integer.parseInt(caso[2])).get(Integer.parseInt(caso[3])).setImage(pinta2);
            }
        }
        if (metodo.equals("ganarTablerito")) {
            Jugador jugador = Jugador.getInstance();
            if (caso[1].equals("0")) {
                ganaTablero(Integer.parseInt(caso[2]), "E");
            } else if (jugador.getId() == Integer.parseInt(caso[1])) {
                ganaTablero(Integer.parseInt(caso[2]), pictureMe);
            } else {
                ganaTablero(Integer.parseInt(caso[2]), pictureOther);
            }
        }
        if (metodo.equals("ganarJuego")) {
            Jugador jugador = Jugador.getInstance();
            if (caso[1].equals("0")) {
                ganaJuego("E");
                labelGanador.setText("EMPATE");
            } else if (jugador.getId() == Integer.parseInt(caso[1])) {
                ganadorNombre = nombreJugadorOne;
                ganaJuego(pictureMe);
                labelGanador.setText("Ganador " + ganadorNombre);
            } else {
                ganadorNombre = nombreJugadorTwo;
                ganaJuego(pictureOther);
                labelGanador.setText("Ganador " + ganadorNombre);
            }
        }
        if (metodo.equals("reiniciar")) {
            controller.setScreen(InterfazGato.screenInicioJuego);
        }
    }

}
