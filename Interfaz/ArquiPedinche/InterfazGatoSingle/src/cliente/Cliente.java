/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.*;
import java.net.*;
import java.util.Observable;

/**
 *
 * @author Cyn
 */
public class Cliente extends Observable {

    private static Cliente instancia;
    private Socket conn;
    private final String ip = "192.168.0.102";
    private final int puerto = 1234;

    public static Cliente getInstance() throws IOException {
        if (instancia == null) {
            instancia = new Cliente();
        }
        return instancia;
    }

    public void goServer(String msg) throws IOException {
        Socket conn = new Socket(ip, puerto);
        InputStream in = conn.getInputStream();
        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        System.out.println("MSG del servidor: " + msg);
        out.writeUTF(msg);
        DataInputStream server = new DataInputStream(conn.getInputStream());
        String mensajeEntrada = server.readUTF();
        System.out.println("mensajeEntrada del servidor: " + mensajeEntrada);

        this.setChanged();
        this.notifyObservers(mensajeEntrada);

        in.close();
        conn.close();
        out.close();
        server.close();

        //ProcesaCliente pc = new ProcesaCliente();
        //return Clases.successServer;//pc.metodo(mensajeEntrada);  // ok para el server constante
    }

}
