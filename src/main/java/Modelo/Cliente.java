package Modelo;

import ManejoArchivos.ManejadorArchivos;
import java.util.ArrayList;

public class Cliente {

    private String cedula;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;
    
    /**
     * Contructor de usuario que sirve para poder verificar si la contraseña
     * es correcta o no
     * 
     * @param usuario 
     * @param contrasena 
     */
    public Cliente(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Cliente(String cedula, String nombre, String apellido, String usuario, String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    /**
     * Metodo que permite obtener los datos del archivo usuario
     * @param ruta Path donde se encuentran los datos
     * @return un ArrayList con los objetos usuarios
     */
    public static ArrayList<Cliente> clientes(String ruta){
        ArrayList<Cliente> usuarios = new ArrayList<>();
        ArrayList<String[]> dataUsuario = ManejadorArchivos.LeerValidando(ruta, false);
        for (String[] dataUser : dataUsuario) {
            usuarios.add(new Cliente(dataUser[0], dataUser[1], dataUser[2], dataUser[3], dataUser[4]));
        }
        return usuarios;
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
    
    /**
     * Metodo equals
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return this.usuario.equals(other.usuario);
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
