/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import Conectividad.ConeccionMenuServidor;
import Conectividad.ServerMenu;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import sujetos.Usuario;
import xmlmodelo.Cuentas;
/**
 *
 * @author peperony
 */
public class ControladorServer implements Maximun{
    Cuentas cuentas;
    Usuario usuario;
    ServerMenu entrada;
    
    public ControladorServer () {
        try {
            ConeccionMenuServidor.iniciarServer(20000);
            entrada = new ServerMenu();
            entrada.start();
        } catch (IOException ex) {
            Logger.getLogger(ControladorServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        cuentas = new Cuentas();
    }
    
    @Override
    public void agregarCuenta (String nombre, String apellido1, String apellido2, String correo) {
        String contrasenia = crearContrasenia();
        cuentas.agregarCuenta(nombre, apellido1, apellido2, correo, contrasenia);
        enviarCorreo (contrasenia, correo);
    }
    
    @Override
    public void editarNombre (String pNombreNuevo, String pContrasenia) {
        cuentas.cambiarNombre(pNombreNuevo, pContrasenia);
    }
    
    @Override
    public void editarApellido1 (String nNuevoApellido, String nContrasenia) {
        cuentas.cambiarApellido1(nNuevoApellido, nContrasenia);
    }
    
    @Override
    public void editarApellido2 (String nNuevoApellido, String nContrasenia) {
        cuentas.cambiarApellido2(nNuevoApellido, nContrasenia);
    }
    
    @Override
    public void editarCorreo (String nNuevoCorreo, String nContrasenia) {
        cuentas.cambiarCorreo(nNuevoCorreo, nContrasenia);
    }
    
    @Override
    public void editarContrasenia (String nNuevaContrasenia, String nContrasenia) {
        cuentas.cambiarContrasenia(nNuevaContrasenia, nContrasenia);
    }
    
    @Override
    public boolean exiteContrasenia (String nContrasenia) {
        return cuentas.existeContrasenia(nContrasenia);
    }
    
    @Override
    public boolean existeCorreo (String nCorreo) {
        return cuentas.existeCorreo(nCorreo);
    }
    
    @Override
    public boolean existeCuenta (String nUsuario, String nContrasenia) {
        return cuentas.existeCuenta(nUsuario, nContrasenia);
    }
    
    @Override
    public void inicializarUsuario (String nUsuario, String nContrasenia) {
        usuario = cuentas.crearUsuario(nUsuario, nContrasenia);
    }
    
    @Override
    public String crearContrasenia () {
        String letrasMA[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "X", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String letrasMI[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String contra = "";
        int r = 0;
        int j = 0;
        for (int i = 0; i < 10; i++) {
            r = (int) (Math.random() * 26);
            j = (int) (Math.random() * 3);
            if (j == 0) {
                contra += letrasMA[r];
            } else if (j == 2) {
                contra += letrasMI[r];
            } else {
                contra += r;
            }
            
        }
        return contra;
    }
    
    @Override
    public void enviarCorreo (String nContrasenia, String nCorreo) {
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("main.smtp.auth", "true");
              
        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = "lalatro1999@gmail.com";
        String contrasena = "lalatro1999";
        String receptor = nCorreo;
        String asunto = "Contraña de su cuenta de 4 en linea";
        String mensaje= "La contraseña de su cuatro en linea es: " + nContrasenia;
        
        MimeMessage mail = new MimeMessage(sesion);       
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (receptor));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(correoEnvia,contrasena);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
            transportar.close();
            
        } catch (AddressException ex) {
            Logger.getLogger(ControladorServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ControladorServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
