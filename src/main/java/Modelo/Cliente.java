package Modelo;

import ManejoArchivos.ManejadorArchivos;
import java.util.ArrayList;

public class Cliente {

    private String cedula;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;

    public Cliente(String cedula, String nombre, String apellido, String usuario, String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Cliente{"
                + "cedula='" + cedula + '\''
                + ", nombre='" + nombre + '\''
                + ", apellido='" + apellido + '\''
                + ", usuario='" + usuario + '\''
                + ", contrasena='" + contrasena + '\''
                + '}';
    }
}
