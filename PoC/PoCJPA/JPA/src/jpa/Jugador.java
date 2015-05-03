/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DavidPuga
 */
@Entity
@Table(name = "Jugador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j"),
    @NamedQuery(name = "Jugador.findByJugadorID", query = "SELECT j FROM Jugador j WHERE j.jugadorID = :jugadorID"),
    @NamedQuery(name = "Jugador.findByNombre", query = "SELECT j FROM Jugador j WHERE j.nombre = :nombre")})
public class Jugador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "JugadorID")
    private Integer jugadorID;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @OneToMany(mappedBy = "jugadorDos")
    private Collection<Juegos> juegosCollection;
    @OneToMany(mappedBy = "jugadorUno")
    private Collection<Juegos> juegosCollection1;

    public Jugador() {
    }

    public Jugador(Integer jugadorID) {
        this.jugadorID = jugadorID;
    }

    public Jugador(Integer jugadorID, String nombre) {
        this.jugadorID = jugadorID;
        this.nombre = nombre;
    }

    public Integer getJugadorID() {
        return jugadorID;
    }

    public void setJugadorID(Integer jugadorID) {
        this.jugadorID = jugadorID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Juegos> getJuegosCollection() {
        return juegosCollection;
    }

    public void setJuegosCollection(Collection<Juegos> juegosCollection) {
        this.juegosCollection = juegosCollection;
    }

    @XmlTransient
    public Collection<Juegos> getJuegosCollection1() {
        return juegosCollection1;
    }

    public void setJuegosCollection1(Collection<Juegos> juegosCollection1) {
        this.juegosCollection1 = juegosCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jugadorID != null ? jugadorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.jugadorID == null && other.jugadorID != null) || (this.jugadorID != null && !this.jugadorID.equals(other.jugadorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Jugador[ jugadorID=" + jugadorID + " ]";
    }
    
}
