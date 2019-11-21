/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectividad;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
/**
 *
 * @author peperony
 */
public class Coneccion {
    private Socket socket;
    private OutputStream outToServer;
    private DataOutputStream out;
    
    private InputStream inFromServer;
    private DataInputStream in;
}
