/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import ManejoArchivos.ManejadorArchivos;
import java.util.ArrayList;
import Enum.TipoTarifa;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;



public class Principal {
    public static ArrayList<Cliente> Clientes = new ArrayList<>();
    public static ArrayList<Vuelo> Vuelos = new ArrayList<>();
    public static ArrayList<Tarifa> Tarifas = new ArrayList<>();
    public static ArrayList<Promocion> Promociones = new ArrayList<>();
    public static ArrayList<Destino> Destinos = new ArrayList<>();
    public static Cliente cliente;
    private static String Salida;
    private static String Llegada;
    private static String FechaSalida;
    private static String FechaRegreso;
    private static int Viajeros;
    private static boolean repetir = true;
    // Setter para el atributo salida
    public static void setSalida(String salida) {
        Principal.Salida = salida;
    }

    // Getter para el atributo salida
    public static String getSalida() {
        return Salida;
    }

    // Setter para el atributo llegada
    public static void setLlegada(String llegada) {
        Principal.Llegada = llegada;
    }

    // Getter para el atributo llegada
    public static String getLlegada() {
        return Llegada;
    }
    
        // Setter para FechaSalida
    public static void setFechaSalida(String fechaSalida) {
        Principal.FechaSalida = fechaSalida;
    }

    // Getter para FechaSalida
    public static String getFechaSalida() {
        return FechaSalida;
    }

    // Setter para FechaRegreso
    public static void setFechaRegreso(String fechaRegreso) {
        Principal.FechaRegreso = fechaRegreso;
    }

    // Getter para FechaRegreso
    public static String getFechaRegreso() {
        return FechaRegreso;
    }

    // Setter para Viajeros
    public static void setViajeros(int viajeros) {
        Principal.Viajeros = viajeros;
    }

    // Getter para Viajeros
    public static int getViajeros() {
        return Viajeros;
    }

    // Setter para repetir
    public static void setRepetir(boolean repetir) {
        Principal.repetir = repetir;
    }

    // Getter para repetir
    public static boolean isRepetir() {
        return repetir;
    }
    
    /**
    * Método main de la clase principal, donde se leen archivos del proyecto y se llenan en listas estáticas.
    * @param args
    */
    public static void Principal(String[] args) {
        ArrayList<String> cs = ManejadorArchivos.LeerArchivo("clientes.txt");
        ArrayList<String> vs = ManejadorArchivos.LeerArchivo("vuelos.txt");
        ArrayList<String> ts = ManejadorArchivos.LeerArchivo("tarifas.txt");
        ArrayList<String> ps = ManejadorArchivos.LeerArchivo("promociones.txt");
        ArrayList<String> ds = ManejadorArchivos.LeerArchivo("destinos.txt");
        for (String s :cs){
            String[] linea = s.split(",");
            String cedula = linea[0];
            String nombre = linea[1];
            String apellido = linea[2];
            String usuario = linea[3];
            String contrasena = linea[4];
            Clientes.add(new Cliente(cedula, nombre, apellido, usuario, contrasena));
        }
        for (String s :vs){
            String[] linea = s.split(",");
            String origen = linea[0];
            String destino = linea[1];
            int duracion = Integer.parseInt(linea[2]);
            String horaSalida = linea[3];
            String horaLlegada = linea[4];
            String numeroVuelo = linea[5];
            String codigoAvion = linea[6];
            double precio = Double.parseDouble(linea[7]);
            Vuelos.add(new Vuelo(origen, destino, duracion, horaSalida, horaLlegada, numeroVuelo, codigoAvion, precio));
            
        }
        for (String s :ts){
            String[] linea = s.split(",");
            String nombre = linea[0];
            TipoTarifa tipo = TipoTarifa.valueOf(linea[1]);
            String[] lc = linea[2].split("-");
            ArrayList<String> listaCaracteristicas = new ArrayList<String>(Arrays.asList(lc));
            byte porcentaje = Byte.parseByte(linea[3]);
            Tarifas.add(new Tarifa(nombre, tipo, listaCaracteristicas, porcentaje));
            
        }
        for (String s :ps){
            String[] linea = s.split(",");
            short coordenadaX = Short.parseShort(linea[0]);
            short coordenadaY = Short.parseShort(linea[1]);
            String pais = linea[2];
            String codigo = linea[3];
            byte descuento = Byte.parseByte(linea[4]);
            Promociones.add(new Promocion(coordenadaX, coordenadaY, pais, codigo, descuento));
        }
        for (String s :ds){
            String[] linea = s.split(",");
            String ciudad = linea[0];
            String pais = linea[1];
            Destinos.add(new Destino(ciudad, pais));
        }
    }
    
    
    /**
    * Método para crear un archivo binario para las reservas creadas.
    * @param reserva que se va a serializar.
    */
    public void szrReserva(Reserva reserva){
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(reserva.getCodigoReserva()+".bin"))) {
          stream.writeObject(reserva);
        } catch (IOException e) {
          e.printStackTrace();
          System.out.println("Error en el proceso de serialización: " + e.getMessage());
        }
    }

    /**
    * Método para verificar si los datos ingresados por el usuario son los correctos
    * @param usuario del cliente
    * @param contrasena del cliente
    * @return booleano para saber si el usuario puede proceder a la siguiente vista y asignar el atributo estático cliente.
    */
    public static boolean Iniciar_Sesion(String usuario, String contrasena) {
        boolean verificado = false;
        for (Cliente c: Clientes){
            if (c.getUsuario().equals(usuario) && c.getContrasena().equals(contrasena)){
                System.out.println("Usuario y contrasenia correctos");
                cliente = c;
                verificado = true;
                break;
            }
        }
        if(!verificado){
            System.out.println("Usuario o contrasenia incorrectos");
        }
        return verificado;
    }
}
