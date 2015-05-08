/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class Servicio extends Conexion {

    public int nuevoJugador(String nombre) {
        int id = 0;
        try {
            this.conectar();
            this.consulta = this.con.prepareCall("call nuevoJugador(?)");
            this.consulta.setString(1, nombre);
            ResultSet datos = this.consulta.executeQuery();
            datos.next();
            id = datos.getInt("ID");
            this.desconectar();
        } catch (SQLException ex) {
        }
        return id;
    }

    public String getNombre(int id) {
        String nombre = null;
        try {
            this.conectar();
            this.consulta = this.con.prepareCall("call getNombre(?)");
            this.consulta.setInt(1, id);
            ResultSet datos = this.consulta.executeQuery();
            datos.next();
            nombre = datos.getString("Nombre");
            this.desconectar();
        } catch (SQLException ex) {
        }
        return nombre;
    }

    public int crearJuego(int jugador1, int jugador2) {
        int id = 0;
        try {
            this.conectar();
            this.consulta = this.con.prepareCall("call crearJuego(?, ?)");
            this.consulta.setInt(1, jugador1);
            this.consulta.setInt(2, jugador2);
            ResultSet datos = this.consulta.executeQuery();
            datos.next();
            id = datos.getInt("ID");
            this.desconectar();
        } catch (SQLException ex) {
        }
        return id;
    }

    public void ganarJuego(int juegoID, int jugadorID) {
        try {
            this.conectar();
            this.consulta = this.con.prepareCall("call ganarJuego(?, ?)");
            this.consulta.setInt(1, juegoID);
            this.consulta.setInt(2, jugadorID);
            this.consulta.executeQuery();
            this.desconectar();
        } catch (SQLException ex) {
        }
    }
}
