/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectividad;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author peperony
 */
public class ConeccionMenuServidor extends Thread {
    protected static Socket socket = null;
    protected static ServerSocket server = null;
    protected static DataInputStream in = null;
    protected static OutputStream outToServer = null;
    protected static DataOutputStream out = null;
    protected static InputStream inFromServer = null;
    
    public static void iniciarServer (int puerto) throws IOException {
        server = new ServerSocket(puerto);
        socket = server.accept();
        outToServer = socket.getOutputStream();
        out = new DataOutputStream(outToServer);
        inFromServer = socket.getInputStream();
        in =  new DataInputStream(inFromServer);
    }
}
