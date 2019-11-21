/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import GUI.Fondo;
import control.ControladorServer;
import control.Maximun;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author Josué Torres Naraéz
 */
public class Vista implements ActionListener{
    
    private Fondo fondo;
    private Maximun control;
    
    
    public Vista () {
        fondo = new Fondo();
    }
    
    public void iniciarElementos () {
        ipServidor();
        fondo.setVisible(true);
        //fondo.inicio.setVisible(true);
        fondo.contrasenia.setVisible(false);
        fondo.registrar.setVisible(false);
        fondo.mPrincipal.setVisible(false);
        fondo.loguin.setVisible(false);
        fondo.cPartida.setVisible(false);
        fondo.uPartida.setVisible(false);
        fondo.ranking.setVisible(false);
        fondo.espectador.setVisible(false);
        fondo.confi.setVisible(false);
        //fondo.ip.setVisible(false);
        
        fondo.add(fondo.contrasenia,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.registrar,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.mPrincipal,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.loguin,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.cPartida,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.uPartida,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.ranking,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.espectador,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.confi,new AbsoluteConstraints(0,0,-1,-1));
        //fondo.add(fondo.inicio,new AbsoluteConstraints(0,0,-1,-1));
        //fondo.add(fondo.ip,new AbsoluteConstraints(0,0,-1,-1));
        
        fondo.contrasenia.Salir.addActionListener(this);
        fondo.contrasenia.Registrarse.addActionListener(this);
        fondo.contrasenia.IniciarSesion.addActionListener(this);
        fondo.registrar.Salir.addActionListener(this);
        fondo.registrar.jButtonAceptarRegistrar.addActionListener(this);
        fondo.registrar.Atras.addActionListener(this);
        fondo.loguin.Atras.addActionListener(this);
        fondo.loguin.Salir.addActionListener(this);
        fondo.loguin.jButtonAceptarLogin.addActionListener(this);
        fondo.mPrincipal.Atras.addActionListener(this);
        fondo.mPrincipal.Salir.addActionListener(this);
        fondo.mPrincipal.jButtonCrearPartida.addActionListener(this);
        fondo.mPrincipal.jButtonEspectar.addActionListener(this);
        fondo.mPrincipal.jButtonRanking.addActionListener(this);
        fondo.mPrincipal.jButtonUnircePartida.addActionListener(this);
        fondo.mPrincipal.jButtonConfing.addActionListener(this);
        fondo.cPartida.salir.addActionListener(this);
        fondo.cPartida.atras.addActionListener(this);
        fondo.cPartida.Rojo.addActionListener(this);
        fondo.cPartida.azul.addActionListener(this);
        fondo.cPartida.jButtonComenzar.addActionListener(this);
        fondo.cPartida.Verde.addActionListener(this);
        fondo.uPartida.Salir.addActionListener(this);
        fondo.uPartida.Atras.addActionListener(this);
        fondo.ranking.atras.addActionListener(this);
        fondo.ranking.salir.addActionListener(this);
        fondo.espectador.salir.addActionListener(this);
        fondo.espectador.atras.addActionListener(this);
        fondo.confi.atras.addActionListener(this);
        fondo.confi.salir.addActionListener(this);
        //fondo.inicio.jButtonCliente.addActionListener(this);
        //fondo.inicio.jButtonServidor.addActionListener(this);
       // fondo.ip.jButtonAceptarIp.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String mensaje = e.getActionCommand();
        switch (mensaje) {
            case "Salir":
                System.exit(0);
            case "IniciarSesion":
                fondo.loguin.setVisible(true);
                fondo.contrasenia.setVisible(false);
                break;
            case "Registrarse":
                fondo.registrar.setVisible(true);
                fondo.contrasenia.setVisible(false);
                break;
            case "AtrasRegistrar":
                fondo.contrasenia.setVisible(true);
                fondo.registrar.setVisible(false);
                fondo.registrar.jTextFieldNombre.setText("");
                fondo.registrar.jTextFieldApellido1.setText("");
                fondo.registrar.jTextFieldApellido2.setText("");
                fondo.registrar.jTextFieldCorreo.setText("");
                break;
            case "AtrasLoguin":
                fondo.contrasenia.setVisible(true);
                fondo.loguin.setVisible(false);
                fondo.loguin.jTextFieldContrasenia.setText("");
                fondo.loguin.jTextFieldUsuario.setText("");
                break;
            case "AceptarLogin":
                iniciarSesion();
                break;
            case "AtrasMPrincipal":
                    fondo.loguin.setVisible(true);
                    fondo.mPrincipal.setVisible(false);
                    break;
            case "CrearPartida":
                fondo.cPartida.setVisible(true);
                fondo.mPrincipal.setVisible(false);
                break;
            case "AtrasCrearPartida":
                fondo.mPrincipal.setVisible(true);
                fondo.cPartida.setVisible(false);
                fondo.cPartida.jTextFieldColumnas.setText("");
                fondo.cPartida.jTextFieldFilas.setText("");
                fondo.cPartida.jTextFieldNombre.setText("");
                break;
            case "Rojo":
                fondo.cPartida.azul.setSelected(false);
                fondo.cPartida.Verde.setSelected(false);
                break;
            case "azul":
                fondo.cPartida.Rojo.setSelected(false);
                fondo.cPartida.Verde.setSelected(false);
                break;
            case "verde":
                fondo.cPartida.Rojo.setSelected(false);
                fondo.cPartida.azul.setSelected(false);
                break;
            case "AtrasUPartida":
                fondo.mPrincipal.setVisible(true);
                fondo.uPartida.setVisible(false);
                break;
            case "UnircePartida":
                fondo.uPartida.setVisible(true);
                fondo.mPrincipal.setVisible(false);
                break;
            case "AtrasRanking":
                fondo.mPrincipal.setVisible(true);
                fondo.ranking.setVisible(false);
                break;
            case "ranking":
                fondo.ranking.setVisible(true);
                fondo.mPrincipal.setVisible(false);
                break;
            case "atrasEspectador":
                fondo.mPrincipal.setVisible(true);
                fondo.espectador.setVisible(false);
                break;
            case "Espectador":
                fondo.espectador.setVisible(true);
                fondo.mPrincipal.setVisible(false);
                break;
            case "AtrasConfi":
                fondo.mPrincipal.setVisible(true);
                fondo.confi.setVisible(false);
                fondo.confi.Apellido1.setText("");
                fondo.confi.Apellido2.setText("");
                fondo.confi.Contrasenia.setText("");
                fondo.confi.Correo.setText("");
                fondo.confi.Nombre.setText("");
                break;
            case "Confi":
                fondo.confi.setVisible(true);
                fondo.mPrincipal.setVisible(false);
                break;
            case "AceptarRegistrar":
                registrarUsuario();
                break;
                /*            case "Cliente":
                fondo.ip.setVisible(true);
                fondo.inicio.setVisible(false);
                break;
                case "Servidor":
                fondo.contrasenia.setVisible(true);
                fondo.inicio.setVisible(false);
                control = new ControladorServer();
                break;*/
        }
    }
    
