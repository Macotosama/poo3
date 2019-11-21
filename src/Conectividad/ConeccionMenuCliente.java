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
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author peperony
 */
public class ConeccionMenuCliente extends Thread{
    protected static Socket socket = null;
    protected static InputStream inFromServer;
    protected static DataInputStream in;
    protected static OutputStream outToServer;
    protected static DataOutputStream out;
    
    public static void iniciarSocket (String ip, int port) throws IOException {
        socket = new Socket(ip,port);
        inFromServer = socket.getInputStream();
        in =  new DataInputStream(inFromServer);
        outToServer = socket.getOutputStream();
        out = new DataOutputStream(outToServer);
    }
}
