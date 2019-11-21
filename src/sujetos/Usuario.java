/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sujetos;

/**
 *
 * @author peperony
 */
public class Usuario {
    private String nombre;
    private String contrasenia;
    private String apellido1;
    private String apellido2;
    
    public Usuario (String nNombre, String nContrasenia, String nApellido1, String nApellido2) {
        nombre = nNombre;
        contrasenia = nContrasenia;
        apellido1 = nApellido1;
        apellido2 = nApellido2;
    }
    
    public String getNombre () {
        return nombre;
    }
    
    public String getContrasenia () {
        return contrasenia;
    }
    
    public String getApellido1 () {
        return apellido1;
    }
    
    public String getApellido2 () {
        return apellido2;
    }
    
    public void setNombre (String nNombre) {
        nombre = nNombre;
    }
    
    public void setContrasenia (String nContrasenia) {
        contrasenia = nContrasenia;
    }
    
    public void setApellido1 (String nApellido1) {
        apellido1 = nApellido1;
    }
    
    public void setApelldi2 (String nApellido2) {
        apellido2 = nApellido2;
    }
}
