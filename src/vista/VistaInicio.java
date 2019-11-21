/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import inicio.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author peperony
 */
public class VistaInicio implements ActionListener{
    private Inicio inicio;
    
    public VistaInicio () {
        inicio = new Inicio();
    }
    
    public void iniciarElementos () {
        ipServidor () ;
        inicio.setVisible(true);
        inicio.comienzo.setVisible(true);
        
        inicio.add(inicio.comienzo,new AbsoluteConstraints(0,0,-1,-1));
        
        inicio.comienzo.jButtonCliente.addActionListener(this);
        inicio.comienzo.jButtonServidor.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        switch(opcion) {
            case "Servidor":
                break;
            case "Cliente":
                break;
        }
    }
    
        private void ipServidor () {
        try {
            InetAddress address = InetAddress.getLocalHost();
            inicio.comienzo.jLabelIp.setText("Ip : "+address.getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
