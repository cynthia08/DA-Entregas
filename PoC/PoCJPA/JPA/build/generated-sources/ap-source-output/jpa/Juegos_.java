package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.Jugador;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-16T19:42:50")
@StaticMetamodel(Juegos.class)
public class Juegos_ { 

    public static volatile SingularAttribute<Juegos, Date> fecha;
    public static volatile SingularAttribute<Juegos, Integer> juegoID;
    public static volatile SingularAttribute<Juegos, Integer> ganador;
    public static volatile SingularAttribute<Juegos, Jugador> jugadorDos;
    public static volatile SingularAttribute<Juegos, byte[]> activo;
    public static volatile SingularAttribute<Juegos, Jugador> jugadorUno;

}