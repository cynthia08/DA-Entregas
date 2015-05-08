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
    private final String ip = "127.0.0.1";
    private final int puerto = 1234;

    public Cliente() throws IOException {
        this.conn = new Socket(ip, puerto);
    }

    public static Cliente getInstance() throws IOException {
        if (instancia == null) {
            instancia = new Cliente();
        }
        return instancia;
    }

//    public void cerrar() throws IOException {
//        this.conn.close();
//    }
    public void goServer(String msg) throws IOException {
        //Socket conn = new Socket(ip, puerto);
        InputStream in = conn.getInputStream();
        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        System.out.println("MSGSalida del servidor: " + msg);
        out.writeUTF(msg);
        DataInputStream server = new DataInputStream(conn.getInputStream());
        String mensajeEntrada = server.readUTF();
        System.out.println("MSGEntrada del servidor: " + mensajeEntrada);

        this.setChanged();
        this.notifyObservers(mensajeEntrada);

        in.close();
        out.close();
        server.close();
        //conn.close();
    }
    
    public void ansServer(String msg) throws IOException {
        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        out.writeUTF(msg);
        System.out.println("MSGSALIDA Personal del servidor = " + msg);
    }

}
