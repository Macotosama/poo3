/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Conectividad.ClienteMenu;
import Conectividad.ConeccionMenuCliente;
import Conectividad.ServerMenu;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sujetos.Usuario;
import xmlmodelo.Cuentas;

/**
 *
 * @author peperony
 */
public class ControlCliente implements Maximun{
    Cuentas cuentas;
    Usuario usuario;
    ClienteMenu entrada;
    
    public ControlCliente (String ip, int port) {
        try {
            ConeccionMenuCliente.iniciarSocket(ip, port);
            entrada = new ClienteMenu();
        } catch (IOException ex) {
            Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        cuentas = new Cuentas();
        
    }

    @Override
    public void agregarCuenta(String nombre, String apellido1, String apellido2, String correo) {
    }

    @Override
    public void editarNombre(String pNombreNuevo, String pContrasenia) {
    }

    @Override
    public void editarApellido1(String nNuevoApellido, String nContrasenia) {
    }

    @Override
    public void editarApellido2(String nNuevoApellido, String nContrasenia) {
    }

    @Override
    public void editarCorreo(String nNuevoCorreo, String nContrasenia) {
    }

    @Override
    public void editarContrasenia(String nNuevaContrasenia, String nContrasenia) {
    }

    @Override
    public boolean exiteContrasenia(String nContrasenia) {
        return true;
    }

    @Override
    public boolean existeCorreo(String nCorreo) {
        return true;
    }

    @Override
    public boolean existeCuenta(String nUsuario, String nContrasenia) {
        return true;
    }

    @Override
    public void inicializarUsuario(String nUsuario, String nContrasenia) {
    }

    @Override
    public String crearContrasenia() {
        return "";
    }

    @Override
    public void enviarCorreo(String nContrasenia, String nCorreo) {
    }
    
}
