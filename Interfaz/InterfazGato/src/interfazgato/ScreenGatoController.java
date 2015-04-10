/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgato;

import Handlers.ManejadorJugadas;
import Helpers.GatoHelper;
import Prototype.AlmacenTableros;
import Prototype.ValidaAlmacen;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    Image imagenE = new Image("e.png");

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
    List<List<ImageView>> contenedor;

    ValidaAlmacen almacen = new ValidaAlmacen();
    ManejadorJugadas jugadas = new ManejadorJugadas(); //Crea maneja jugadas
    AlmacenTableros tableros = new AlmacenTableros(); //Crea tablero logico
    //tableros.getTableros().get(""+tablero).getCasillas().getCasilla().get(casilla).setContenido(jugadas.getJugadas().getTurno());
    //Arriba ubica tablero y casilla logica
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
        GatoHelper help = new GatoHelper();
        help.procesaJugadores();

        nomJugador1.setText(help.getJugador1());
        nomJugador2.setText(help.getJugador2());

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

        contenedor = new ArrayList<List<ImageView>>() {
            {
                add(cero);
                add(uno);
                add(dos);
                add(tres);
                add(cuatro);
                add(cinco);
                add(seis);
                add(siete);
                add(ocho);
            }
        };
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

        String turno = jugadas.getJugadas().getTurno(); //Consigue el dibujo de letra actual
        String tablero = img.getId().charAt(3) + "";
        int casilla = Integer.parseInt(img.getId().charAt(4) + "");

        img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (tableros.getTableros().get("" + tablero).getCasillas().getFin() == false) {
                    if (tableros.getTableros().get("" + tablero).getCasillas().getCasilla().get(casilla).getFin() == false) {

                        if (turno.equals("O")) {
                            img.setImage(imagenO);

                            nomJugador2.setFont(Font.font(null, FontWeight.NORMAL, 18));
                            nomJugador1.setFont(Font.font(null, FontWeight.BOLD, 18));
                        } else {
                            img.setImage(imagenX);
                            nomJugador2.setFont(Font.font(null, FontWeight.BOLD, 18));
                            nomJugador1.setFont(Font.font(null, FontWeight.NORMAL, 18));
                        }

                        tableros.getTableros().get(tablero).getCasillas().getCasilla().get(casilla).setContenido(jugadas.getJugadas().getTurno());

                        boolean tabGanado = almacen.getValida().procesa(tableros.getTableros().get(tablero).getCasillas(), casilla);
                        boolean juegoGanado = false;

                        if (tabGanado) {
                            ganaTablero(Integer.parseInt(tablero), false);
                            tableros.getTableroGeneral().getCasillas().getCasilla().get(Integer.parseInt(tablero)).setContenido(jugadas.getJugadas().getTurno());
                            juegoGanado = almacen.getValida().procesa(tableros.getTableroGeneral().getCasillas(), Integer.parseInt(tablero));
                        }

                        if (juegoGanado) {
                            ganaJuego(false);
                        }

                        boolean tabEmpatado = almacen.getEmpate().procesa(tableros.getTableros().get(tablero).getCasillas(), casilla);
                        boolean juegoEmpatado = false;

                        if (tabEmpatado) {
                            ganaTablero(Integer.parseInt(tablero), true);
                            tableros.getTableroGeneral().getCasillas().getCasilla().get(Integer.parseInt(tablero)).setContenido("");
                            juegoEmpatado = almacen.getEmpate().procesa(tableros.getTableroGeneral().getCasillas(), Integer.parseInt(tablero));
                        }

                        if (juegoEmpatado) {
                            ganaJuego(true);
                        }

                        jugadas.getJugadas().cambiaTurno(jugadas.getJugadas().getTurno()); //Cambia turno
                    }
                }
            }
        });
    }

    public void ganaTablero(int id, boolean empate) {
        Image imagen;

        if (empate) {
            imagen = imagenE;
        } else {
            if (jugadas.getJugadas().getTurno().equals("X"))
                imagen = imagenX;
            else
                imagen = imagenO;
        }

        for (int i = 0; i < 9; i++) {
            contenedor.get(id).get(i).setImage(imagen);
        }
    }

    public void ganaJuego(boolean empate) {
        Image imagen;
        
        if(empate) {
            imagen = imagenE;
        } else {
            if (jugadas.getJugadas().getTurno().equals("X"))
                imagen = imagenX;
            else
                imagen = imagenO;
        }

        for (int i = 0; i < 9; i++) {
            ganaTablero(i, empate);
        }
    }
}
