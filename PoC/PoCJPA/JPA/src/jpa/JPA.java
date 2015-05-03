/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DavidPuga
 */
public class JPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager entitymanager = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
        Query query = entitymanager.createNamedQuery("Jugador.findAll");
        List<Jugador> list = query.getResultList();
        for(Jugador j:list){
            System.out.println("jugadorID "+j.getJugadorID());
            System.out.println("Nombre "+j.getNombre());
        }
        query = entitymanager.createNamedQuery("Juegos.findByJuegoID");
        query.setParameter("juegoID", 1);
        List<Juegos> games = query.getResultList();
        for(Juegos js:games){
            System.out.println("Player1 "+js.getJugadorUno());
            System.out.println("Player2 "+js.getJugadorDos());
        }
        
    }

}
