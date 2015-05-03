/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Cyn
 */


public class Servicios extends Conexion {

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

    public ArrayList<Integer> buscarJuego() {
        ArrayList<Integer> al = new ArrayList<>();
        try {
            this.conectar();
            this.consulta = this.con.prepareCall("call buscarJuego()");
            ResultSet datos = this.consulta.executeQuery();
            datos.next();
            al.add(datos.getInt("JuegoID"));
            al.add(datos.getInt("JugadorUno"));
            this.desconectar();
        } catch (SQLException ex) {
        }
        return al;
    }
    
    public String mierda(){
        String caca = null;
        try{
            this.conectar();
            Statement st = this.con.createStatement();
            ResultSet x = st.executeQuery("Select * from Juegos");
            
        } catch (SQLException ex) {
        }
        return caca;
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

    public int insertarJugador(int juegoID, String jugador) {
        int id = 0;
        try {
            this.conectar();
            this.consulta = this.con.prepareCall("call insertarJugador(?, ?)");
            this.consulta.setInt(1, juegoID);
            this.consulta.setString(2, jugador);
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