    private void iniciarSesion () {
        if (!fondo.loguin.jTextFieldContrasenia.equals("") && !fondo.loguin.jTextFieldUsuario.getText().equals("")) {
            if (control.existeCuenta(fondo.loguin.jTextFieldUsuario.getText(), fondo.loguin.jTextFieldContrasenia.getText())) {
                control.inicializarUsuario(fondo.loguin.jTextFieldUsuario.getText(), fondo.loguin.jTextFieldContrasenia.getText());
                fondo.mPrincipal.setVisible(true);
                fondo.loguin.setVisible(false);
                fondo.loguin.jTextFieldContrasenia.setText("");
                fondo.loguin.jTextFieldUsuario.setText("");
            }else {
                JOptionPane.showMessageDialog(fondo,"No existe la cuenta.","Error.",JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(fondo,"Llene los espacios.","Error.",JOptionPane.WARNING_MESSAGE);
            //JOptionPane.showMessageDialog(fondo,"Hubo un error en la imagen.","Error de imagen",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void registrarUsuario () {
        String nNombre = fondo.registrar.jTextFieldNombre.getText();
        String nApellido1 = fondo.registrar.jTextFieldApellido1.getText();
        String nApellido2 = fondo.registrar.jTextFieldApellido2.getText();
        String nCorreo = fondo.registrar.jTextFieldCorreo.getText();
        if (!nNombre.equals("") && !nApellido1.equals("") && !nApellido2.equals("") && !nCorreo.equals("")) {
            if (control.existeCorreo(nCorreo)){
                control.agregarCuenta(nNombre, nApellido1, nApellido2, nCorreo);
                fondo.registrar.jTextFieldNombre.setText("");
                fondo.registrar.jTextFieldApellido1.setText("");
                fondo.registrar.jTextFieldApellido2.setText("");
                fondo.registrar.jTextFieldCorreo.setText("");
                fondo.contrasenia.setVisible(true);
                fondo.registrar.setVisible(false);
                JOptionPane.showMessageDialog(fondo, "Listo, revise su correo para ver su contraseña");
            } else {
                JOptionPane.showMessageDialog(fondo,"El correo ya esta registrado con una cuenta.","Error.",JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(fondo,"Llene los espacios.","Error.",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void ipServidor () {
        try {
            InetAddress address = InetAddress.getLocalHost();
            //fondo.inicio.jLabelIP.setText("Ip : "+address.getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
