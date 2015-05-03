/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybatis;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.*;
import entidades.Juego;
import entidades.Jugador;
import java.io.*;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Cyn
 */
public class MyBatis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        Reader rd = Resources.getResourceAsReader("myBatis/SQLconfig.xml");
        SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

        Jugador jugador = new Jugador();
        jugador.setNombre("muchacho");
        smc.insert("insertJugador", jugador);
        System.out.println("Se agrego jugador");

        Jugador jg = (Jugador) smc.queryForObject("getJugador", 1);
        System.out.println("Nombre jugador id 1: "+jg.getNombre());

        System.out.println("");
        
        Juego juego = new Juego();
        juego.setIdJugador1(1);
        juego.setIdJugador2(2);
        juego.setGanador(2);

        smc.insert("insertJuego", juego);
        System.out.println("Se agrego juego");
        
        Juego gp = (Juego) smc.queryForObject("getJuego", 1);
        System.out.println("Juego de id 1:");
        System.out.println(" Jugador 1: "+gp.getIdJugador1());
        System.out.println(" Jugador 2: "+gp.getIdJugador2());
        System.out.println(" Ganador: "+gp.getGanador() +"\n");

        List<Jugador> players = (List<Jugador>) smc.queryForList("getAllP", null);
        Jugador ju = null;
        
        System.out.println("select de todos los jugadores");
        
        for (Jugador p : players) {
            System.out.print("id: " + p.getId() + " ");
            System.out.print("nombre: " + p.getNombre());
            ju = p;
            System.out.println("");
        }
        System.out.println("");
        System.out.println("select de todos los juegos");
        List<Juego> games = (List<Juego>) smc.queryForList("getAllG", null);
        Juego ga = null;

        for (Juego p : games) {
            System.out.print("id: " + p.getId() + " ");
            System.out.print("idJug1: " + p.getIdJugador1() + " ");
            System.out.print("idJug2: " + p.getIdJugador2() + " ");
            ga = p;
            System.out.println("");
        }

    }

}
