/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectividad;

import control.Maximun;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peperony
 */
public class ServerMenu extends ConeccionMenuServidor implements Maximun{
    
   @Override
    public void run (){
        String line = "";
        while (!line.equals("EstoEsElMEnsajeDeFinal123443210")) {
            try {
                line = in.readUTF();
                System.out.println("El mensaje de llegada es " + line);
                arreglar(line);
            } catch (IOException ex) {
                Logger.getLogger(ServerMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    private void arreglar (String line) {
        String arreglo[] = line.split("/*");
        
        switch (arreglo[0]) {
            case "agregarCuenta":
                agregarCuenta(arreglo[1],arreglo[2],arreglo[3],arreglo[4]);
                break;
            case "editarNombre":
                editarNombre(arreglo[1], arreglo[2]);
                break;
            case "editarApellido1":
                editarApellido1(arreglo[1],arreglo[2]);
                break;
        }
    }

    @Override
    public void agregarCuenta(String nombre, String apellido1, String apellido2, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarNombre(String pNombreNuevo, String pContrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarApellido1(String nNuevoApellido, String nContrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarApellido2(String nNuevoApellido, String nContrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarCorreo(String nNuevoCorreo, String nContrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarContrasenia(String nNuevaContrasenia, String nContrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exiteContrasenia(String nContrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existeCorreo(String nCorreo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existeCuenta(String nUsuario, String nContrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inicializarUsuario(String nUsuario, String nContrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String crearContrasenia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enviarCorreo(String nContrasenia, String nCorreo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
