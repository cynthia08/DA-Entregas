/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.*;
import java.net.*;

/**
 *
 * @author Cyn
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);

            System.out.println("Servidor escuchando...");

            ProcesaServidor process = new ProcesaServidor();
            while (true) {
                Socket client = server.accept();
                if (client != null) {
                    Thread hilo = new Thread(new Runnable() {
                        public void run() {
                            try {
                                DataInputStream in = new DataInputStream(client.getInputStream());
                                String msgEntrada = in.readUTF();
                                String msgSalida = process.metodo(msgEntrada);
                                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                                out.writeUTF(msgSalida);

                            } catch (Exception e) {
                            }
                        }
                    });
                    hilo.start();
                }
            }
        } catch (Exception e) {
        }

    }

}
