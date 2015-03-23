/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgato;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Cyn
 */
public class InterfazGato extends Application {
    public static String screenHome="Home";
    public static String screenGato="Gato";
    public static String screenBuscar="Buscar";
    public static String screenInicioJuego="Inicio";
    public static String screenEsperaJuego="Espera";
    public static String screenInstrucciones="Instrucciones";
    public static String screenInstrucciones2="Instrucciones2";
    public static String screenUnirse="Unirse";
    
    public static String fileHome="ScreenHome.fxml";
    public static String fileGato="ScreenGato.fxml";
    public static String fileBuscar="ScreenJuegosDisp.fxml";
    public static String fileInicioJuego="ScreenLog.fxml";
    public static String fileEsperaJuego="ScreenEspera.fxml";
    public static String fileInstrucciones="ScreenInstrucciones.fxml";
    public static String fileInstrucciones2="ScreenInstrucciones2.fxml";
    public static String fileUnirse="ScreenUnirseJuego.fxml";
    
    @Override
    public void start(Stage stage) throws Exception {
        ScreensController container= new ScreensController();
        container.loadScreen(InterfazGato.screenHome, InterfazGato.fileHome);
        container.loadScreen(InterfazGato.screenGato, InterfazGato.fileGato);
        container.loadScreen(InterfazGato.screenBuscar, InterfazGato.fileBuscar);
        container.loadScreen(InterfazGato.screenInicioJuego, InterfazGato.fileInicioJuego);
        container.loadScreen(InterfazGato.screenEsperaJuego, InterfazGato.fileEsperaJuego);
        container.loadScreen(InterfazGato.screenInstrucciones, InterfazGato.fileInstrucciones);
        container.loadScreen(InterfazGato.screenInstrucciones2, InterfazGato.fileInstrucciones2);
        container.loadScreen(InterfazGato.screenUnirse, InterfazGato.fileUnirse);
        
        container.setScreen(InterfazGato.screenHome);
        
        Group root = new Group();
        root.getChildren().addAll(container);
        
        Scene scene = new Scene(root, 634, 605);  
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
