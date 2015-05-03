package main;

import entidades.Juego;
import java.util.Date;

import org.hibernate.Session;

import entidades.Jugador;
import hibernate.HibernateUtil;

/**
 *
 * @author Cyn
 */
public class HibernateMain {

    public static void main(String[] args) {
        Jugador jugador = new Jugador();
        jugador.setId(1);
        jugador.setNombre("David");

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(jugador);
        session.getTransaction().commit();
        System.out.println("Jugador ID=" + jugador.getId() + " nomJugador= " + jugador.getNombre());

        Juego juego = new Juego();
        juego.setId(1);
        juego.setIdJugador1(1);
        juego.setIdJugador2(2);
        juego.setGanador(1);

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(juego);
        session.getTransaction().commit();
        System.out.println("Juego ID=" + juego.getId());
        System.out.println("Jugador 1=" + juego.getIdJugador1());
        System.out.println("Jugador 2=" + juego.getIdJugador2());

        HibernateUtil.getSessionFactory().close();
    }

}
