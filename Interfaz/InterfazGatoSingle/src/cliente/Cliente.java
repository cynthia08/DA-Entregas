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

    public static String goServer(String msg) throws IOException {
        Socket conn = new Socket("127.0.0.1", 1234);

        InputStream in = conn.getInputStream();

        DataOutputStream out = new DataOutputStream(conn.getOutputStream());

        out.writeUTF(msg);

        DataInputStream server = new DataInputStream(conn.getInputStream());
        String mensajeEntrada = server.readUTF();
        System.out.println("Mensaje del servidor: " + mensajeEntrada);

        in.close();
        conn.close();
        out.close();
        server.close();
        
        ProcesaCliente pc = new ProcesaCliente();
        return pc.metodo(mensajeEntrada);
    }

}
