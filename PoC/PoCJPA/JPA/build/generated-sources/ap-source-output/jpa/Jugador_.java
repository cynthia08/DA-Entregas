package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.Juegos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-16T19:42:50")
@StaticMetamodel(Jugador.class)
public class Jugador_ { 

    public static volatile SingularAttribute<Jugador, Integer> jugadorID;
    public static volatile CollectionAttribute<Jugador, Juegos> juegosCollection1;
    public static volatile SingularAttribute<Jugador, String> nombre;
    public static volatile CollectionAttribute<Jugador, Juegos> juegosCollection;

}