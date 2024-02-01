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
    private static Vuelo vuelo1;
    private static Vuelo vuelo2;
    private static Tarifa tarifa1;
    private static Tarifa tarifa2;
    private static double precio1;
    private static double precio2;
    private static String pais;
    
    
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
    public static boolean getRepetir() {
        return repetir;
    }
    
    public static void setVuelo1(Vuelo vuelo){
        vuelo1 = vuelo;
    }
    
    public static Vuelo getVuelo1(){
        return vuelo1;
    }
    
    public static void setVuelo2(Vuelo vuelo){
        Principal.vuelo2 = vuelo;
    }
    
    public static Vuelo getVuelo2(){
        return vuelo2;
    }
    
    public static void setTarifa1(Tarifa tarifa){
        tarifa1 = tarifa;
    }
    
    public static Tarifa getTarifa1(){
        return tarifa1;
    }
    
    public static void setTarifa2(Tarifa tarifa){
        tarifa2 = tarifa;
    }
    
    public static Tarifa getTarifa2(){
        return tarifa2;
    }
    
    public static void setPrecio1(double p){
        precio1 = p;
    }
    
    public static double getPrecio1(){
        return precio1;
    }
    
    public static void setPrecio2(double p){
        precio2 = p;
    }
    
    public static double getPrecio2(){
        return precio2;
    }
    
    public static void setPais(String p){
        pais = p;
    }
    
    public static String getPais(){
        return pais;
    }
    
    /**
    * Método main de la clase principal, donde se leen archivos del proyecto y se llenan en listas estáticas.
    * @param args
    */
    public static void Ejecutar() {
        System.out.println("TEsting");
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
            String origen = linea[1];
            String destino = linea[2];
            int duracion = Integer.parseInt(linea[3]);
            String horaSalida = linea[4];
            String horaLlegada = linea[5];
            String numeroVuelo = linea[0];
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
            double coordenadaX = Double.parseDouble(linea[0]);
            double coordenadaY = Double.parseDouble(linea[1]);
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
        System.out.println("Se ejecuto");
    }
    
    
    /**
    * Método para crear un archivo binario para las reservas creadas.
    * @param reserva que se va a serializar.
    */
    public static void szrReserva(Reserva reserva){
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(reserva.getCodigoReserva()+".bin"))) {
          stream.writeObject(reserva);
        } catch (IOException e) {
          e.printStackTrace();
          System.out.println("Error en el proceso de serialización: " + e.getMessage());
        }
    }
}
