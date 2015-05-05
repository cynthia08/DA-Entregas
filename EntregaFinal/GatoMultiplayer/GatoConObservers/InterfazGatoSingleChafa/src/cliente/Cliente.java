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
    private final String ip = "10.48.211.133";
    private final int puerto = 1234;

    public Cliente() throws IOException {
        this.conn = new Socket(ip, puerto);
        Thread hilo = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        listenerServer();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        hilo.start();
    }

    public static Cliente getInstance() throws IOException {
        if (instancia == null) {
            instancia = new Cliente();
        }
        return instancia;
    }

    public void cerrar() throws IOException {
        this.conn.close();
    }

    public void goServer(String msg) throws IOException {
        InputStream in = conn.getInputStream();
        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        System.out.println("MSGSalida del servidor: " + msg);
        out.writeUTF(msg);
    }

    public void listenerServer() throws IOException {
        DataInputStream server = new DataInputStream(conn.getInputStream());
        String mensajeEntrada = server.readUTF();
        System.out.println("MSGEntrada del servidor: " + mensajeEntrada);
        this.setChanged();
        this.notifyObservers(mensajeEntrada);
    }

}
