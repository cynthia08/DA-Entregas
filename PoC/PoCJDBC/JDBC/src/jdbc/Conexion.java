/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cyn
 */
public class Conexion {
    protected Connection con = null;
    protected CallableStatement consulta;
    private final String DB = "ultimateGato", User = "root", Password = "1234";

    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.con = DriverManager.getConnection("jdbc:mysql://localhost/" + DB, User, Password);
        } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void desconectar() {
        try {
            this.con.close();
        } catch (SQLException ex) {
        }
    }

}
