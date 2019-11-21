/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author peperony
 */
public interface Maximun {
    public void agregarCuenta (String nombre, String apellido1, String apellido2, String correo);
    public void editarNombre (String pNombreNuevo, String pContrasenia);
    public void editarApellido1 (String nNuevoApellido, String nContrasenia);
    public void editarApellido2 (String nNuevoApellido, String nContrasenia);
    public void editarCorreo (String nNuevoCorreo, String nContrasenia);
    public void editarContrasenia (String nNuevaContrasenia, String nContrasenia);
    public boolean exiteContrasenia (String nContrasenia);
    public boolean existeCorreo (String nCorreo);
    public boolean existeCuenta (String nUsuario, String nContrasenia);
    public void inicializarUsuario (String nUsuario, String nContrasenia);
    public String crearContrasenia ();
    public void enviarCorreo (String nContrasenia, String nCorreo);
}
