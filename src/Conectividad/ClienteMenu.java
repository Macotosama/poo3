/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectividad;

import java.io.IOException;

/**
 *
 * @author peperony
 */
public class ClienteMenu extends ConeccionMenuCliente{
    boolean terminar;
    
    public ClienteMenu () {
        
    }
    
    @Override
    public void run () {
        
        while (terminar) {
            try {
                String mensage = in.readUTF();
                System.out.println("el mensaje enviado del servidor es " + mensage);
            } catch (IOException ex) {
            }
        }
    }
}
