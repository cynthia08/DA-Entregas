/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.*;
import java.net.*;

/**
 *
 * @author Cyn
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        while (true) {
            try {
                //1. Abro un socket con el servidor
                Socket conn = new Socket("127.0.0.1", 1234);

                //2. Creo un objeto para poder recibir mensajes desde el servidor
                InputStream in = conn.getInputStream();

                //3. Creo un objeto para poder enviar mensajes DE TEXTO al servidor
                DataOutputStream out = new DataOutputStream(conn.getOutputStream());

                //4. Este mtodo me permite leer cadenas desde el teclado
                String mensajeSalida = leeTeclado();

                //5. Lo que le del teclado, se lo mando al servidor
                out.writeUTF(mensajeSalida);

                //recibe
                DataInputStream server = new DataInputStream(conn.getInputStream());
                String mensajeEntrada = server.readUTF();
                System.out.println("Mensaje del servidor: " + mensajeEntrada);

                //cierro el changarro
                in.close();
                out.close();
                server.close();
                conn.close();

            } catch (Exception e) {
                //Esto no se hace :)
            }

        }

    }

    public static String leeTeclado() {
        String entrada = "";
        System.out.println(" Mensaje: ");

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        try {
            entrada = lector.readLine();
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e);
            return "";
        }
        return entrada;
    }

}
