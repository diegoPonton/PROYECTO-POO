package Modelo;

import static Enum.TipoTarifa.*;
import Enum.FormaPago;
import ManejoArchivos.ManejadorArchivos;
import java.io.Serializable;
import java.util.Random;

public class Reserva implements Serializable{
    private Cliente cliente;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String fechaSalida;
    private String fechaRegresa;
    private int numeroPasajeros;
    private String numeroVueloIda;
    private String numeroVueloRegreso;
    private Tarifa tarifaIda;
    private Tarifa tarifaRegreso;
    private String codigoReserva;

    public Reserva(){
    
    }
    
    public Reserva(Cliente cliente, String ciudadOrigen, String ciudadDestino, String fechaSalida, String fechaRegresa, int numeroPasajeros, String numeroVueloIda, String numeroVueloRegreso, Tarifa tarifaIda, Tarifa tarifaRegreso) {
        this.cliente = cliente;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fechaSalida = fechaSalida;
        this.fechaRegresa = fechaRegresa;
        this.numeroPasajeros = numeroPasajeros;
        this.numeroVueloIda = numeroVueloIda;
        this.numeroVueloRegreso = numeroVueloRegreso;
        this.tarifaIda = tarifaIda;
        this.tarifaRegreso = tarifaRegreso;
        this.codigoReserva = Reserva.codigoReserva();
    }
    
    // Setter and getter for 'ciudadOrigen'
    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    // Setter and getter for 'ciudadDestino'
    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    // Setter and getter for 'fechaSalida'
    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    // Setter and getter for 'fechaRegresa'
    public String getFechaRegresa() {
        return fechaRegresa;
    }

    public void setFechaRegresa(String fechaRegresa) {
        this.fechaRegresa = fechaRegresa;
    }

    // Setter and getter for 'numeroPasajeros'
    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    // Setter and getter for 'numeroVueloIda'
    public String getNumeroVueloIda() {
        return numeroVueloIda;
    }

    public void setNumeroVueloIda(String numeroVueloIda) {
        this.numeroVueloIda = numeroVueloIda;
    }

    // Setter and getter for 'numeroVueloRegreso'
    public String getNumeroVueloRegreso() {
        return numeroVueloRegreso;
    }

    public void setNumeroVueloRegreso(String numeroVueloRegreso) {
        this.numeroVueloRegreso = numeroVueloRegreso;
    }

    // Setter and getter for 'tarifaIda'
    public Tarifa getTarifaIda() {
        return tarifaIda;
    }

    public void setTarifaIda(Tarifa tarifaIda) {
        this.tarifaIda = tarifaIda;
    }

    // Setter and getter for 'tarifaRegreso'
    public Tarifa getTarifaRegreso() {
        return tarifaRegreso;
    }

    public void setTarifaRegreso(Tarifa tarifaRegreso) {
        this.tarifaRegreso = tarifaRegreso;
    }

    // Setter and getter for 'codigoReserva'
    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", ciudadOrigen='" + ciudadOrigen + '\'' +
                ", ciudadDestino='" + ciudadDestino + '\'' +
                ", fechaSalida='" + fechaSalida + '\'' +
                ", fechaRegresa='" + fechaRegresa + '\'' +
                ", numeroPasajeros=" + numeroPasajeros +
                ", numeroVueloIda=" + numeroVueloIda +
                ", numeroVueloRegreso=" + numeroVueloRegreso +
                ", tarifaIda=" + tarifaIda +
                ", tarifaRegreso=" + tarifaRegreso +
                ", codigoReserva='" + codigoReserva + '\'' +
                '}';
    }
    
    public Pago generarTransaccion(int descuento, FormaPago formaPago){
        double precioIda = 0;
        double precioRegreso = 0;
        int multIda = 0;
        int multRegreso = 0;
        for(Vuelo v: Principal.Vuelos){
            if(v.getNumeroVuelo().equals(numeroVueloIda)){
                precioIda = v.getPrecio();
            }
            if(v.getNumeroVuelo().equals(numeroVueloRegreso)){
                precioRegreso = v.getPrecio();
            }
        }
        switch(tarifaIda.getTipo()){
            case S:
                multIda = 1;
                break;
            case M:
                multIda = 15;
                break;
            case L:
                multIda = 30;
                break;
        }
        switch(tarifaIda.getTipo()){
            case S:
                multIda = 1;
                break;
            case M:
                multIda = 15;
                break;
            case L:
                multIda = 30;
                break;
        }
        double total = (precioIda * multIda)+(precioRegreso * multRegreso);
        Pago pago = new Pago(codigoReserva, total, descuento, formaPago);
        return pago;
    }
    /**
     * Obtiene el usuario
     * @return 
     */
    public Cliente getCliente() {
        return cliente;
    }
    
    /**
     * Establece el usuario 
     * @param usuario 
     */

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // FALTA LA FUNCION PAGAR RESERVA
    
    /**
    * Método para escribir archivos de reservas
    */
    public void RegistrarReserva(){
        String header = "CodigoReserva,cedulaCliente,ciudadOrigen,ciudadDestino,fechaSalida,fechaRegreso,numPasajeros,numVueloIda,nomVueloRegreso,tipoTaraifaIda,tipoTarifaRegreso";
        String linea = codigoReserva+","+cliente.getCedula()+","+ciudadOrigen+","+ciudadDestino+","+fechaSalida+","+fechaRegresa+","+String.valueOf(numeroPasajeros)+","+String.valueOf(numeroVueloIda)+","+String.valueOf(numeroVueloRegreso)+","+tarifaIda.getTipo()+","+tarifaRegreso.getTipo();
        ManejadorArchivos.EscribirArchivo("reservas.txt", linea, header);
    }
    
    public static String codigoReserva(){
        Random random = new Random();

        // Generate 6 random capital letters
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            // Generate a random capital letter (65-90 in ASCII)
            char randomChar = (char) (random.nextInt(26) + 'A');
            randomString.append(randomChar);
        }
        return randomString.toString();
    }
}
