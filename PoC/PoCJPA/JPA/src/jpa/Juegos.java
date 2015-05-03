/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DavidPuga
 */
@Entity
@Table(name = "Juegos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juegos.findAll", query = "SELECT j FROM Juegos j"),
    @NamedQuery(name = "Juegos.findByJuegoID", query = "SELECT j FROM Juegos j WHERE j.juegoID = :juegoID"),
    @NamedQuery(name = "Juegos.findByGanador", query = "SELECT j FROM Juegos j WHERE j.ganador = :ganador"),
    @NamedQuery(name = "Juegos.findByFecha", query = "SELECT j FROM Juegos j WHERE j.fecha = :fecha")})
public class Juegos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "JuegoID")
    private Integer juegoID;
    @Column(name = "Ganador")
    private Integer ganador;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Lob
    @Column(name = "Activo")
    private byte[] activo;
    @JoinColumn(name = "JugadorDos", referencedColumnName = "JugadorID")
    @ManyToOne
    private Jugador jugadorDos;
    @JoinColumn(name = "JugadorUno", referencedColumnName = "JugadorID")
    @ManyToOne
    private Jugador jugadorUno;

    public Juegos() {
    }

    public Juegos(Integer juegoID) {
        this.juegoID = juegoID;
    }

    public Juegos(Integer juegoID, byte[] activo) {
        this.juegoID = juegoID;
        this.activo = activo;
    }

    public Integer getJuegoID() {
        return juegoID;
    }

    public void setJuegoID(Integer juegoID) {
        this.juegoID = juegoID;
    }

    public Integer getGanador() {
        return ganador;
    }

    public void setGanador(Integer ganador) {
        this.ganador = ganador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public byte[] getActivo() {
        return activo;
    }

    public void setActivo(byte[] activo) {
        this.activo = activo;
    }

    public Jugador getJugadorDos() {
        return jugadorDos;
    }

    public void setJugadorDos(Jugador jugadorDos) {
        this.jugadorDos = jugadorDos;
    }

    public Jugador getJugadorUno() {
        return jugadorUno;
    }

    public void setJugadorUno(Jugador jugadorUno) {
        this.jugadorUno = jugadorUno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (juegoID != null ? juegoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juegos)) {
            return false;
        }
        Juegos other = (Juegos) object;
        if ((this.juegoID == null && other.juegoID != null) || (this.juegoID != null && !this.juegoID.equals(other.juegoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Juegos[ juegoID=" + juegoID + " ]";
    }
    
}
